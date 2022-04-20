package com.example.bj_isfp_backend.domain.user.domain.repository;

import com.example.bj_isfp_backend.domain.user.domain.repository.vo.SoldVO;
import com.example.bj_isfp_backend.domain.user.domain.repository.vo.UserVO;

import java.util.List;

public interface UserRepositoryCustom {

    UserVO queryUserInfo();

    List<SoldVO> queryMyPageSoldList();
}
