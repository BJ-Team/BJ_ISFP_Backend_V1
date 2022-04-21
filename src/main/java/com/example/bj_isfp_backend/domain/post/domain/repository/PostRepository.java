package com.example.bj_isfp_backend.domain.post.domain.repository;

import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long>, PostRepositoryCustom {
    Optional<Post> findByUser(User user);
}
