package com.example.bj_isfp_backend.infrastructure.fcm;

import com.example.bj_isfp_backend.infrastructure.fcm.dto.NotificationRequest;

public interface FcmUtil {

    void initialize();

    void sendNotification(NotificationRequest notificationRequest);
}
