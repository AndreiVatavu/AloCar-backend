package com.alocar.backend.persistance.dao;

import com.alocar.backend.persistance.model.UserDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andrei Vatavu on 4/11/2019
 */

public interface UserRepository extends CrudRepository<UserDetails, Integer> {

    UserDetails findByEmail(String email);

    UserDetails findByPhoneNumber(String phoneNumber);
    
}
