package com.alocar.backend.persistance.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Andrei Vatavu on 4/11/2019
 */

@Entity
@Table(schema = "Users", name = "user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private Date dateOfBirth;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp registerDate;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp modificationDate;

    public UserDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public Timestamp getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }

    public static class UserBuilder {
        private String userId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String gender = null;
        private Date dateOfBirth = null;

        public UserBuilder() {
        }

        public UserBuilder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder withDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserDetails build() {
            UserDetails user = new UserDetails();
            user.setUserId(this.userId);
            user.setFirstName(this.firstName);
            user.setLastName(this.lastName);
            user.setEmail(this.email);
            user.setPhoneNumber(this.phoneNumber);
            user.setGender(this.gender);
            user.setDateOfBirth(this.dateOfBirth);
            return user;
        }
    }
}