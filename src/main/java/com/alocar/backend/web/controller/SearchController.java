package com.alocar.backend.web.controller;

import com.alocar.backend.service.UserService;
import com.alocar.backend.web.dto.ContactDto;
import com.alocar.backend.web.util.YouTubeUtil;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
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

    @GetMapping("/searchYouTube/")
    public void searchYouTube() throws Exception {
        YouTube youtubeService = YouTubeUtil.getService();
        // Define and execute the API request
        YouTube.Search.List request = youtubeService.search()
                .list("snippet");
        SearchListResponse response = request.setMaxResults(25L)
                .setQ("surfing")
                .execute();
        System.out.println(response);
    }

}
