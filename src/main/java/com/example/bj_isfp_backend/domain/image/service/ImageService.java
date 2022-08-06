package com.example.bj_isfp_backend.domain.image.service;

import com.example.bj_isfp_backend.domain.image.presentation.dto.ImageUrlResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    ImageUrlResponse imageUpload(List<MultipartFile> images);
}
