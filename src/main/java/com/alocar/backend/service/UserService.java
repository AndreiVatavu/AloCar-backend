package com.alocar.backend.service;

import com.alocar.backend.persistance.dao.CredentialsRepository;
import com.alocar.backend.persistance.dao.UserRepository;
import com.alocar.backend.persistance.model.Credentials;
import com.alocar.backend.persistance.model.UserDetails;
import com.alocar.backend.web.dto.UserDetailsDto;
import com.alocar.backend.web.error.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Andrei Vatavu on 4/23/2019
 */

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int registerNewUserAccount(UserDetailsDto userDto) {
        if (emailExists(userDto.getEmailAddress())) {
            throw new UserAlreadyExistException("There is already an account with email address: " + userDto.getEmailAddress());
        }
        UserDetails user = new UserDetails.UserBuilder()
                .withFirstName(userDto.getFirstName())
                .withLastName(userDto.getLastName())
                .withEmail(userDto.getEmailAddress())
                .withPhoneNumber(userDto.getPhoneNumber())
                .build();
        Credentials credentials = new Credentials();
        credentials.setPasswordHash(passwordEncoder.encode(userDto.getPassword()));

        UserDetails ret = userRepository.save(user);
        credentials.setUserId(ret.getUserId());
        credentialsRepository.save(credentials);

        return 0;
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
