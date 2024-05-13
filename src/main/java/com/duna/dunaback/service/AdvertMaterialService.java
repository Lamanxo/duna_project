package com.duna.dunaback.service;

import com.duna.dunaback.dtos.material.AdvertMaterialDtoIn;
import com.duna.dunaback.dtos.material.AdvertMaterialDtoOut;
import com.duna.dunaback.dtos.material.AdvertMaterialUpdDto;
import com.duna.dunaback.entities.AdvertMaterial;
import com.duna.dunaback.entities.User;
import com.duna.dunaback.exceptions.authreg.WrongUserActionsException;
import com.duna.dunaback.repositories.AdvertMaterialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertMaterialService {
    private final AdvertMaterialRepo advertMaterialRepo;
    private final UserService userService;

    public AdvertMaterialDtoOut addNewAdvert(AdvertMaterialDtoIn dto, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        AdvertMaterial material = makeEntity(dto);
        material.setOwnerId(user.getId());
        return makeAdvertDto(advertMaterialRepo.save(material));
    }

    public String updateAdvert(AdvertMaterialUpdDto dtoUpd, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        AdvertMaterial advertOld = entityOrException(dtoUpd.getId());
        AdvertMaterial advertUpd = makeEntityFromUpdDto(dtoUpd);
        if(!user.getId().equals(advertOld.getOwnerId()) || !user.getId().equals(advertUpd.getOwnerId()))
            throw new WrongUserActionsException("Wrong user actions" + principal.getName() + advertUpd.getOwnerId());
        advertUpd.setOwnerId(user.getId());
        advertUpd.setUpdatedAt(LocalDateTime.now());
        advertUpd.setCreatedAt(advertOld.getCreatedAt());
        advertUpd.setVerified(advertOld.isVerified());
        advertUpd.setBanned(advertOld.isBanned());
        advertMaterialRepo.save(advertUpd);
        return "Advert updated";
    }

    public List<AdvertMaterialDtoOut> getAllAdvertsByOwner(Long id) {
        return advertMaterialRepo.findAllByOwnerId(id).stream().map(this::makeAdvertDto).collect(Collectors.toList());
    }

    public AdvertMaterialDtoOut getAdvertById(Long id) {
        return makeAdvertDto(entityOrException(id));
    }

    private AdvertMaterial makeEntity(AdvertMaterialDtoIn dtoIn) {
        AdvertMaterial material = new AdvertMaterial();
        material.setAdvertType(dtoIn.getAdvertType());
        material.setTransactionType(dtoIn.getTransactionType());
        material.setShiftType(dtoIn.getShiftType());
        material.setTitle(dtoIn.getTitle());
        material.setDeliveryType(dtoIn.getDeliveryType());
        material.setAddressLat(dtoIn.getAddressLat());
        material.setAddressLon(dtoIn.getAddressLon());
        material.setMaterialType(dtoIn.getMaterialType());
        material.setFractions(dtoIn.getFractions());
        material.setDumpTransport(dtoIn.getDumpTransport());
        material.setMeasureIn(dtoIn.getMeasureIn());
        material.setAmount(dtoIn.getAmount());
        material.setPaymentType(dtoIn.getPaymentType());
        material.setPrice(dtoIn.getPrice());
        material.setAdvertStatus(dtoIn.getAdvertStatus());

        material.setVerified(true);
        material.setBanned(false);
        material.setUpdatedAt(LocalDateTime.now());
        material.setCreatedAt(LocalDateTime.now());
        return material;
    }

    private AdvertMaterial makeEntityFromUpdDto(AdvertMaterialUpdDto updDto) {
        AdvertMaterial material = new AdvertMaterial();
        material.setAdvertType(updDto.getAdvertType());
        material.setTransactionType(updDto.getTransactionType());
        material.setShiftType(updDto.getShiftType());
        material.setTitle(updDto.getTitle());
        material.setDeliveryType(updDto.getDeliveryType());
        material.setAddressLat(updDto.getAddressLat());
        material.setAddressLon(updDto.getAddressLon());
        material.setMaterialType(updDto.getMaterialType());
        material.setFractions(updDto.getFractions());
        material.setDumpTransport(updDto.getDumpTransport());
        material.setMeasureIn(updDto.getMeasureIn());
        material.setAmount(updDto.getAmount());
        material.setPaymentType(updDto.getPaymentType());
        material.setPrice(updDto.getPrice());
        material.setAdvertStatus(updDto.getAdvertStatus());
        return material;
    }

    private AdvertMaterialDtoOut makeAdvertDto(AdvertMaterial material) {
        AdvertMaterialDtoOut dto = new AdvertMaterialDtoOut();
        dto.setId(dto.getId());
        dto.setOwnerId(material.getOwnerId());
        dto.setAdvertType(material.getAdvertType());
        dto.setTransactionType(material.getTransactionType());
        dto.setShiftType(material.getShiftType());
        dto.setTitle(material.getTitle());
        dto.setDeliveryType(material.getDeliveryType());
        dto.setAddressLat(material.getAddressLat());
        dto.setAddressLon(material.getAddressLon());
        dto.setMaterialType(material.getMaterialType());
        dto.setFractions(material.getFractions());
        dto.setDumpTransport(material.getDumpTransport());
        dto.setMeasureIn(material.getMeasureIn());
        dto.setAmount(material.getAmount());
        dto.setPaymentType(material.getPaymentType());
        dto.setPrice(material.getPrice());
        dto.setAdvertStatus(material.getAdvertStatus());
        return dto;
    }

    private AdvertMaterial entityOrException(Long id) {
        return advertMaterialRepo.findById(id).orElseThrow(() ->
                new  EntityNotFoundException("Advert material not found! Wrong id: " + id));
    }
}
