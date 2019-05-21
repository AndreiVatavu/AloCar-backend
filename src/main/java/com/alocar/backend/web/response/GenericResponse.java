package com.alocar.backend.web.response;

/**
 * Created by Andrei Vatavu on 5/21/2019
 */
public class GenericResponse {
    private int code;
    private String message;

    public GenericResponse() {

    }

    public GenericResponse(int code) {
        this.code = code;
    }

    public GenericResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static GenericResponse ok() {
        return new GenericResponse(0, "OK");
    }

    public static GenericResponse failed() {
        return new GenericResponse(-1, "FAIL");
    }
}
