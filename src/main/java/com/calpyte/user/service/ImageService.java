package com.calpyte.user.service;

import com.calpyte.user.entity.Images;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImageService {

    Images saveImage(MultipartFile file) throws IOException;
}
