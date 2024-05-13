package com.duna.dunaback.controllers;

import com.duna.dunaback.dtos.technic.AdvertTechnicDtoIn;
import com.duna.dunaback.dtos.technic.AdvertTechnicDtoOut;
import com.duna.dunaback.dtos.technic.AdvertTechnicUpdatedDto;
import com.duna.dunaback.service.AdvertTechnicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdvertTechnicController {
    private final AdvertTechnicService service;

    @PostMapping("/secured/advert-technic/new")
    public AdvertTechnicDtoOut addNewAdvert(@RequestBody @Valid AdvertTechnicDtoIn dtoIn, Principal principal) {
        return service.addNewAdvert(dtoIn,principal);
    }

    @PostMapping("/secured/advert-technic/upd")
    public String updateAdvert(@RequestBody @Valid AdvertTechnicUpdatedDto dto, Principal principal) {
        return service.updateAdvert(dto,principal);
    }

    @GetMapping("/advert-technic/{id}")
    public AdvertTechnicDtoOut getAdvertById(@PathVariable Long id) {
        return service.getAdvertTechnicById(id);
    }

    @GetMapping("/advert-technic/all/{ownerId}")
    public List<AdvertTechnicDtoOut> allTechnicAdvertsByOwner(@PathVariable Long ownerId) {
        return service.getAllAdvertsByOwner(ownerId);
    }
}
