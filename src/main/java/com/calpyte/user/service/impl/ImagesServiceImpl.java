package com.calpyte.user.service.impl;

import com.calpyte.user.entity.Images;
import com.calpyte.user.repository.ImagesRepository;
import com.calpyte.user.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class ImagesServiceImpl implements ImageService {

    @Autowired
    private ImagesRepository imagesRepository;

    public Images saveImage(MultipartFile file) throws IOException {
        Images images = new Images();
        images.setFile(file.getBytes());
        images.setName(file.getOriginalFilename());
        imagesRepository.save(images);
        return images;
    };
}
