package com.example.bj_isfp_backend.domain.commment.domain.repository;

import com.example.bj_isfp_backend.domain.commment.domain.Comment;
import com.example.bj_isfp_backend.domain.life.domain.Life;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long>, CommentRepositoryCustom {
    Optional<Comment> findAllByLife(Life life);
}
