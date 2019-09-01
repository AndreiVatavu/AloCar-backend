package com.alocar.backend.web.response;

/**
 * Created by Andrei Vatavu on 5/21/2019
 */
public class LoginResponse {
    private int code;
    private String message;
    private String authToken;
    private int uid;

    public LoginResponse() {

    }

    public LoginResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
