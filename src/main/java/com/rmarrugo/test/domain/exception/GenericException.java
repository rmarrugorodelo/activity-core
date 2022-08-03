package com.rmarrugo.test.domain.exception;

import lombok.Getter;

@Getter
public abstract class GenericException extends RuntimeException{

    private final ErrorCode errorCode;

    public GenericException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }
}
