package com.example.bj_isfp_backend.domain.life.domain.repository;

import com.example.bj_isfp_backend.domain.life.presentation.dto.response.QueryLifeResponse.LifeResponse;

import java.util.List;

public interface LifeRepositoryCustom {

    List<LifeResponse> queryLifeList();
}
