package com.alocar.backend.web.controller;

import com.alocar.backend.security.ActiveUsersRepository;
import com.alocar.backend.service.UserService;
import com.alocar.backend.web.dto.UserCredentialsDto;
import com.alocar.backend.web.response.GenericResponse;
import com.alocar.backend.web.response.LoginResponse;
import com.alocar.backend.web.response.LoginStatusCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrei Vatavu on 5/20/2019
 */

@RestController
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login/")
    @ResponseBody
    public LoginResponse login(@RequestBody UserCredentialsDto credentials) {
        logger.info("User: " + credentials.getEmail() + " is trying to connect");
        LoginResponse response = userService.login(credentials);
        if (response.getCode() == LoginStatusCode.OK.getStatusCode()) {
            logger.info("User: " + credentials.getEmail() + " successfully connected");
        } else {
            logger.info("User: " + credentials.getEmail() + " couldn't connect");
        }
        return response;
    }

    @PostMapping(path = "/logout/")
    @ResponseBody
    public GenericResponse logout(@RequestBody String authToken) {
        userService.logout(authToken);
        logger.info("User successfully logout");
        return GenericResponse.ok();
    }
}
