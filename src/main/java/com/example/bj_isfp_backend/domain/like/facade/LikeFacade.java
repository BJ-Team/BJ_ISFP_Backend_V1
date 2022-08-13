package com.example.bj_isfp_backend.domain.like.facade;

import com.example.bj_isfp_backend.domain.like.domain.Like;
import com.example.bj_isfp_backend.domain.like.domain.repository.LikeRepository;
import com.example.bj_isfp_backend.domain.like.exception.LikeNotFoundException;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeFacade {

    private final LikeRepository likeRepository;

    public Like getLikeByPost(Post post) {
        return likeRepository.findByPost(post)
                .orElseThrow(() -> LikeNotFoundException.EXCEPTION);
    }
}
