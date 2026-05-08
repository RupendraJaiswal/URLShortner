package com.rupendra.urlShortner.controller;

import com.rupendra.urlShortner.dto.UrlRequestDto;
import com.rupendra.urlShortner.dto.UrlResponseDto;
import com.rupendra.urlShortner.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService service;

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDto> shorten(
            @RequestBody UrlRequestDto dto) {

        return ResponseEntity.ok(service.shortenUrl(dto));
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(
            @PathVariable String code) {

        String originalUrl = service.getOriginalUrl(code);

        return ResponseEntity
                .status(302)
                .location(URI.create(originalUrl))
                .build();
    }
}