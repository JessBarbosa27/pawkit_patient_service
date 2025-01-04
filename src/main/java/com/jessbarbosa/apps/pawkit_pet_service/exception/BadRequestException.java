package com.jessbarbosa.apps.pawkit_pet_service.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}