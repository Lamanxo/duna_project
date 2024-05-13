package com.duna.dunaback.controllers;

import com.duna.dunaback.dtos.AdvertMiniDtoOut;
import com.duna.dunaback.service.AdvertMiniService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdvertsMiniController {
    private final AdvertMiniService advertMiniService;

    @GetMapping("/adverts/mini/get-all")
    public List<AdvertMiniDtoOut> getAllByDateAsc() {
        return advertMiniService.getAllActiveByDateAsc();
    }

    @GetMapping("/adverts/mini/addressee/{id}")
    public List<AdvertMiniDtoOut> getAllByAddresseeId(@PathVariable Long id) {
        return advertMiniService.advertsByUserId(id);
    }
}
