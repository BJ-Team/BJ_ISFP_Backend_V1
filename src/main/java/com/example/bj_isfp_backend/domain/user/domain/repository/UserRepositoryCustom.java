package com.example.bj_isfp_backend.domain.user.domain.repository;

import com.example.bj_isfp_backend.domain.user.domain.repository.vo.UserVO;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QuerySoldResponse.SoldResponse;

import java.util.List;

public interface UserRepositoryCustom {

    UserVO queryUserInfo();

    List<SoldResponse> queryMyPageSoldList();
}
