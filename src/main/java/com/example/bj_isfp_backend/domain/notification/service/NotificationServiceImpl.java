package com.example.bj_isfp_backend.domain.notification.service;

import com.example.bj_isfp_backend.domain.notification.domain.NotificationEntity;
import com.example.bj_isfp_backend.domain.notification.domain.repository.NotificationRepository;
import com.example.bj_isfp_backend.domain.notification.exception.NotificationNotFoundException;
import com.example.bj_isfp_backend.domain.notification.presentation.dto.NotificationListResponse;
import com.example.bj_isfp_backend.domain.notification.presentation.dto.NotificationListResponse.NotificationResponse;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private final UserFacade userFacade;
    private final NotificationRepository notificationRepository;

    @Override
    @Transactional
    public void WatchedNotification(Long notificationId) {
        NotificationEntity notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> NotificationNotFoundException.EXCEPTION);

        notification.isWatched();
    }

    @Override
    @Transactional(readOnly = true)
    public NotificationListResponse queryNotification() {

        User user = userFacade.getCurrentUser();

        List<NotificationResponse> notificationResponseList = notificationRepository.findByUser(user)
                .stream()
                .map(notificationEntity -> NotificationResponse.builder()
                        .id(notificationEntity.getId())
                        .title(notificationEntity.getTitle())
                        .content(notificationEntity.getContent())
                        .isWatch(notificationEntity.getIsWatch())
                        .data(notificationEntity.getData())
                        .build())
                .collect(Collectors.toList());

        return NotificationListResponse.builder()
                .notificationResponseList(notificationResponseList)
                .build();
    }
}
