package com.example.bj_isfp_backend.domain.image.service;

import com.example.bj_isfp_backend.domain.image.presentation.dto.ImageResponse;
import com.example.bj_isfp_backend.infrastructure.s3.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final S3Util s3Util;

    @Transactional(readOnly = true)
    public ImageResponse queryImage(List<MultipartFile> imageList) {
        List<String> image = imageList.stream()
                .map(s3Util::upload)
                .collect(Collectors.toList());

        return ImageResponse.builder()
                .image(image)
                .build();
    }
}
