package com.example.bj_isfp_backend.domain.like.domain.repository;

import com.example.bj_isfp_backend.domain.like.domain.Like;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, Long> {
    Optional<Like> findByPost(Post post);
}
