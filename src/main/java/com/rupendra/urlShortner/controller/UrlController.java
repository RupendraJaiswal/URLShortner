package com.rupendra.urlShortner.controller;

import com.rupendra.urlShortner.dto.UrlRequestDto;
import com.rupendra.urlShortner.dto.UrlResponseDto;
import com.rupendra.urlShortner.service.UrlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@Tag(name = "URL Shortener APIs")

public class UrlController {

    private final UrlService service;

    @PostMapping("/shorten")
    @Operation(summary = "Generate Short URL")

    public ResponseEntity<UrlResponseDto> shorten(
            @RequestBody UrlRequestDto dto) {

        return ResponseEntity.ok(service.shortenUrl(dto));
    }

    @GetMapping("/{code}")
    @Operation(summary = "Redirect to Original URL")

    public ResponseEntity<Void> redirect(
            @PathVariable String code) {

        String originalUrl = service.getOriginalUrl(code);

        return ResponseEntity
                .status(302)
                .location(URI.create(originalUrl))
                .build();
    }
}