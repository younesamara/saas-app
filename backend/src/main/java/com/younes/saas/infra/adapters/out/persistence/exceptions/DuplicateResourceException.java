package com.younes.saas.infra.adapters.out.persistence.exceptions;

public class DuplicateResourceException extends BusinessException {

    public DuplicateResourceException(String message) {
        super(message);
    }
}
