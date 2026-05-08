package com.rupendra.urlShortner.service;

import com.rupendra.urlShortner.dto.UrlRequestDto;
import com.rupendra.urlShortner.dto.UrlResponseDto;
import com.rupendra.urlShortner.entity.UrlMapping;
import com.rupendra.urlShortner.repository.UrlRepository;
import com.rupendra.urlShortner.util.ShortCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository repository;

    @Value("${app.base-url}")
    private String baseUrl;
    @Value("${url.expiry.days}")
    private Long expiryDays;

    public UrlResponseDto shortenUrl(UrlRequestDto dto) {

        String code = ShortCodeGenerator.generateShortCode();

        UrlMapping mapping = UrlMapping.builder()
                .originalUrl(dto.getUrl())
                .shortCode(code)
                .clickCount(0L)
                .createdAt(LocalDateTime.now())
                .expiryDate(LocalDateTime.now().plusDays(expiryDays))
                .build();

        repository.save(mapping);

        return new UrlResponseDto(
                mapping.getOriginalUrl(),
                baseUrl + code
        );
    }

    public String getOriginalUrl(String code) {

        UrlMapping mapping = repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        if (mapping.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("URL expired");
        }

        mapping.setClickCount(mapping.getClickCount() + 1);

        repository.save(mapping);

        return mapping.getOriginalUrl();
    }
}