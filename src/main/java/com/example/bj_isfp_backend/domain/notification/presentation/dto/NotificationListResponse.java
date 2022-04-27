package com.example.bj_isfp_backend.domain.notification.presentation.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class NotificationListResponse {

    private final List<NotificationResponse> notificationResponseList;

    @Getter
    @Builder
    public static class NotificationResponse {
        private final Long id;
        private final String title;
        private final String content;
        private final Boolean isWatch;
        private final String data;
    }
}
