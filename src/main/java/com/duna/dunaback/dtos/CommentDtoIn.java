package com.duna.dunaback.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class CommentDtoIn {
    @NotNull
    private Long authorId;
    @NotNull
    private Long addresseeId;
    @Min(1)
    @Max(5)
    @NotNull
    private Integer rate;
    @NotNull
    @NotBlank
    private String text;
}
