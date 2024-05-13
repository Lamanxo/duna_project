package com.duna.dunaback.controllers;

import com.duna.dunaback.dtos.CommentDtoIn;
import com.duna.dunaback.dtos.CommentDtoOut;
import com.duna.dunaback.dtos.CommentMiniDtoOut;
import com.duna.dunaback.dtos.UserDtoOut;
import com.duna.dunaback.service.CommentService;
import com.duna.dunaback.service.StorageService;
import com.duna.dunaback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final CommentService commentService;
    private final UserService userService;
    private final StorageService storageService;



    //add userCheck to avatar upload
    // delete Email verification skip from userservice

}
