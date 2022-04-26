package com.example.bj_isfp_backend.infrastructure.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.bj_isfp_backend.global.exception.UploadFileFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3Util {

    private final AmazonS3Client amazonS3Client;
    private final S3Properties s3Properties;

    public String upload(MultipartFile file) {

        String uploadFile = s3Properties.getBucket() + "/" + UUID.randomUUID() + file.getOriginalFilename();

        try {
            amazonS3Client.putObject(new PutObjectRequest(s3Properties.getBucket(), uploadFile, file.getInputStream(), null)
                    .withCannedAcl(CannedAccessControlList.AuthenticatedRead));
        } catch (Exception e) {
            throw UploadFileFailedException.EXCEPTION;
        }

        return amazonS3Client.getUrl(s3Properties.getBucket(), uploadFile).toString();
    }
}
