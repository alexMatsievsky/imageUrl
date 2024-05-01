package com.novisign.mappers;

import com.novisign.domain.ImageDto;
import com.novisign.domain.RequestAddImage;
import com.novisign.entities.Image;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageDto toUserDto(Image image);
    List<ImageDto> toUserDtoList (List<Image> images);

    Image toImage(RequestAddImage requestAddImage);
}
