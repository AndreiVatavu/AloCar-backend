package com.alocar.backend.web.response;

/**
 * Created by Andrei Vatavu on 5/21/2019
 */
public enum SignUpStatusCode {
    OK(0),
    FAIL(-1),
    INVALID_FIRST_NAME(1, "firstName"),
    INVALID_LAST_NAME(2, "lastName"),
    INVALID_EMAIL_ADDRESS(3, "emailAddress"),
    INVALID_PHONE_NUMBER(4, "phoneNumber"),
    INVALID_PASSWORD(5, "password"),
    USER_ALREADY_EXIST(6);

    int statusCode;
    String field;

    SignUpStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    SignUpStatusCode(int statusCode, String field) {
        this.statusCode = statusCode;
        this.field = field;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getField() {
        return field;
    }

    public static SignUpStatusCode fromString(String field) {
        if (field == null) {
            return null;
        }
        for (SignUpStatusCode status : SignUpStatusCode.values()) {
            if (field.equals(status.getField())) {
                return status;
            }
        }
        return null;
    }
}
