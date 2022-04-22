package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryProfileResponse;

public interface ProfileService {

    QueryProfileResponse queryProfile(Long userId);

    
}
