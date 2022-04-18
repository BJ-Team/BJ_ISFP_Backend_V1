package com.example.bj_isfp_backend.domain.post.service;

import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.post.domain.repository.PostRepository;
import com.example.bj_isfp_backend.domain.post.exception.PostNotFoundException;
import com.example.bj_isfp_backend.domain.post.presentation.dto.request.CreatePostRequest;
import com.example.bj_isfp_backend.domain.post.presentation.dto.response.QueryPostResponse;
import com.example.bj_isfp_backend.domain.post.presentation.dto.response.QueryPostResponse.PostResponse;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.exception.InvalidUserException;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional
    public void deletePost(Long postId) {

        User user = userFacade.getCurrentUser();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if (!post.getUser().equals(user))
            throw InvalidUserException.EXCEPTION;

        postRepository.delete(post);
    }

    @Override
    @Transactional(readOnly = true)
    public QueryPostResponse queryPostList() {

        List<PostResponse> postList = postRepository.queryPostList();

        return QueryPostResponse.builder()
                .now_my_location(null)
                .postResponse(postList)
                .build();
    }
}
