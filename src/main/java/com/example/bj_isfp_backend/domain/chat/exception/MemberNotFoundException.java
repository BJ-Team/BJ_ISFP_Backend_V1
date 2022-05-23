package com.example.bj_isfp_backend.domain.chat.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class MemberNotFoundException extends BjISFPException {
    public static final MemberNotFoundException EXCEPTION =
            new MemberNotFoundException();

    private MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
