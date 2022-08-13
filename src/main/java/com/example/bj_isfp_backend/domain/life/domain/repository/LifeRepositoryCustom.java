package com.example.bj_isfp_backend.domain.life.domain.repository;

import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeDetailsVO.LifeVO;
import com.example.bj_isfp_backend.domain.life.domain.repository.vo.LifeListVO.LifeResponse;

import java.util.List;

public interface LifeRepositoryCustom {

    List<LifeResponse> queryLifeList();

    LifeVO queryLifeDetails(Long lifeId);
}
