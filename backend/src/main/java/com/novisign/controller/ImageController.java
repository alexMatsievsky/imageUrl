package com.novisign.controller;

import com.novisign.domain.HttpResponse;
import com.novisign.domain.RequestAddImage;
import com.novisign.mappers.ImageMapper;
import com.novisign.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class ImageController {
    private static final String TAG = "ImageController ::  ";


    private final ImageService imageService;

    @PostMapping ("/addImage")
    public ResponseEntity<HttpResponse> addImage(@RequestBody RequestAddImage requestAddImage) {
        log.info(TAG + "addImage");
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("image", imageService.addImage(requestAddImage)))
                        .message("Image Added")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/images")
    public ResponseEntity<HttpResponse> getAllImages() throws InterruptedException {
        log.info(TAG + "getAllImages");
        TimeUnit.SECONDS.sleep(1);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                            .timeStamp(now().toString())
                            .data(Map.of("images", imageService.getAllImage()))
                            .message("Images Retrieved")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
    }

    @DeleteMapping("/deleteImage/{id}")
    public ResponseEntity<HttpResponse> deleteImage(@PathVariable Long id) {
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("id", imageService.deleteImage(id)))
                        .message("Image Deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
}
