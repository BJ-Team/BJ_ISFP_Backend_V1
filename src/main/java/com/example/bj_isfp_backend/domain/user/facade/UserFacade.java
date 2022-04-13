package com.example.bj_isfp_backend.domain.user.facade;

import com.example.bj_isfp_backend.domain.user.domain.repository.UserRepository;
import com.example.bj_isfp_backend.domain.user.exception.NameAlreadyExistsException;
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
}
