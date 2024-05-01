package com.novisign.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ImageDto {

    private Long id;
    private String url;
    private String duration;
}
