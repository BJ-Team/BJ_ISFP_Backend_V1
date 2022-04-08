package com.example.bj_isfp_backend.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BjISFPException extends RuntimeException {
    private final ErrorCode errorCode;
}
