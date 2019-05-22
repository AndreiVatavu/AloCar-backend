package com.alocar.backend.web.controller;

import com.alocar.backend.service.UserService;
import com.alocar.backend.web.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Andrei Vatavu on 5/22/2019
 */

@RestController
public class SearchController {

    @Autowired
    private UserService userService;

    @GetMapping("/search/")
    public List<ContactDto> search() {
        return userService.getAllContacts();
    }
}
