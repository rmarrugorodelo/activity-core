package com.rmarrugo.test.infrastructure.apirest.advicer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponseDto {
    private LocalDateTime timestamp;
    private String code;
    private Integer status;
    private String error;
    private String message;
    private String path;
    private List<Object> details;

    public ErrorResponseDto(LocalDateTime timestamp, String code, Integer status, String error,
                            String message, String path) {
        this.timestamp = timestamp;
        this.code = code;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}