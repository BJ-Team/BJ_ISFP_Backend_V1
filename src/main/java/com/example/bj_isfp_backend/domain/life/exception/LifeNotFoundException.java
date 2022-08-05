package com.example.bj_isfp_backend.domain.life.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class LifeNotFoundException extends BjISFPException {
    public static final BjISFPException EXCEPTION =
            new LifeNotFoundException();

    private LifeNotFoundException() {
        super(ErrorCode.LIFE_NOT_FOUND);
    }
}
