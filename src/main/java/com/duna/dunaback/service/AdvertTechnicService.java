package com.duna.dunaback.service;

import com.duna.dunaback.dtos.technic.AdvertTechnicDtoIn;
import com.duna.dunaback.dtos.technic.AdvertTechnicDtoOut;
import com.duna.dunaback.dtos.technic.AdvertTechnicUpdatedDto;
import com.duna.dunaback.entities.AdvertTechnic;
import com.duna.dunaback.entities.User;
import com.duna.dunaback.enums.AdvertStatus;
import com.duna.dunaback.exceptions.notfound.NotFoundException;
import com.duna.dunaback.repositories.AdvertTechnicRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertTechnicService {
    private final AdvertTechnicRepo advertTechnicRepo;

    private final UserService userService;

    public AdvertTechnicDtoOut addNewAdvert(AdvertTechnicDtoIn dtoIn, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        AdvertTechnic advertTechnic = makeEntity(dtoIn);
        advertTechnic.setOwnerId(user.getId());
        advertTechnicRepo.save(advertTechnic);
        return makeDtoOut(advertTechnic);
    }

    public String updateAdvert(AdvertTechnicUpdatedDto dtoUpd, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        AdvertTechnic technicOld = advertOrException(dtoUpd.getId());
        AdvertTechnic technicUpd = makeEntityFromUpdDto(dtoUpd);
        technicUpd.setOwnerId(user.getId());
        technicUpd.setUpdatedAt(LocalDateTime.now());
        technicUpd.setCreatedAt(technicOld.getCreatedAt());
        technicUpd.setIsVerified(technicOld.getIsVerified());
        technicUpd.setIsBanned(technicOld.getIsBanned());
        advertTechnicRepo.save(technicUpd);
        return "Advert updated";
    }

    public AdvertTechnicDtoOut getAdvertTechnicById(Long id) {
        return makeDtoOut(advertOrException(id));
    }

    public List<AdvertTechnicDtoOut> getAllAdvertsByOwner(Long id) {
        return advertTechnicRepo.findAllByOwnerId(id).stream().map(this::makeDtoOut).collect(Collectors.toList());
    }

    private AdvertTechnic makeEntityFromUpdDto(AdvertTechnicUpdatedDto dtoUpd) {
        AdvertTechnic technic = new AdvertTechnic();
        technic.setId(dtoUpd.getId());
        technic.setEquipment(dtoUpd.getEquipment());
        technic.setAdvertType(dtoUpd.getAdvertType());
        technic.setTransactionType(dtoUpd.getTransactionType());
        technic.setTechnicType(dtoUpd.getTechnicType());
        technic.setTechnicMark(dtoUpd.getTechnicMark());
        technic.setTechnicModel(dtoUpd.getTechnicModel());
        technic.setShiftType(dtoUpd.getShiftType());
        technic.setTitle(dtoUpd.getTitle());
        technic.setUnitAmount(dtoUpd.getUnitAmount());
        technic.setRentalFrom(dtoUpd.getRentalFrom());
        technic.setRentalTo(dtoUpd.getRentalTo());
        technic.setRentalDaysCount(dtoUpd.getRentalDaysCount());
        technic.setAddressLat(dtoUpd.getAddressLat());
        technic.setAddressLon(dtoUpd.getAddressLon());
        technic.setProductionYear(dtoUpd.getProductionYear());
        technic.setWeight(dtoUpd.getWeight());
        technic.setHeight(dtoUpd.getHeight());
        technic.setVolume(dtoUpd.getVolume());
        technic.setPassengersCount(dtoUpd.getPassengersCount());
        technic.setPipeLength(dtoUpd.getPipeLength());
        technic.setBoomLength(dtoUpd.getBoomLength());
        technic.setLiftingCapacity(dtoUpd.getLiftingCapacity());
        technic.setPerformance(dtoUpd.getPerformance());
        technic.setCargoType(dtoUpd.getCargoType());
        technic.setRollerType(dtoUpd.getRollerType());
        technic.setRollersCount(dtoUpd.getRollersCount());
        technic.setSizeType(dtoUpd.getSizeType());
        technic.setOssig(dtoUpd.getOssig());
        technic.setAxesCount(dtoUpd.getAxesCount());
        technic.setBodyLength(dtoUpd.getBodyLength());
        technic.setTrailerType(dtoUpd.getTrailerType());
        technic.setLoadingType(dtoUpd.getLoadingType());
        technic.setSecondAddressLat(dtoUpd.getSecondAddressLat());
        technic.setSecondAddressLon(dtoUpd.getSecondAddressLon());
        technic.setDistance(dtoUpd.getDistance());
        technic.setIsTransport(dtoUpd.getIsTransport());
        technic.setPrice(dtoUpd.getPrice());
        technic.setPaymentType(dtoUpd.getPaymentType());
        technic.setPaymentUnit(dtoUpd.getPaymentUnit());
        technic.setAdvertStatus(dtoUpd.getAdvertStatus());
        return technic;
    }


    private AdvertTechnic advertOrException(Long id) {
        return advertTechnicRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Advert not found! wrong id: " + id));
    }

    private AdvertTechnicDtoOut makeDtoOut(AdvertTechnic technic) {
        AdvertTechnicDtoOut dtoOut = new AdvertTechnicDtoOut();
        dtoOut.setId(technic.getId());
        dtoOut.setEquipment(technic.getEquipment());
        dtoOut.setAdvertType(technic.getAdvertType());
        dtoOut.setTransactionType(technic.getTransactionType());
        dtoOut.setTechnicType(technic.getTechnicType());
        dtoOut.setTechnicMark(technic.getTechnicMark());
        dtoOut.setTechnicModel(technic.getTechnicModel());
        dtoOut.setShiftType(technic.getShiftType());
        dtoOut.setTitle(technic.getTitle());
        dtoOut.setUnitAmount(technic.getUnitAmount());
        dtoOut.setRentalFrom(technic.getRentalFrom());
        dtoOut.setRentalTo(technic.getRentalTo());
        dtoOut.setRentalDaysCount(technic.getRentalDaysCount());
        dtoOut.setAddressLat(technic.getAddressLat());
        dtoOut.setAddressLon(technic.getAddressLon());
        dtoOut.setProductionYear(technic.getProductionYear());
        dtoOut.setWeight(technic.getWeight());
        dtoOut.setHeight(technic.getHeight());
        dtoOut.setVolume(technic.getVolume());
        dtoOut.setPassengersCount(technic.getPassengersCount());
        dtoOut.setPipeLength(technic.getPipeLength());
        dtoOut.setBoomLength(technic.getBoomLength());
        dtoOut.setLiftingCapacity(technic.getLiftingCapacity());
        dtoOut.setPerformance(technic.getPerformance());
        dtoOut.setCargoType(technic.getCargoType());
        dtoOut.setRollerType(technic.getRollerType());
        dtoOut.setRollersCount(technic.getRollersCount());
        dtoOut.setSizeType(technic.getSizeType());
        dtoOut.setOssig(technic.getOssig());
        dtoOut.setAxesCount(technic.getAxesCount());
        dtoOut.setBodyLength(technic.getBodyLength());
        dtoOut.setTrailerType(technic.getTrailerType());
        dtoOut.setLoadingType(technic.getLoadingType());
        dtoOut.setSecondAddressLat(technic.getSecondAddressLat());
        dtoOut.setSecondAddressLon(technic.getSecondAddressLon());
        dtoOut.setDistance(technic.getDistance());
        dtoOut.setIsTransport(technic.getIsTransport());
        dtoOut.setPrice(technic.getPrice());
        dtoOut.setPaymentType(technic.getPaymentType());
        dtoOut.setPaymentUnit(technic.getPaymentUnit());
        dtoOut.setAdvertStatus(technic.getAdvertStatus());
        return dtoOut;
    }



    private AdvertTechnic makeEntity(AdvertTechnicDtoIn dtoIn) {
        AdvertTechnic technic = new AdvertTechnic();
        technic.setEquipment(dtoIn.getEquipment());
        technic.setAdvertType(dtoIn.getAdvertType());
        technic.setTransactionType(dtoIn.getTransactionType());
        technic.setTechnicType(dtoIn.getTechnicType());
        technic.setTechnicMark(dtoIn.getTechnicMark());
        technic.setTechnicModel(dtoIn.getTechnicModel());
        technic.setShiftType(dtoIn.getShiftType());
        technic.setTitle(dtoIn.getTitle());
        technic.setUnitAmount(dtoIn.getUnitAmount());
        technic.setRentalFrom(dtoIn.getRentalFrom());
        technic.setRentalTo(dtoIn.getRentalTo());
        technic.setRentalDaysCount(dtoIn.getRentalDaysCount());
        technic.setAddressLat(dtoIn.getAddressLat());
        technic.setAddressLon(dtoIn.getAddressLon());
        technic.setProductionYear(dtoIn.getProductionYear());
        technic.setWeight(dtoIn.getWeight());
        technic.setHeight(dtoIn.getHeight());
        technic.setVolume(dtoIn.getVolume());
        technic.setPassengersCount(dtoIn.getPassengersCount());
        technic.setPipeLength(dtoIn.getPipeLength());
        technic.setBoomLength(dtoIn.getBoomLength());
        technic.setLiftingCapacity(dtoIn.getLiftingCapacity());
        technic.setPerformance(dtoIn.getPerformance());
        technic.setCargoType(dtoIn.getCargoType());
        technic.setRollerType(dtoIn.getRollerType());
        technic.setRollersCount(dtoIn.getRollersCount());
        technic.setSizeType(dtoIn.getSizeType());
        technic.setOssig(dtoIn.getOssig());
        technic.setAxesCount(dtoIn.getAxesCount());
        technic.setBodyLength(dtoIn.getBodyLength());
        technic.setTrailerType(dtoIn.getTrailerType());
        technic.setLoadingType(dtoIn.getLoadingType());
        technic.setSecondAddressLat(dtoIn.getSecondAddressLat());
        technic.setSecondAddressLon(dtoIn.getSecondAddressLon());
        technic.setDistance(dtoIn.getDistance());
        technic.setIsTransport(dtoIn.getIsTransport());
        technic.setPrice(dtoIn.getPrice());
        technic.setPaymentType(dtoIn.getPaymentType());
        technic.setPaymentUnit(dtoIn.getPaymentUnit());
        technic.setAdvertStatus(AdvertStatus.STOPPER);
        technic.setIsVerified(true);
        technic.setIsBanned(false);
        technic.setCreatedAt(LocalDateTime.now());
        technic.setUpdatedAt(LocalDateTime.now());
        return technic;
    }

}
