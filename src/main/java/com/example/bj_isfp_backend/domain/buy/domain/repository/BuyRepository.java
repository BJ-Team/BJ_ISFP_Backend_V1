package com.example.bj_isfp_backend.domain.buy.domain.repository;

import com.example.bj_isfp_backend.domain.buy.domain.Buy;
import com.example.bj_isfp_backend.domain.post.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BuyRepository extends CrudRepository<Buy, Long> {
    Optional<Buy> findByPost(Post post);
}
