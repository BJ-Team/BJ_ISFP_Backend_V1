package com.example.bj_isfp_backend.global.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class SaveImageFailedException extends BjISFPException {
    public static final BjISFPException EXCEPTION =
            new SaveImageFailedException();

    private SaveImageFailedException() {
        super(ErrorCode.SAVE_IMAGE_FAILED);
    }
}
