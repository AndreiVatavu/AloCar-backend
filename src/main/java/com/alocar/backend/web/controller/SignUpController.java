package com.alocar.backend.web.controller;

import com.alocar.backend.service.IUserService;
import com.alocar.backend.persistance.dao.UserRepository;
import com.alocar.backend.web.dto.UserDetailsDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Andrei Vatavu on 4/11/2019
 */

@RestController
public class SignUpController {

    private Logger logger = Logger.getLogger(SignUpController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    @PostMapping("/signup")
    @ResponseBody
    public String signUp(@RequestBody @Valid UserDetailsDto userDto) {
        logger.info("Trying to create a new user");
        userService.registerNewUserAccount(userDto);
        logger.info("UserDetails successfully registered");
        return "OK";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(MethodArgumentNotValidException exception) {

        String errorMsg = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return errorMsg;
    }
}
