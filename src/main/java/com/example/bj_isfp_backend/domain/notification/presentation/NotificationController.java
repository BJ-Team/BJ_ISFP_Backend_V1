package com.example.bj_isfp_backend.domain.notification.presentation;

import com.example.bj_isfp_backend.domain.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/{notification-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void watchedNotification(@PathVariable(name = "notification-id") Long notificationId) {
        notificationService.WatchedNotification(notificationId);
    }
}
