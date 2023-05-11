package com.calpyte.user.controller;

import com.calpyte.user.entity.Images;
import com.calpyte.user.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class ImageUploadController {

    @Autowired
    private ImageService imageService;


    @PostMapping("/image")
    public ResponseEntity<Images> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(imageService.saveImage(file),HttpStatus.OK);
    }

}
