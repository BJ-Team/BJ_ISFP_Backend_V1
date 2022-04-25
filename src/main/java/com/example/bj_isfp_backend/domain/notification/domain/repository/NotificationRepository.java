package com.example.bj_isfp_backend.domain.notification.domain.repository;

import com.example.bj_isfp_backend.domain.notification.domain.Notification;
import com.example.bj_isfp_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
    Optional<Notification> findByUser(User user);
}
