package com.rmarrugo.test.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_FIELDS("INVALID_FIELDS", "There are invalid fields"),
    ACTIVITY_NOT_FOUND("ACTIVITY_NOT_FOUND", "Activity not found"),
    EMPLOYEE_NOT_FOUND("EMPLOYEE_NOT_FOUND", "Employee not found"),
    INVALID_EXECUTION_DATE("INVALID_EXECUTION_DATE", "Invalida execution date");

    private final String code;
    private final String description;

}
