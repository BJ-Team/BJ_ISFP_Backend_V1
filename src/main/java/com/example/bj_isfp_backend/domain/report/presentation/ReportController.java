package com.example.bj_isfp_backend.domain.report.presentation;

import com.example.bj_isfp_backend.domain.report.presentation.dto.CreateReportRequest;
import com.example.bj_isfp_backend.domain.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void reportPost(@RequestBody @Valid CreateReportRequest createReportRequest) {
        reportService.reportPost(createReportRequest);
    }
}
