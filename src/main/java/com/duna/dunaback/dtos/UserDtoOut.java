package com.duna.dunaback.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoOut {
    private Long id;
    private String phone;
    private String username;
    private String email;
    private String description;
    private Double rating;
    private Long ratesCount;
}
