package com.example.bj_isfp_backend.global.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class UploadFileFailedException extends BjISFPException {
    public static final UploadFileFailedException EXCEPTION =
            new UploadFileFailedException();

    private UploadFileFailedException() {
        super(ErrorCode.UPLOAD_FILE_FAILED);
    }
}
