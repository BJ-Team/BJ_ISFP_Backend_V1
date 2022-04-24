package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.like.domain.repository.LikeRepository;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryUserPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LikedServiceImpl implements LikedService {

    private final UserFacade userFacade;
    private final LikeRepository likeRepository;

    @Override
    @Transactional(readOnly = true)
    public QueryUserPostResponse queryMyPageLiked() {

        User user = userFacade.getCurrentUser();

        return queryLikedList(user);
    }

    @Override
    @Transactional(readOnly = true)
    public QueryUserPostResponse queryUserLiked(Long userId) {

        User user = userFacade.getUserByUserId(userId);

        return queryLikedList(user);
    }

    private QueryUserPostResponse queryLikedList(User user) {

        List<QueryUserPostResponse.UserPost> userPostList = likeRepository.findByUser(user)
                .stream()
                .map(like -> QueryUserPostResponse.UserPost.builder()
                        .userId(user.getId())
                        .postId(like.getPost().getId())
                        .title(like.getPost().getTitle())
                        .location(user.getLocation())
                        .createTime(like.getPost().getCreateTime())
                        .price(like.getPost().getPrice())
                        .postImage(like.getPost().getPostImage())
                        .build())
                .collect(Collectors.toList());

        return QueryUserPostResponse.builder()
                .userPostList(userPostList)
                .build();
    }
}
