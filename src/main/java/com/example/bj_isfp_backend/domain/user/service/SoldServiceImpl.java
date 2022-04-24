package com.example.bj_isfp_backend.domain.user.service;

import com.example.bj_isfp_backend.domain.post.domain.repository.PostRepository;
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
public class SoldServiceImpl implements SoldService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public QueryUserPostResponse queryMyPageSold() {

        User user = userFacade.getCurrentUser();

        return querySoldList(user);
    }

    @Override
    @Transactional(readOnly = true)
    public QueryUserPostResponse queryUserSold(Long userId) {

        User user = userFacade.getUserByUserId(userId);

        return querySoldList(user);
    }

    private QueryUserPostResponse querySoldList(User user) {

        List<QueryUserPostResponse.UserPost> userPostList = postRepository.findByUser(user)
                .stream()
                .map(post -> QueryUserPostResponse.UserPost.builder()
                        .userId(user.getId())
                        .postId(post.getId())
                        .title(post.getTitle())
                        .location(user.getLocation())
                        .createTime(post.getCreateTime())
                        .price(post.getPrice())
                        .postImage(post.getPostImage())
                        .build())
                .collect(Collectors.toList());

        return QueryUserPostResponse.builder()
                .userPostList(userPostList)
                .build();
    }
}
