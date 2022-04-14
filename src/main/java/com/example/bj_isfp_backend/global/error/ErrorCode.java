package com.example.bj_isfp_backend.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    BAD_REQUEST(400, "CLIENT-400-1", "Bad Request"),

    PASSWORD_NOT_CORRECT(409, "AUTH-409-1", "Password Not Correct"),

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    USER_NAME_ALREADY_EXISTS(409, "USER-409-1", "User Name Already Exists"),
    INVALID_USER(401, "USER-401-1", "Invalid User"),

    EXPIRED_JWT(401, "JWT-401-1", "Expired Jwt"),
    INVALID_JWT(401, "JWT-401-2", "Invalid Jwt");

    private final int status;
    private final String code;
    private final String message;
}
