package com.example.bj_isfp_backend.domain.user.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;

public class NameAlreadyExistsException extends BjISFPException {
    public static NameAlreadyExistsException EXCEPTION =
            new NameAlreadyExistsException();

    private NameAlreadyExistsException() {
        super(Erorr)
    }
}
