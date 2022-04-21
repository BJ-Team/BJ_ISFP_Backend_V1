package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.like.domain.repository.LikeRepository;
import com.example.bj_isfp_backend.domain.post.domain.repository.BuyRepository;
import com.example.bj_isfp_backend.domain.post.domain.repository.PostRepository;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyInfoResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyPostResponse;
import com.example.bj_isfp_backend.domain.user.presentation.dto.response.QueryMyPostResponse.MyPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyProfileServiceImpl implements MyProfileService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final BuyRepository buyRepository;

    @Override
    @Transactional(readOnly = true)
    public QueryMyInfoResponse queryMyPageInfo() {

        User user = userFacade.getCurrentUser();

        return QueryMyInfoResponse.builder()
                .name(user.getName())
                .location(user.getLocation())
                .UserProfile(user.getUserProfile())
                .build();
    }


    @Override
    @Transactional(readOnly = true)
    public QueryMyPostResponse queryMyPageSold() {

        User user = userFacade.getCurrentUser();

        List<MyPost> myPageSoldList = postRepository.findByUser(user)
                .stream()
                .map(post -> MyPost.builder()
                        .title(post.getTitle())
                        .location(user.getLocation())
                        .price(post.getPrice())
                        .postImage(post.getPostImage())
                        .build())
                .collect(Collectors.toList());

        return QueryMyPostResponse.builder()
                .myPostList(myPageSoldList)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public QueryMyPostResponse queryMyPageLiked() {

        User user = userFacade.getCurrentUser();

        List<MyPost> myPageLikedList = likeRepository.findByUser(user)
                .stream()
                .map(like -> MyPost.builder()
                        .title(like.getPost().getTitle())
                        .location(user.getLocation())
                        .price(like.getPost().getPrice())
                        .postImage(like.getPost().getPostImage())
                        .build())
                .collect(Collectors.toList());

        return QueryMyPostResponse.builder()
                .myPostList(myPageLikedList)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public QueryMyPostResponse queryMyPageBought() {

        User user = userFacade.getCurrentUser();

        List<MyPost> myPageBoughtList = buyRepository.findByUser(user)
                .stream()
                .map(buy -> MyPost.builder()
                        .title(buy.getPost().getTitle())
                        .location(user.getLocation())
                        .price(buy.getPost().getPrice())
                        .postImage(buy.getPost().getPostImage())
                        .build())
                .collect(Collectors.toList());

        return QueryMyPostResponse.builder()
                .myPostList(myPageBoughtList)
                .build();
    }

}
