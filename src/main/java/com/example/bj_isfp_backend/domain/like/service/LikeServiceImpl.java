package com.example.bj_isfp_backend.domain.like.service;

import com.example.bj_isfp_backend.domain.like.domain.Like;
import com.example.bj_isfp_backend.domain.like.domain.repository.LikeRepository;
import com.example.bj_isfp_backend.domain.like.exception.LikeNotFoundException;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.post.domain.repository.PostRepository;
import com.example.bj_isfp_backend.domain.post.exception.PostNotFoundException;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.exception.InvalidUserException;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final UserFacade userFacade;

    @Override
    @Transactional
    public void postLike(Long postId) {

        User user = userFacade.getCurrentUser();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        likeRepository.save(
                Like.builder()
                        .user(user)
                        .post(post)
                        .build());
    }

    @Override
    @Transactional
    public void postLikeCancel(Long postId) {

        User user = userFacade.getCurrentUser();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        Like like = likeRepository.findByPost(post)
                .orElseThrow(() -> LikeNotFoundException.EXCEPTION);

        if (!like.getUser().equals(user))
            throw InvalidUserException.EXCEPTION;

        likeRepository.delete(like);
    }
}
