package com.alocar.backend.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrei Vatavu on 5/21/2019
 */

@Component
public class ActiveUsersRepository {
    private  Map<String, Integer> users;

    public ActiveUsersRepository() {
        users = new HashMap<>();
    }

    public int getUser(String authToken) {
        return users.get(authToken);
    }

    public void addUser(String authToken, int userId) {
        users.put(authToken, userId);
    }

    public void deleteUser(String authToken) {
        users.remove(authToken);
    }
}
