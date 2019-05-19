package com.alocar.backend.web.error;

/**
 * Created by Andrei Vatavu on 5/15/2019
 */
public final class UserAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }

    public UserAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
