package com.example.bj_isfp_backend.domain.like.domain.repository;

import com.example.bj_isfp_backend.domain.like.domain.Like;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, Long> {

    Optional<Like> findByPost(Post post);

    Optional<Like> findByUser(User user);
}
