package com.duna.dunaback.controllers;

import com.duna.dunaback.dtos.dump.AdvertDumpDtoIn;
import com.duna.dunaback.dtos.dump.AdvertDumpDtoOut;
import com.duna.dunaback.dtos.dump.AdvertDumpUpdDto;
import com.duna.dunaback.service.AdvertDumpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdvertDumpController {
    private final AdvertDumpService service;

    @PostMapping("/secured/advert-dump/new")
    public AdvertDumpDtoOut addNewAdvert(@RequestBody @Valid AdvertDumpDtoIn dto, Principal principal) {
        return service.addNewAdvert(dto, principal);
    }

    @PostMapping("/secured/advert-dump/upd")
    public String updateAdvert(@RequestBody @Valid AdvertDumpUpdDto dto, Principal principal) {
        return service.updateAdvert(dto, principal);
    }

    @GetMapping("/advert-dump/all/{ownerId}")
    public List<AdvertDumpDtoOut> allAdvertsByOwner(@PathVariable Long ownerId) {
        return service.getAllAdvertsByOwner(ownerId);
    }

    @GetMapping("/advert-dump/{id}")
    public AdvertDumpDtoOut getAdvertById (@PathVariable Long id) {
        return service.getAdvertById(id);
    }
}
