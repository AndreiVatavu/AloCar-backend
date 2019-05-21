package com.alocar.backend.persistance.dao;

import com.alocar.backend.persistance.model.Credentials;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andrei Vatavu on 4/11/2019
 */

public interface CredentialsRepository extends CrudRepository<Credentials, Integer> {
    Credentials findByUserId(int userId);
}
