package com.example.bj_isfp_backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryMyInfoResponse {

    private final String name;
    private final String location;
    private final String UserProfile;
}
