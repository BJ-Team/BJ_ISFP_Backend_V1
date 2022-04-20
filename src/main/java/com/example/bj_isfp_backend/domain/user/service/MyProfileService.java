package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMySoldResponse;

public interface MyProfileService {

    QueryMyInfoResponse queryMyPage();

    QueryMySoldResponse queryMySold();
}
