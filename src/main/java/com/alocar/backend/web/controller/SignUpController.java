package com.alocar.backend.web.controller;

import com.alocar.backend.service.UserService;
import com.alocar.backend.web.dto.UserDetailsDto;
import com.alocar.backend.web.error.UserAlreadyExistException;
import com.alocar.backend.web.response.GenericResponse;
import com.alocar.backend.web.response.SignUpStatusCode;
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
    private UserService userService;

    @PostMapping("/signup")
    @ResponseBody
    public GenericResponse signUp(@RequestBody @Valid UserDetailsDto userDto) {
        logger.info("Trying to create a new user: " + userDto.toString());
        try {
            userService.registerNewUserAccount(userDto);
            logger.info("User: " + userDto.toString() + " successfully created");
            return GenericResponse.ok();
        } catch (UserAlreadyExistException e) {
            return new GenericResponse(SignUpStatusCode.USER_ALREADY_EXIST.getStatusCode(), e.getMessage());
        }
    }

    @ExceptionHandler
    public GenericResponse handleException(MethodArgumentNotValidException exception) {
        logger.warn(exception.getMessage());
        GenericResponse errorResponse = exception.getBindingResult().getFieldErrors().stream()
                .map(l -> new GenericResponse(SignUpStatusCode.fromString(l.getField()).getStatusCode(), l.getDefaultMessage()))
                .findFirst()
                .get();

        return errorResponse;
    }
}
