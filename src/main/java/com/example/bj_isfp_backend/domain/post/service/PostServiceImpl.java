package com.example.bj_isfp_backend.domain.post.service;

import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.post.domain.repository.PostRepository;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostDetailsVO.PostVO;
import com.example.bj_isfp_backend.domain.post.domain.repository.vo.PostListVO;
import com.example.bj_isfp_backend.domain.post.facade.PostFacade;
import com.example.bj_isfp_backend.domain.post.presentation.dto.request.PostRequest;
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
    private final PostFacade postFacade;
    private final PostRepository postRepository;

    @Override
    @Transactional
    public void createPost(PostRequest createPostRequest) {

        User user = userFacade.getCurrentUser();

        postRepository.save(
                Post.builder()
                        .title(createPostRequest.getTitle())
                        .content(createPostRequest.getContent())
                        .category(createPostRequest.getCategory())
                        .price(createPostRequest.getPrice())
                        .location(user.getLocation())
                        .postImage(createPostRequest.getPostImage())
                        .user(user)
                        .build()
        );
    }

    @Override
    @Transactional
    public void deletePost(Long postId) {

        User user = userFacade.getCurrentUser();

        Post post = postFacade.getPostById(postId);

        if (!post.getUser().equals(user))
            throw InvalidUserException.EXCEPTION;

        postRepository.delete(post);
    }

    @Override
    @Transactional(readOnly = true)
    public PostListVO queryPostList() {

        List<PostListVO.PostResponse> postList = postRepository.queryPostList();

        return PostListVO.builder()
                .postList(postList)
                .build();
    }

    @Override
    public PostVO queryPostDetails(Long postId) {
        return postRepository.queryPostDetails(postId);
    }

    @Override
    @Transactional
    public void updatePost(Long postId, PostRequest postRequest) {

        User user = userFacade.getCurrentUser();

        Post post = postFacade.getPostById(postId);

        if (!post.getUser().equals(user))
            throw InvalidUserException.EXCEPTION;

        post.updatePost(
                postRequest.getTitle(),
                postRequest.getContent(),
                postRequest.getCategory(),
                postRequest.getPrice(),
                user.getLocation(),
                postRequest.getPostImage());
    }
}
