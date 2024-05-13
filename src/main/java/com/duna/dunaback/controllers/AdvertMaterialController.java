package com.duna.dunaback.controllers;

import com.duna.dunaback.dtos.material.AdvertMaterialDtoIn;
import com.duna.dunaback.dtos.material.AdvertMaterialDtoOut;
import com.duna.dunaback.dtos.material.AdvertMaterialUpdDto;
import com.duna.dunaback.service.AdvertMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdvertMaterialController {
    private final AdvertMaterialService service;

    @PostMapping("/secured/advert-material/new")
    public AdvertMaterialDtoOut addNewAdvert(@RequestBody @Valid AdvertMaterialDtoIn dto, Principal principal) {
        return service.addNewAdvert(dto, principal);
    }

    @PostMapping("/secured/advert-material/upd")
    public String updateAdvert(@RequestBody @Valid AdvertMaterialUpdDto dto, Principal principal) {
        return service.updateAdvert(dto, principal);
    }

    @GetMapping("/advert-material/{id}")
    public AdvertMaterialDtoOut getAdvertById(@PathVariable Long id) {
        return service.getAdvertById(id);
    }

    @GetMapping("/advert-material/all/{ownerId}")
    public List<AdvertMaterialDtoOut> allAdvertsByOwner(@PathVariable Long ownerId) {
        return service.getAllAdvertsByOwner(ownerId);
    }
}
