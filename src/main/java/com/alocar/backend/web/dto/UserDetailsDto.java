package com.alocar.backend.web.dto;

import com.alocar.backend.validation.ValidEmail;
import com.alocar.backend.validation.ValidPhoneNumber;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Andrei Vatavu on 4/23/2019
 */

public class UserDetailsDto {

    @NotNull(message = "{Invalid.empty.firstname}")
    @Size(min = 1, message = "{Invalid.firstName.size}")
    private String firstName;

    @NotNull(message = "{Invalid.empty.lastname}")
    @Size(min = 1, message = "{Invalid.lastName.size}")
    private String lastName;

    @NotNull
    @ValidEmail
    private String emailAddress;

    @ValidPhoneNumber
    @NotNull
    private String phoneNumber;

    @NotNull(message = "{Password can't be empty}")
    @Size(min = 1, message = "{Invalid.empty.password}")
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("First name: ").append(this.firstName)
                .append(", Last name: ").append(this.lastName)
                .append(", E-mail address: ").append(this.emailAddress)
                .append(", Phone number: ").append(this.phoneNumber);
        return str.toString();
    }
}
