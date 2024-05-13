package com.duna.dunaback.controllers;

import com.duna.dunaback.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final StorageService storageService;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = storageService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData = storageService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }

    @PostMapping("/user/avatar/{userId}")
    public String uploadAvatarToFS(@RequestParam("avatar") MultipartFile multipartFile, @PathVariable Long userId, Principal principal) throws IOException {
        storageService.uploadAvatarToFS(multipartFile, userId);
        return "success";
    }

    @GetMapping("/user/avatar/{userId}")
    public ResponseEntity<?> downloadAvatarFromFS(@PathVariable Long userId) throws IOException {
        byte[] avatar = storageService.downloadAvatarFromFS(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(avatar);
    }

}
