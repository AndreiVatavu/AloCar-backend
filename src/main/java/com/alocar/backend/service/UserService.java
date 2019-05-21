package com.alocar.backend.service;

import com.alocar.backend.web.dto.UserCredentialsDto;
import com.alocar.backend.web.dto.UserDetailsDto;
import com.alocar.backend.web.response.GenericResponse;
import com.alocar.backend.web.response.LoginResponse;

/**
 * Created by Andrei Vatavu on 4/23/2019
 */
public interface UserService {
    int registerNewUserAccount(UserDetailsDto request);
    LoginResponse login(UserCredentialsDto credentials);
    void logout(String authToken);
}
