package com.younes.saas.infra.adapters.out.persistence.exceptions;

public class UnauthorizedException extends BusinessException{
    public UnauthorizedException(String message) {
        super(message);
    }
}
