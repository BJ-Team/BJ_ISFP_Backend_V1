package com.example.bj_isfp_backend.domain.image.service;

import com.example.bj_isfp_backend.domain.image.presentation.dto.ImageUrlResponse;
import com.example.bj_isfp_backend.infrastructure.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    private final S3Facade s3Facade;

    @Override
    @Transactional(readOnly = true)
    public ImageUrlResponse imageUpload(List<MultipartFile> images) {
        List<String> image = images.stream()
                .map(s3Facade::uploadImage)
                .collect(Collectors.toList());

        return new ImageUrlResponse(image);
    }
}
