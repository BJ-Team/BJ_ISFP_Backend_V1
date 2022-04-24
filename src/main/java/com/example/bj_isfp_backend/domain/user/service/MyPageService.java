package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryMyInfoResponse queryMyPageInfo() {

        User user = userFacade.getCurrentUser();

        return QueryMyInfoResponse.builder()
                .name(user.getName())
                .location(user.getLocation())
                .UserProfile(user.getUserProfile())
                .build();
    }
}
