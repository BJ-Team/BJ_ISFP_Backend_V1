package com.example.bj_isfp_backend.domain.post.service;

import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.post.domain.repository.PostRepository;
import com.example.bj_isfp_backend.domain.post.presentation.dto.CreatePostRequest;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;

    @Override
    @Transactional
    public void createPost(CreatePostRequest createPostRequest) {

        User user = userFacade.getCurrentUser();

        postRepository.save(
                Post.builder()
                        .title(createPostRequest.getTitle())
                        .content(createPostRequest.getContent())
                        .category(createPostRequest.getCategory())
                        .price(createPostRequest.getPrice())
                        .user(user)
                        .build()
        );
    }
}
