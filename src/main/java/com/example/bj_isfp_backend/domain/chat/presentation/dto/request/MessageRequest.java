package com.example.bj_isfp_backend.domain.chat.presentation.dto.request;

import com.example.bj_isfp_backend.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MessageRequest {

    private Long roomId;
    private Long messageId;
    private String content;
    private LocalDateTime createTime;
    private User user;
}
