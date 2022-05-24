package com.example.bj_isfp_backend.domain.user.facade;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.domain.repository.UserRepository;
import com.example.bj_isfp_backend.domain.user.exception.NameAlreadyExistsException;
import com.example.bj_isfp_backend.domain.user.exception.UserNotFoundException;
import com.example.bj_isfp_backend.global.socket.properties.ClientProperty;
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

    public User getCurrentUser(SocketIOClient socketIOClient) {
        String accountId = socketIOClient.get(ClientProperty.USER_KEY);
        return getByAccountId(accountId);
    }

    public void nameAlreadyExists(String name) {
        if (userRepository.findByName(name).isPresent())
            throw NameAlreadyExistsException.EXCEPTION;
    }

    public User getByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
