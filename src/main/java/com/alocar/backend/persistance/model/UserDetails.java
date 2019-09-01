package com.alocar.backend.persistance.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Andrei Vatavu on 4/11/2019
 */

@Entity
@Table(schema = "Users", name = "user_details")
public class UserDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

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

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<CarsDetails> carsDetailsSet;

    private UserDetails() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Set<CarsDetails> getCarsDetailsSet() {
        return carsDetailsSet;
    }

    public void setCarsDetailsSet(Set<CarsDetails> carsDetailsSet) {
        this.carsDetailsSet = carsDetailsSet;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String gender = null;
        private Date dateOfBirth = null;

        public UserBuilder() {
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
