package com.rmarrugo.test.infrastructure.apirest.advicer.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ErrorResponseDto {
    LocalDateTime timestamp;
    String code;
    Integer status;
    String error;
    String message;
    String path;
    List<Object> details;

    public ErrorResponseDto(LocalDateTime timestamp, String code, Integer status, String error,
                            String message, String path, List<Object> details) {
        this.timestamp = timestamp;
        this.code = code;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.details = details;
    }
}