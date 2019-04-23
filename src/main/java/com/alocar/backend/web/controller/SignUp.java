package com.alocar.backend.web.controller;

import com.alocar.backend.service.IUserService;
import com.alocar.backend.web.dto.SignUpRequest;
import com.alocar.backend.persistance.dao.UserRepository;
import com.alocar.backend.persistance.model.UserDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrei Vatavu on 4/11/2019
 */

@RestController
public class SignUp {

    private Logger logger = Logger.getLogger(SignUp.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpRequest signUpRequest) {
        logger.info("Trying to create a new user");
        userService.registerNewUserAccount(signUpRequest);
        logger.info("UserDetails successfully registered");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/test_insert")
    public ResponseEntity testInsert(@RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String email,
                                     @RequestParam String phone) {
        logger.info("Trying to create a new user");
        UserDetails user = new UserDetails.UserBuilder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEmail(email)
                .withPhoneNumber(phone)
                .build();
        userRepository.save(user);
        logger.info("UserDetails successfully registered");
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
