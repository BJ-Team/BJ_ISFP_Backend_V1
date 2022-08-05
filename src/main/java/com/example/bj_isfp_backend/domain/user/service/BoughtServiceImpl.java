package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.buy.domain.repository.BuyRepository;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryUserPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoughtServiceImpl implements BoughtService {

    private final UserFacade userFacade;
    private final BuyRepository buyRepository;

    @Override
    public QueryUserPostResponse queryMyPageBought() {

        User user = userFacade.getCurrentUser();

        return queryBoughtList(user);
    }

    @Override
    public QueryUserPostResponse queryUserBought(Long userId) {

        User user = userFacade.getUserByUserId(userId);

        return queryBoughtList(user);
    }

    private QueryUserPostResponse queryBoughtList(User user) {

        List<QueryUserPostResponse.UserPost> userPostList = buyRepository.findByUser(user)
                .stream()
                .map(buy -> QueryUserPostResponse.UserPost.builder()
                        .userId(user.getId())
                        .postId(buy.getPost().getId())
                        .title(buy.getPost().getTitle())
                        .location(user.getLocation())
                        .createTime(buy.getPost().getCreateTime())
                        .price(buy.getPost().getPrice())
                        .postImage(buy.getPost().getPostImage())
                        .build())
                .collect(Collectors.toList());

        return QueryUserPostResponse.builder()
                .userPostList(userPostList)
                .build();
    }
}
