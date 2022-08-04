package com.rmarrugo.test.infrastructure.apirest.advicer;

import com.rmarrugo.test.domain.exception.ErrorCode;
import com.rmarrugo.test.domain.exception.GenericException;
import com.rmarrugo.test.domain.exception.NotFoundException;
import com.rmarrugo.test.domain.exception.BadRequestException;
import com.rmarrugo.test.infrastructure.apirest.advicer.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handle(NotFoundException ex, HttpServletRequest request) {
        return new ResponseEntity<>(
                buildErrorResponse(ex, HttpStatus.NOT_FOUND, request),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> handle(BadRequestException ex, HttpServletRequest request) {
        return new ResponseEntity<>(
                buildErrorResponse(ex, HttpStatus.BAD_REQUEST, request),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handle(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<Object> details = new ArrayList<>(ex.getBindingResult().getAllErrors());
        return new ResponseEntity<>(new ErrorResponseDto(LocalDateTime.now(), ErrorCode.INVALID_FIELDS.getCode(),
                HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), "MethodArgumentNotValidException",
                request.getRequestURL().toString(), details), HttpStatus.BAD_REQUEST);
    }

    private ErrorResponseDto buildErrorResponse(GenericException ex, HttpStatus httpStatus,
                                                HttpServletRequest request) {
        return new ErrorResponseDto(LocalDateTime.now(), ex.getErrorCode().getCode(),
                httpStatus.value(), ex.getErrorCode().getDescription(),
                ex.getMessage(), request.getRequestURL().toString(), null);
    }

}
