package com.example.bj_isfp_backend.domain.chat.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class RoomNotFoundException extends BjISFPException {
    public static final RoomNotFoundException EXCEPTION =
            new RoomNotFoundException();

    private RoomNotFoundException() {
        super(ErrorCode.ROOM_NOT_FOUND);
    }
}
