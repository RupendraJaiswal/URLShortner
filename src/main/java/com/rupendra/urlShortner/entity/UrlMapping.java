package com.rupendra.urlShortner.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String originalUrl;

    @Column(unique = true)
    private String shortCode;

    private Long clickCount;

    private LocalDateTime createdAt;

    private LocalDateTime expiryDate;
}