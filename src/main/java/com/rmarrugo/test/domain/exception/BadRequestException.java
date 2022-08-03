package com.rmarrugo.test.domain.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends GenericException {

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }

}
