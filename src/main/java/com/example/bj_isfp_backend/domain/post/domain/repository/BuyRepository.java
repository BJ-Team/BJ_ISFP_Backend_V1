package com.example.bj_isfp_backend.domain.post.domain.repository;

import com.example.bj_isfp_backend.domain.post.domain.Buy;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BuyRepository extends CrudRepository<Buy, Long> {

    Optional<Buy> findByPost(Post post);

    Optional<Buy> findByUser(User user);
}
