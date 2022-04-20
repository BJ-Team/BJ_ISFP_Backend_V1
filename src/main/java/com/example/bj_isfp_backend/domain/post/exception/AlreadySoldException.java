package com.example.bj_isfp_backend.domain.post.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class AlreadySoldException extends BjISFPException {
    public static AlreadySoldException EXCEPTION =
            new AlreadySoldException();

    private AlreadySoldException() {
        super(ErrorCode.ALREADY_SOLD);
    }
}
