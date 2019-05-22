package com.alocar.backend.persistance.dao;

import com.alocar.backend.persistance.model.UserDetails;
import com.alocar.backend.web.dto.ContactDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Andrei Vatavu on 4/11/2019
 */

public interface UserRepository extends CrudRepository<UserDetails, Integer> {

    String GET_CONTACTS_QUERY = "SELECT\n" +
            "    user.user_id,\n" +
            "    user.first_name,\n" +
            "    car.licence_plate\n" +
            "FROM Users.user_details user\n" +
            "LEFT JOIN Cars.cars_details car\n" +
            "\tON user.user_id = car.owner;";

    String GET_CONTACTS_QUERY2 = "SELECT\n" +
            "    user.user_id,\n" +
            "    concat(user.first_name, ' ', user.last_name) name\n" +
            "FROM Users.user_details user\n";

    UserDetails findByEmail(String email);

    UserDetails findByPhoneNumber(String phoneNumber);

    @Query("SELECT new com.alocar.backend.web.dto.ContactDto(user.userId, concat(user.firstName, ' ', user.lastName) , car.licencePlate)"
            + "FROM UserDetails user LEFT JOIN user.carsDetailsSet car ON user.userId = car.owner")
    List<ContactDto> getContacts();
    
}
