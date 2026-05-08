package com.rupendra.urlShortner.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlResponseDto {

    private String originalUrl;
    private String shortUrl;
}