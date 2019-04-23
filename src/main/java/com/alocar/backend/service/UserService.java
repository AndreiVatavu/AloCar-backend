package com.alocar.backend.service;

import com.alocar.backend.persistance.dao.CredentialsRepository;
import com.alocar.backend.persistance.dao.UserRepository;
import com.alocar.backend.persistance.model.Credentials;
import com.alocar.backend.persistance.model.UserDetails;
import com.alocar.backend.web.dto.SignUpRequest;
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
    public int registerNewUserAccount(SignUpRequest signUpRequest) {
        UserDetails user = new UserDetails.UserBuilder()
                .withFirstName(signUpRequest.getFirstName())
                .withLastName(signUpRequest.getLastName())
                .withEmail(signUpRequest.getEmailAddress())
                .withPhoneNumber(signUpRequest.getPhoneNumber())
                .build();
        Credentials credentials = new Credentials();
        credentials.setUserId(user.getUserId());
        credentials.setPasswordHash(passwordEncoder.encode(signUpRequest.getPassword()));

        UserDetails ret = userRepository.save(user);
        credentialsRepository.save(credentials);

        return 0;
    }
}
