package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.domain.repository.UserRepository;
import com.example.bj_isfp_backend.domain.user.domain.repository.vo.LikeVO;
import com.example.bj_isfp_backend.domain.user.domain.repository.vo.SoldVO;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyLikeResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMySoldResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyProfileServiceImpl implements MyProfileService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public QueryMyInfoResponse queryMyPage() {

        User user = userFacade.getCurrentUser();

        return QueryMyInfoResponse.builder()
                .name(user.getName())
                .nowMyLocation(user.getNowMyLocation())
                .UserProfile(user.getUserProfile())
                .build();
    }

    @Override
    public QueryMySoldResponse queryMySold() {

        User user = userFacade.getCurrentUser();

        List<SoldVO> soldVOList = userRepository.queryMyPageSoldList();

        return new QueryMySoldResponse(soldVOList
                .stream()
                .map(soldVO ->
                        QueryMySoldResponse.MySold.builder()
                                .title(soldVO.getTitle())
                                .location(user.getNowMyLocation())
                                .build())
                .collect(Collectors.toList()));
    }

    @Override
    public QueryMyLikeResponse queryMyLike() {

        User user = userFacade.getCurrentUser();

        List<LikeVO> likeVOList = userRepository.queryMyPageLikeList();

        return new QueryMyLikeResponse(likeVOList
                .stream()
                .map(likeVO ->
                        QueryMyLikeResponse.MyLike.builder()
                                .title(likeVO.getTitle())
                                .location(user.getNowMyLocation())
                                .price(likeVO.getPrice())
                                .postImage(likeVO.getLocation())
                                .build())
                .collect(Collectors.toList()));
    }
}
