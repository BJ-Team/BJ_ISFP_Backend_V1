package com.example.bj_isfp_backend.domain.report.service;

import com.example.bj_isfp_backend.domain.post.domain.Post;
import com.example.bj_isfp_backend.domain.post.domain.repository.PostRepository;
import com.example.bj_isfp_backend.domain.post.exception.PostNotFoundException;
import com.example.bj_isfp_backend.domain.report.domain.Report;
import com.example.bj_isfp_backend.domain.report.domain.repository.ReportRepository;
import com.example.bj_isfp_backend.domain.report.exception.AlreadyReportedPostException;
import com.example.bj_isfp_backend.domain.report.presentation.dto.CreateReportRequest;
import com.example.bj_isfp_backend.domain.user.domain.User;
import com.example.bj_isfp_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

    private final UserFacade userFacade;
    private final ReportRepository reportRepository;
    private final PostRepository postRepository;

    @Override
    @Transactional
    public void reportPost(CreateReportRequest createReportRequest) {

        User user = userFacade.getCurrentUser();

        Post post = postRepository.findById(createReportRequest.getPostId())
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        try {
            reportRepository.save(
                    Report.builder()
                            .title(createReportRequest.getTitle())
                            .content(createReportRequest.getTitle())
                            .user(user)
                            .post(post)
                            .build()
            );
        } catch (RuntimeException e) {
            throw AlreadyReportedPostException.EXCEPTION;
        }
    }
}
