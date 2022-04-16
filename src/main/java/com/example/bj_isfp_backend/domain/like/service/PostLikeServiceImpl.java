package com.example.bj_isfp_backend.domain.like.service;

import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.post.domain.repository.PostRepository;
import com.example.bj_isfp_backend.domain.post.exception.PostNotFoundException;
import com.example.bj_isfp_backend.domain.like.domain.Like;
import com.example.bj_isfp_backend.domain.like.domain.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostLikeServiceImpl implements PostLikeService {

    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    @Override
    @Transactional
    public void postLike(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        
        likeRepository.save(
                Like.builder()
                        .post(post)
                        .build());
    }
}
