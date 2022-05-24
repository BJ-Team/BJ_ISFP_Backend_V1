package com.example.bj_isfp_backend.domain.chat.presentation.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MessageDto {

    private final Long roomId;
    private final Long messageId;
    private final String content;
    private final LocalDateTime createTime;
    private final String accountId;
}
