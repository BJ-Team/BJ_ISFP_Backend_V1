package com.example.bj_isfp_backend.domain.like.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class LikeNotFoundException extends BjISFPException {
    public static final BjISFPException EXCEPTION =
            new LikeNotFoundException();

    private LikeNotFoundException() {
        super(ErrorCode.LIKE_NOT_FOUND);
    }
}
