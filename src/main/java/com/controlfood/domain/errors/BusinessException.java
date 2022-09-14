package com.controlfood.domain.errors;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

}
