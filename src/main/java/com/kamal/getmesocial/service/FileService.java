package com.kamal.getmesocial.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {
    public boolean upload(MultipartFile file) {
        BasicAWSCredentials cred = new BasicAWSCredentials("ak", "sk");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.CA_CENTRAL_1).build();
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            s3.putObject("gms-test-s3", file.getOriginalFilename(), file.getInputStream(), metadata);
            return true;
        } catch (AmazonServiceException | IOException e) {
            return false;

        }
    }
    public S3Object getFile(String key){
        BasicAWSCredentials cred = new BasicAWSCredentials("ak", "sk");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.CA_CENTRAL_1).build();
        return s3.getObject("gms-test-s3", key);
    }
    public void deleteFile(String key){
        BasicAWSCredentials cred = new BasicAWSCredentials("ak", "sk");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.CA_CENTRAL_1).build();
        s3.deleteObject("gms-test-s3", key);
    }
}
