package com.alocar.backend.web.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Andrei Vatavu on 5/20/2019
 */
public class UserCredentialsDto {
    @NotNull
    private String email;

    @NotNull
    private String password;

    public UserCredentialsDto() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
