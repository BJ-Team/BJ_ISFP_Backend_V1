package com.example.bj_isfp_backend.domain.user.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class UserNotFoundException extends BjISFPException {
    public static final BjISFPException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
