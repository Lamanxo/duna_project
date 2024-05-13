package com.duna.dunaback.service;

import com.duna.dunaback.dtos.AdvertMiniDtoOut;
import com.duna.dunaback.entities.AdvertMini;
import com.duna.dunaback.repositories.AdvertMiniRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertMiniService {

    private final AdvertMiniRepo advertMiniRepo;
    @Autowired
    private AdvertViewService advertViewService;
    @Autowired
    private AppLikeService appLikeService;
    @Autowired
    private StorageService storageService;
    

    public List<AdvertMiniDtoOut> advertsByUserId(Long userId) {
        return advertMiniRepo.findAllByAuthorId(userId).stream()
                .map(this::makeDtoOut).collect(Collectors.toList());
    }

    public List<AdvertMiniDtoOut> getAllActiveByDateAsc() {
        return advertMiniRepo.findAllByActiveIsTrueAndBannedIsFalse(true,false).stream()
                .map(this::makeDtoOut).collect(Collectors.toList());
    }


    private AdvertMiniDtoOut makeDtoOut(AdvertMini advertMini) {
        AdvertMiniDtoOut dtoOut = new AdvertMiniDtoOut();
        dtoOut.setId(advertMini.getAdvertId());
        dtoOut.setType(advertMini.getAdvertType().toString());
        dtoOut.setTransactionType(advertMini.getTransactionType().toString());
        dtoOut.setTitle(advertMini.getTitle());
        dtoOut.setUpdatedAt(advertMini.getUpdatedAt());
        dtoOut.setAuthor(advertMini.getAuthorId());
        dtoOut.setViews(advertViewService.getViewsByAdvertIdAndType(advertMini.getAdvertId(), advertMini.getAdvertType()));
        dtoOut.setLikes(appLikeService.countLikesByAdvertIdAndAdvertType(advertMini.getAdvertId(), advertMini.getAdvertType()));
        dtoOut.setPhotos(storageService.findAllImageNamesByOrderId(advertMini.getAdvertId(), advertMini.getAdvertType()));
        return dtoOut;
    }
}
