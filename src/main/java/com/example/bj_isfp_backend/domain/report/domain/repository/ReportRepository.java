package com.example.bj_isfp_backend.domain.report.domain.repository;

import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.report.domain.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReportRepository extends CrudRepository<Report, Long> {
    Optional<Report> findByPost(Post post);
}
