package com.example.bj_isfp_backend.domain.report.service;

import com.example.bj_isfp_backend.domain.report.presentation.dto.CreateReportRequest;

public interface ReportService {

    void reportPost(CreateReportRequest createReportRequest);
}
