package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyInformationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MyProfileServiceImpl implements MyProfileService {

    private final UserFacade userFacade;

    @Override
    @Transactional(readOnly = true)
    public QueryMyInformationResponse queryMyPage() {

        User user = userFacade.getCurrentUser();

        return QueryMyInformationResponse.builder()
                .name(user.getName())
                .nowMyLocation(null)
                .UserProfile(user.getUserProfile())
                .build();
    }
}
