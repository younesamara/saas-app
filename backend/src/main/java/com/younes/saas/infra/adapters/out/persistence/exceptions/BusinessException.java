package com.younes.saas.infra.adapters.out.persistence.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String message;

    public BusinessException(final String message) {
        super(message);
        this.message = message;
    }
}
