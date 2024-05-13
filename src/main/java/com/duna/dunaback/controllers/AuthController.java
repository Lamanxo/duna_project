package com.duna.dunaback.controllers;

import com.duna.dunaback.dtos.JwtRequest;
import com.duna.dunaback.dtos.JwtResponse;
import com.duna.dunaback.dtos.RegistrationUserDto;
import com.duna.dunaback.dtos.UserDtoIn;
import com.duna.dunaback.service.AuthService;
import com.duna.dunaback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    private final UserService userService;

    @PostMapping("/auth")
    public JwtResponse createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/sign_up")
    public UserDtoIn createNewUser(@RequestBody @Valid RegistrationUserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }

    //TODO finish
    @GetMapping(path = "/sign_up/confirm")
    public String confirmUserEmail(@RequestParam("token") String token) {
        return userService.userEmailVerification(token);
    }
}