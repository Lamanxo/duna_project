package com.duna.dunaback.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Data
public class AdvertMiniDtoOut {
    private Long id;
    private String type;
    private String transactionType;
    private String title;
    private LocalDateTime updatedAt;
    private Long author;
    private Long views;
    private Long likes;
    private List<String> photos;
}
