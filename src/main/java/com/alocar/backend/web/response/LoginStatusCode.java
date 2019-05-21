package com.alocar.backend.web.response;

/**
 * Created by Andrei Vatavu on 5/21/2019
 */
public enum LoginStatusCode {

    OK(0),
    FAIL(-1),
    WRONG_CREDENTIALS(1);

    int statusCode;

    LoginStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
