package com.alocar.backend.service;

import com.alocar.backend.persistance.dao.CredentialsRepository;
import com.alocar.backend.persistance.dao.UserRepository;
import com.alocar.backend.persistance.model.Credentials;
import com.alocar.backend.persistance.model.UserDetails;
import com.alocar.backend.security.ActiveUsersRepository;
import com.alocar.backend.web.dto.ContactDto;
import com.alocar.backend.web.dto.UserCredentialsDto;
import com.alocar.backend.web.dto.UserDetailsDto;
import com.alocar.backend.web.error.UserAlreadyExistException;
import com.alocar.backend.web.response.LoginResponse;
import com.alocar.backend.web.response.LoginStatusCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by Andrei Vatavu on 4/23/2019
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ActiveUsersRepository activeUsersRepository;

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public int registerNewUserAccount(UserDetailsDto userDto) {
        if (emailExists(userDto.getEmailAddress())) {
            throw new UserAlreadyExistException("There is already an account with this email address");
        }

        if (phoneNumberExists(userDto.getPhoneNumber())) {
            throw new UserAlreadyExistException("There is already an account with this phone number");
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

    @Override
    public LoginResponse login(UserCredentialsDto credentialsDto) {
        LoginResponse loginResponse = new LoginResponse();
        UserDetails userDetails = userRepository.findByEmail(credentialsDto.getEmail());
        if (userDetails == null) {
            loginResponse.setCode(LoginStatusCode.WRONG_CREDENTIALS.getStatusCode());
            loginResponse.setMessage("Wrong Credentials");
            return loginResponse;
        }
        Credentials credentials = credentialsRepository.findByUserId(userDetails.getUserId());
        if (credentials == null) {
            loginResponse.setCode(LoginStatusCode.FAIL.getStatusCode());
            loginResponse.setMessage("Error");
            return loginResponse;
        }

        if (passwordEncoder.matches(credentialsDto.getPassword(), credentials.getPasswordHash())) {
            loginResponse.setCode(LoginStatusCode.OK.getStatusCode());
            loginResponse.setMessage("Success login");
            loginResponse.setAuthToken(UUID.randomUUID().toString());
            loginResponse.setUid(credentials.getUserId());
            activeUsersRepository.addUser(loginResponse.getAuthToken(), credentials.getUserId());
        } else {
            loginResponse.setCode(LoginStatusCode.FAIL.getStatusCode());
            loginResponse.setMessage("Error");
        }
        return loginResponse;
    }

    @Override
    public void logout(String authToken) {
        try {
            activeUsersRepository.deleteUser(authToken);
        } catch (Error e) {
            logger.warn(e.getMessage());
        }
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    private boolean phoneNumberExists(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber) != null;
    }

    @Override
    public List<ContactDto> getAllContacts() {
        try {
            List<ContactDto> contacts = userRepository.getContacts();
            return contacts;
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return null;
        }
    }
}
