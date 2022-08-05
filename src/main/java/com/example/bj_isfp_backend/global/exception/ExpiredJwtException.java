package com.example.bj_isfp_backend.global.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class ExpiredJwtException extends BjISFPException {
    public static final BjISFPException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
