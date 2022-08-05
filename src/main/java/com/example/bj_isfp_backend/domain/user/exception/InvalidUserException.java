package com.example.bj_isfp_backend.domain.user.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class InvalidUserException extends BjISFPException {
    public static final BjISFPException EXCEPTION =
            new InvalidUserException();

    private InvalidUserException() {
        super(ErrorCode.INVALID_USER);
    }
}
