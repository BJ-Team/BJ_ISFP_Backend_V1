package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final UserFacade userFacade;

    @Override
    @Transactional(readOnly = true)
    public QueryProfileResponse queryProfile(Long userId) {

        User user = userFacade.getUserByUserId(userId);

        return QueryProfileResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .UserProfile(user.getUserProfile())
                .build();
    }
}
