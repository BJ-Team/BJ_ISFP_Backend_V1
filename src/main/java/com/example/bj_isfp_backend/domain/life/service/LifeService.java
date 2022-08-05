package com.example.bj_isfp_backend.domain.life.service;

import com.example.bj_isfp_backend.domain.life.presentation.dto.request.LifeRequest;
import com.example.bj_isfp_backend.domain.life.presentation.dto.response.QueryLifeResponse;

public interface LifeService {
    void createLife(LifeRequest lifeRequest);

    void updateLife(Long lifeId, LifeRequest lifeRequest);

    QueryLifeResponse queryLife();

    void deleteLife(Long lifeId);
}
