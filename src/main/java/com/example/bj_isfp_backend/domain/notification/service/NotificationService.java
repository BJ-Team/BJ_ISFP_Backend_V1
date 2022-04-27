package com.example.bj_isfp_backend.domain.notification.service;

import com.example.bj_isfp_backend.domain.notification.presentation.dto.NotificationListResponse;

public interface NotificationService {

    void WatchedNotification(Long notificationId);

    NotificationListResponse queryNotification();
}
