package com.example.bj_isfp_backend.domain.commment.domain.repository;

import com.example.bj_isfp_backend.domain.commment.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
