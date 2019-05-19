package com.alocar.backend.web.dto;

import com.alocar.backend.validation.ValidEmail;
import com.alocar.backend.validation.ValidPhoneNumber;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Andrei Vatavu on 4/23/2019
 */
public class UserDetailsDto {

    @NotNull
    @Size(min = 1)
    private String firstName;

    @NotNull
    @Size(min = 1)
    private String lastName;

    @NotNull
    @ValidEmail
    private String emailAddress;

    @ValidPhoneNumber
    @NotNull
    private String phoneNumber;

    @NotNull
    @Size(min = 1)
    private String password;

    public UserDetailsDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
