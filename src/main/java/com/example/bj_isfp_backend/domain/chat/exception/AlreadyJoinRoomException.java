package com.example.bj_isfp_backend.domain.chat.exception;

import com.example.bj_isfp_backend.global.error.BjISFPException;
import com.example.bj_isfp_backend.global.error.ErrorCode;

public class AlreadyJoinRoomException extends BjISFPException {
    public static final AlreadyJoinRoomException EXCEPTION =
            new AlreadyJoinRoomException();

    private AlreadyJoinRoomException() {
        super(ErrorCode.ALREADY_JOIN_ROOM);
    }
}
