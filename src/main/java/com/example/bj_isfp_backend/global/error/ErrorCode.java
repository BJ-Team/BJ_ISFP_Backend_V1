package com.example.bj_isfp_backend.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    BAD_REQUEST(400, "CLIENT-400-1", "Bad Request");

    private final int status;
    private final String code;
    private final String message;
}
