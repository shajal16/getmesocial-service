package com.kamal.getmesocial.resources;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.S3Object;
import com.kamal.getmesocial.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/files")
public class FileResource {

    @Autowired
    private FileService fileService;

    @PostMapping
    public boolean upload(@RequestPart(name = "file") MultipartFile file){
        return fileService.upload(file);
    }

    @GetMapping("/view")
    public void view(@RequestParam(name = "key") String key, HttpServletResponse response) throws IOException {
        S3Object obj = fileService.getFile(key);
        response.setContentType(obj.getObjectMetadata().getContentType());
        response.getOutputStream().write(obj.getObjectContent().readAllBytes());
    }

    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> download(@RequestParam(name = "key") String key) throws IOException {
        S3Object obj = fileService.getFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(obj.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION, "attachment; filename=\""+ key + "\"")
                .body(new ByteArrayResource(obj.getObjectContent().readAllBytes()));
    }
    @DeleteMapping
    public void delete(@RequestParam(name = "key") String key){
        fileService.deleteFile(key);
    }

}
