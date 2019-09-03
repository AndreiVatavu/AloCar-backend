package com.alocar.backend.web.controller;

import com.alocar.backend.persistance.dao.FavoriteSongsRepository;
import com.alocar.backend.persistance.model.FavoriteSongs;
import com.alocar.backend.service.UserService;
import com.alocar.backend.web.dto.ContactDto;
import com.alocar.backend.web.dto.FavoriteSongDTO;
import com.alocar.backend.web.response.GenericResponse;
import com.alocar.backend.web.util.YouTubeUtil;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei Vatavu on 5/22/2019
 */

@RestController
public class SearchController {

    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteSongsRepository favoriteSongsRepository;

    @GetMapping("/search/")
    public List<ContactDto> search() {
        return userService.getAllContacts();
    }

    @GetMapping("/searchYouTube/")
    public List<ContactDto> searchYouTube(@RequestHeader String query) throws Exception {
        YouTube youtubeService = YouTubeUtil.getService();
        YouTube.Search.List request = youtubeService.search()
                .list("snippet");
        request.setKey(YouTubeUtil.API_KEY);
        SearchListResponse response = request.setMaxResults(25L)
                .setQ(query)
                .execute();

        List<ContactDto> contactDtos = new ArrayList<>();
        for (SearchResult searchResult : response.getItems()) {
            ContactDto contactDto = new ContactDto();
            contactDto.setName(searchResult.getSnippet().getTitle());
            contactDto.setImage(searchResult.getSnippet().getThumbnails().getDefault().getUrl());
            contactDto.setLicencePlate(searchResult.getId().getVideoId());
            contactDtos.add(contactDto);
        }
        return contactDtos;
    }

    @PostMapping("/saveFavorite")
    public GenericResponse saveToFavorite(@RequestBody FavoriteSongDTO favoriteSongDTO) {
        FavoriteSongs favoriteSong = new FavoriteSongs();
        favoriteSong.setImage(favoriteSongDTO.getImage());
        favoriteSong.setUserId(favoriteSongDTO.getUserId());
        favoriteSong.setName(favoriteSongDTO.getName());
        favoriteSong.setVideoId(favoriteSongDTO.getLicencePlate());

        favoriteSongsRepository.save(favoriteSong);

        return GenericResponse.ok();
    }

    @GetMapping("/getFavoriteSongs")
    public List<FavoriteSongDTO> getFavoriteSongs(@RequestHeader String userId) {
        List<FavoriteSongs> favoriteSongs = favoriteSongsRepository.findByUserId(userId);
        List<FavoriteSongDTO> favoriteSongDTOS = new ArrayList<>();

        for (FavoriteSongs favoriteSong : favoriteSongs) {
            FavoriteSongDTO favoriteSongDTO = new FavoriteSongDTO();
            favoriteSongDTO.setUserId(favoriteSong.getUserId());
            favoriteSongDTO.setImage(favoriteSong.getImage());
            favoriteSongDTO.setName(favoriteSong.getName());
            favoriteSongDTO.setLicencePlate(favoriteSong.getVideoId());
            favoriteSongDTOS.add(favoriteSongDTO);
        }

        return favoriteSongDTOS;
    }

}
