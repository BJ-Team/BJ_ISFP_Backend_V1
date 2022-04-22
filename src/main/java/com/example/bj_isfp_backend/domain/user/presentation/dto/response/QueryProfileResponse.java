package com.example.bj_isfp_backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryProfileResponse {

    private final Long userId;
    private final String name;
    private final String UserProfile;
}
