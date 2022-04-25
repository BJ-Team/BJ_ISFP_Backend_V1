package com.example.bj_isfp_backend.domain.notification.domain.repository;

import com.example.bj_isfp_backend.domain.notification.domain.NotificationEntity;
import com.example.bj_isfp_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NotificationRepository extends CrudRepository<NotificationEntity, Long> {
    Optional<NotificationEntity> findByUser(User user);
}
