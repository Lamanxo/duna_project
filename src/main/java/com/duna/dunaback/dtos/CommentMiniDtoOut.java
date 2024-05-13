package com.duna.dunaback.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentMiniDtoOut {
    private String authorName;
    private Integer rate;
    private String text;
    private LocalDateTime createdAt;
}
