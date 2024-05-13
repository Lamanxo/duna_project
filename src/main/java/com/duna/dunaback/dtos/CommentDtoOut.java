package com.duna.dunaback.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CommentDtoOut {
    private Long id;
    private Long authorId;
    private String authorName;
    private Long addresseeId;
    private Integer rate;
    private String text;
}
