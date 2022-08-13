package com.example.bj_isfp_backend.domain.life.service;

import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeDetailsVO.LifeVO;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeListVO;
import com.example.bj_isfp_backend.domain.life.presentation.dto.request.LifeRequest;

public interface LifeService {
    void createLife(LifeRequest lifeRequest);

    void updateLife(Long lifeId, LifeRequest lifeRequest);

    LifeListVO queryLife();

    LifeVO queryLifeDetails(Long lifeId);

    void deleteLife(Long lifeId);
}
