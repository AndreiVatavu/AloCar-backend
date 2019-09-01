package com.alocar.backend.web.dto;

/**
 * Created by Andrei Vatavu on 5/22/2019
 */
public class ContactDto {
    private int userId;
    private String name;
    private String licencePlate;
    private String image;

    public ContactDto() {
    }

    public ContactDto(int userId, String name, String licencePlate) {
        this.userId = userId;
        this.name = name;
        this.licencePlate = licencePlate;
        this.image = "https://api.androidhive.info/json/images/johnny.jpg";
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
