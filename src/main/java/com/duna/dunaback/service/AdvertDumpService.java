package com.duna.dunaback.service;

import com.duna.dunaback.dtos.dump.AdvertDumpDtoIn;
import com.duna.dunaback.dtos.dump.AdvertDumpDtoOut;
import com.duna.dunaback.dtos.dump.AdvertDumpUpdDto;
import com.duna.dunaback.entities.AdvertDump;
import com.duna.dunaback.entities.User;
import com.duna.dunaback.exceptions.authreg.WrongUserActionsException;
import com.duna.dunaback.repositories.AdvertDumpRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertDumpService {
    private final AdvertDumpRepo advertDumpRepo;
    private final UserService userService;

    public AdvertDumpDtoOut addNewAdvert(AdvertDumpDtoIn dto, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        AdvertDump advert = makeEntity(dto);
        advert.setOwnerId(user.getId());
        return makeDtoOut(advertDumpRepo.save(advert));
    }

    public String updateAdvert(AdvertDumpUpdDto dtoUpd, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        AdvertDump advertOld = advertOrException(dtoUpd.getId());
        AdvertDump advertUpd = makeEntityFromUpdDto(dtoUpd);
        if(!user.getId().equals(advertOld.getOwnerId()) || (!user.getId().equals(advertUpd.getOwnerId())))
            throw new WrongUserActionsException("Wrong user actions" + principal.getName() + advertUpd.getOwnerId());
        advertUpd.setOwnerId(user.getId());
        advertUpd.setUpdatedAt(LocalDateTime.now());
        advertUpd.setCreatedAt(advertOld.getCreatedAt());
        advertUpd.setVerified(advertOld.isVerified());
        advertUpd.setBanned(advertOld.isBanned());
        advertDumpRepo.save(advertUpd);
        return "Advert updated";

    }

    public AdvertDumpDtoOut getAdvertById(Long id) {
        return makeDtoOut(advertOrException(id));
    }

    public List<AdvertDumpDtoOut> getAllAdvertsByOwner(Long ownerId) {
        return advertDumpRepo.findAllByOwnerId(ownerId).stream().map(this::makeDtoOut).collect(Collectors.toList());
    }

    private AdvertDump makeEntityFromUpdDto(AdvertDumpUpdDto dtoUpd) {
        AdvertDump advert = new AdvertDump();
        advert.setId(dtoUpd.getId());
        advert.setAdvertType(dtoUpd.getAdvertType());
        advert.setTransactionType(dtoUpd.getTransactionType());
        advert.setShiftType(dtoUpd.getShiftType());
        advert.setTitle(dtoUpd.getTitle());
        advert.setAddressLat(dtoUpd.getAddressLat());
        advert.setAddressLon(dtoUpd.getAddressLon());
        advert.setWasteType(dtoUpd.getWasteType());
        advert.setDangerClass(dtoUpd.getDangerClass());
        advert.setDumpTransport(dtoUpd.getDumpTransport());
        advert.setMeasureIn(dtoUpd.getMeasureIn());
        advert.setAmount(dtoUpd.getAmount());
        advert.setPrice(dtoUpd.getPrice());
        advert.setPaymentType(dtoUpd.getPaymentType());
        advert.setAdvertStatus(dtoUpd.getAdvertStatus());
        return advert;
    }

    private AdvertDumpDtoOut makeDtoOut(AdvertDump advert) {
        AdvertDumpDtoOut dtoOut = new AdvertDumpDtoOut();
        dtoOut.setId(advert.getId());
        dtoOut.setOwnerId(advert.getOwnerId());
        dtoOut.setAdvertType(advert.getAdvertType());
        dtoOut.setTransactionType(advert.getTransactionType());
        dtoOut.setShiftType(advert.getShiftType());
        dtoOut.setTitle(advert.getTitle());
        dtoOut.setAddressLat(advert.getAddressLat());
        dtoOut.setAddressLon(advert.getAddressLon());
        dtoOut.setWasteType(advert.getWasteType());
        dtoOut.setDangerClass(advert.getDangerClass());
        dtoOut.setDumpTransport(advert.getDumpTransport());
        dtoOut.setMeasureIn(advert.getMeasureIn());
        dtoOut.setAmount(advert.getAmount());
        dtoOut.setPrice(advert.getPrice());
        dtoOut.setPaymentType(advert.getPaymentType());
        dtoOut.setAdvertStatus(advert.getAdvertStatus());
        return dtoOut;
    }

    private AdvertDump makeEntity(AdvertDumpDtoIn dtoIn) {
        AdvertDump advert = new AdvertDump();
        advert.setAdvertType(dtoIn.getAdvertType());
        advert.setTransactionType(dtoIn.getTransactionType());
        advert.setShiftType(dtoIn.getShiftType());
        advert.setTitle(dtoIn.getTitle());
        advert.setAddressLat(dtoIn.getAddressLat());
        advert.setAddressLon(dtoIn.getAddressLon());
        advert.setWasteType(dtoIn.getWasteType());
        advert.setDangerClass(dtoIn.getDangerClass());
        advert.setDumpTransport(dtoIn.getDumpTransport());
        advert.setMeasureIn(dtoIn.getMeasureIn());
        advert.setAmount(dtoIn.getAmount());
        advert.setPrice(dtoIn.getPrice());
        advert.setPaymentType(dtoIn.getPaymentType());
        advert.setAdvertStatus(dtoIn.getAdvertStatus());
        advert.setVerified(true);
        advert.setBanned(false);
        advert.setCreatedAt(LocalDateTime.now());
        advert.setUpdatedAt(LocalDateTime.now());
        return advert;
    }

    private AdvertDump advertOrException(Long id) {
        return advertDumpRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Advert not found! Wrong id: " + id));
    }
}
