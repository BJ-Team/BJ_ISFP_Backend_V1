package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryProfileResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryUserPostResponse;

public interface ProfileService {

    QueryProfileResponse queryProfile(Long userId);

    QueryUserPostResponse queryUserSold(Long userId);
}
