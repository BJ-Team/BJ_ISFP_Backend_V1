package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryUserPostResponse;

public interface LikedService {

    QueryUserPostResponse queryMyPageLiked();

    QueryUserPostResponse queryUserLiked(Long userId);
}
