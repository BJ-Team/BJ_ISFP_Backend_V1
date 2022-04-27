package com.example.bj_isfp_backend.domain.notification.service;

import com.example.bj_isfp_backend.domain.notification.domain.NotificationEntity;
import com.example.bj_isfp_backend.domain.notification.domain.repository.NotificationRepository;
import com.example.bj_isfp_backend.domain.notification.exception.NotificationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    @Transactional
    public void WatchedNotification(Long notificationId) {
        NotificationEntity notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> NotificationNotFoundException.EXCEPTION);

        notification.isWatched();
    }
}
