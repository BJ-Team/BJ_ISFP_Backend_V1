package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyPostResponse;

public interface MyProfileService {

    QueryMyInfoResponse queryMyPageInfo();

    QueryMyPostResponse queryMyPageSold();

    QueryMyPostResponse queryMyPageLiked();

    QueryMyPostResponse queryMyPageBought();
}
