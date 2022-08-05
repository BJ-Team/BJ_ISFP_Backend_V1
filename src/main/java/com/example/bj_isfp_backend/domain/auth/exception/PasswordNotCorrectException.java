package com.example.bj_isfp_backend.domain.auth.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class PasswordNotCorrectException extends BjISFPException {
    public static final BjISFPException EXCEPTION =
            new PasswordNotCorrectException();

    private PasswordNotCorrectException() {
        super(ErrorCode.PASSWORD_NOT_CORRECT);
    }
}
