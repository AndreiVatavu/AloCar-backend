package com.alocar.backend.web.dto;

/**
 * Created by Andrei Vatavu on 9/3/2019
 */

public class FavoriteSongDTO {

    private String userId;
    private String image;
    private String name;
    private String licencePlate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
}
