package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.domain.repository.UserRepository;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QuerySoldResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QuerySoldResponse.SoldResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MyProfileServiceImpl implements MyProfileService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public QueryMyInfoResponse queryMyPage() {

        User user = userFacade.getCurrentUser();

        return QueryMyInfoResponse.builder()
                .name(user.getName())
                .nowMyLocation(user.getNowMyLocation())
                .UserProfile(user.getUserProfile())
                .build();
    }

    @Override
    public QuerySoldResponse querySold() {

        List<SoldResponse> soldResponseList = userRepository.queryMyPageSoldList();

        return QuerySoldResponse.builder()
                .soldResponseList(soldResponseList)
                .build();
    }
}
