package com.duna.dunaback.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoIn {
    private Long id;
    private String username;
    private String phone;
    private String email;
}
