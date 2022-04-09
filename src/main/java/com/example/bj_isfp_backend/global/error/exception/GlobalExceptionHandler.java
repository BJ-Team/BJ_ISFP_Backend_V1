package com.example.bj_isfp_backend.global.error.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BjISFPException.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(BjISFPException e) {

        ErrorCode errorCode = e.getErrorCode();

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build(),
                HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(ErrorCode.BAD_REQUEST.getStatus())
                        .code(ErrorCode.BAD_REQUEST.getCode())
                        .message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }
}
