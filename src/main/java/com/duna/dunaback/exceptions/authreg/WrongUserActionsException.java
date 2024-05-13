package com.duna.dunaback.exceptions.authreg;

public class WrongUserActionsException extends AuthOrRegistrationException {
    public WrongUserActionsException(String message) {
        super(message);
    }
}
