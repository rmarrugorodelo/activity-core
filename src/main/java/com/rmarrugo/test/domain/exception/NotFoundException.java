package com.rmarrugo.test.domain.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends GenericException {

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

}
