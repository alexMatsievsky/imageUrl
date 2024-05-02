package com.novisign;

import com.novisign.domain.ImageDto;
import com.novisign.domain.RequestAddImage;
import com.novisign.entities.Image;
import com.novisign.repository.ImageRepository;
import com.novisign.service.ImageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
class BackendApplicationTests {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageRepository imageRepository;


    @Test
    public void imageRepository_whenSaveAndRetrieveEntity_thenOK() {
        Image entity = imageRepository
                .save(new Image(1L, "test",1000));
        imageRepository.findById(entity.getId())
                .stream()
                .findAny()
                .ifPresent(imageById -> {
                    assertNotNull(imageById);
                    assertEquals(entity.getId(), imageById.getId());
                    assertEquals(entity.getUrl(), imageById.getUrl());
                    assertEquals(entity.getDuration(), imageById.getDuration());
                });
    }

    @Test
    public void imageService_addImageAndRetrieveEntity_thenOK(){
        ImageDto test = imageService.addImage(new RequestAddImage("test", "1000"));
        imageService.getAllImage().stream()
                .filter(imageDto -> imageDto.getId().equals(test.getId()))
                .findAny()
                .ifPresent(imageById -> {
                    assertNotNull(imageById);
                    assertEquals(test.getUrl(), imageById.getUrl());
                    assertEquals(test.getDuration(), imageById.getDuration());
                });
    }
}
