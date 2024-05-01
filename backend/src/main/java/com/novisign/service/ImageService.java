package com.novisign.service;


import com.novisign.domain.ImageDto;
import com.novisign.domain.RequestAddImage;
import com.novisign.entities.Image;
import com.novisign.exception.AppException;
import com.novisign.mappers.ImageMapper;
import com.novisign.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ImageService {

    private static final String TAG = "ImageService ::";

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public ImageDto addImage(RequestAddImage requestAddImage){
        log.info(TAG + "addImage");
        Image save = imageRepository.save(imageMapper.toImage(requestAddImage));
        return imageMapper.toUserDto(save);
    }

    public Long deleteImage(Long id){
        log.info(TAG + "deleteImage");
        imageRepository.findById(id)
                        .orElseThrow(() -> new AppException("Image not found", HttpStatus.NOT_FOUND));
        imageRepository.deleteById(id);
        return id;
    }
    public List<ImageDto> getAllImage(){
        log.info(TAG + "getAllImage");
        List<Image> all = imageRepository.findAll();
        if (all.isEmpty()){
            throw new AppException("Images not found", HttpStatus.NOT_FOUND);
        }
        return imageMapper.toUserDtoList(imageRepository.findAll());
    }
}
