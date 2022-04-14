package com.example.bj_isfp_backend.domain.user.facade;

import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.domain.repository.UserRepository;
import com.example.bj_isfp_backend.domain.user.exception.NameAlreadyExistsException;
import com.example.bj_isfp_backend.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByAccountId(accountId);
    }

    public void nameAlreadyExists(String accountId) {
        userRepository.findByAccountId(accountId)
                .orElseThrow(() -> NameAlreadyExistsException.EXCEPTION);
    }

    public User getByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
