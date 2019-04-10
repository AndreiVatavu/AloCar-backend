package com.alocar.backend;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andrei Vatavu on 4/11/2019
 */

public interface UserRepository extends CrudRepository<UserDetails, Integer> {
    
}
