package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryUserPostResponse;

public interface SoldService {

    QueryUserPostResponse queryMyPageSold();

    QueryUserPostResponse queryUserSold(Long userId);
}
