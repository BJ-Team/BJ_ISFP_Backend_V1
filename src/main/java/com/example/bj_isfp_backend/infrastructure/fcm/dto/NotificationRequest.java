package com.example.bj_isfp_backend.infrastructure.fcm.dto;

import com.example.bj_isfp_backend.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotificationRequest {

    private final User user;
    private final String title;
    private final String content;
    private final String data;
    private final String clickAction;
}
