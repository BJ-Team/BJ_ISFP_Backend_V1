package com.example.bj_isfp_backend.global.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class ImageValueNotFoundException extends BjISFPException {

    public static final BjISFPException EXCEPTION =
            new ImageValueNotFoundException();

    private ImageValueNotFoundException() {
        super(ErrorCode.IMAGE_VALUE_NOT_FOUND);
    }
}
