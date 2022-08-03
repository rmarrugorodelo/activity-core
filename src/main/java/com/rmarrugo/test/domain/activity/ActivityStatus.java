package com.rmarrugo.test.domain.activity;

import com.rmarrugo.test.domain.exception.BadRequestException;
import com.rmarrugo.test.domain.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ActivityStatus {

    PENDING("PENDING", "Pendiente"),
    COMPLETED("COMPLETED", "Realizada");
    private final String code;
    private final String description;

    public static ActivityStatus fromString(String code) {
        return Arrays.stream(ActivityStatus.values())
                .filter(status -> status.code.equals(code))
                .findFirst()
                .orElseThrow(
                        () -> new BadRequestException(ErrorCode.INVALID_FIELDS)
                );
    }
}
