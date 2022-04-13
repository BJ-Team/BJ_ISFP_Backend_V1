package com.example.bj_isfp_backend.domain.user.facade;

import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.domain.repository.UserRepository;
import com.example.bj_isfp_backend.domain.user.exception.NameAlreadyExistsException;
import com.example.bj_isfp_backend.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public void nameAlreadyExists(String user_id) {
        userRepository.findByUser_id(user_id)
                .orElseThrow(() -> NameAlreadyExistsException.EXCEPTION);
    }

    public User getByUser_id(String user_id) {
        return userRepository.findByUser_id(user_id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
