package com.example.bj_isfp_backend.domain.notification.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class NotificationNotFoundException extends BjISFPException {
    public static final BjISFPException EXCEPTION =
            new NotificationNotFoundException();

    private NotificationNotFoundException() {
        super(ErrorCode.NOTIFICATION_NOT_FOUND);
    }
}
