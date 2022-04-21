package com.example.bj_isfp_backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryMyInfoResponse {
    private String name;
    private String location;
    private String UserProfile;
}
