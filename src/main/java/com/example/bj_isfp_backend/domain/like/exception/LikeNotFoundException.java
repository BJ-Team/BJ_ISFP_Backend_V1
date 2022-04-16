package com.example.bj_isfp_backend.domain.like.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;

public class LikeNotFoundException extends BjISFPException {
    public static LikeNotFoundException EXCEPTION =
            new LikeNotFoundException();

    private LikeNotFoundException() {
        super();
    }
}
