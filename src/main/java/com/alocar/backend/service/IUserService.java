package com.alocar.backend.service;

import com.alocar.backend.web.dto.SignUpRequest;

/**
 * Created by Andrei Vatavu on 4/23/2019
 */
public interface IUserService {
    int registerNewUserAccount(SignUpRequest request);
}
