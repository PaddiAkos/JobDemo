package com.example.project.job.demo.controller;

import com.example.project.job.demo.model.Image;
import com.example.project.job.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/{id}")
    public ResponseEntity<InputStreamResource> getImageDynamicType(@PathVariable Long id) {
        Image image = imageRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        MediaType contentType = switch(image.getExtension()) {
            case "jpg", "jpeg" -> MediaType.IMAGE_JPEG;
            case "gif" -> MediaType.IMAGE_GIF;
            case "png" -> MediaType.IMAGE_PNG;
            default -> MediaType.APPLICATION_OCTET_STREAM;
        };
        InputStream in = new ByteArrayInputStream(image.getData());
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(new InputStreamResource(in));
    }
    @PostMapping
    public ResponseEntity<Void> createAd(@RequestParam  MultipartFile file) {
        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        try (InputStream is = file.getInputStream(); ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            byte[] data = new byte[1024];
            int lem ;

            while ((lem = is.read(data))> 0){
                os.write(data,0,lem);
            }
            image.setData(os.toByteArray());
        }
        catch (IOException exception){}
        imageRepository.save(image);
        return ResponseEntity.ok().build();
    }
}