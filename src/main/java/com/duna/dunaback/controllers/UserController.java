package com.duna.dunaback.controllers;

import com.duna.dunaback.dtos.UserDtoOut;
import com.duna.dunaback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{userId}")
    public UserDtoOut getUserById(@PathVariable Long userId) {
        return userService.getUserDtoOutById(userId);
    }
}
