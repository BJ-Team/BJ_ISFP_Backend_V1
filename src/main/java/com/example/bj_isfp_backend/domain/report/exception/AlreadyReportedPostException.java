package com.example.bj_isfp_backend.domain.report.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class AlreadyReportedPostException extends BjISFPException {
    public static AlreadyReportedPostException EXCEPTION =
            new AlreadyReportedPostException();

    private AlreadyReportedPostException() {
        super(ErrorCode.ALREADY_REPORTED_POST);
    }
}
