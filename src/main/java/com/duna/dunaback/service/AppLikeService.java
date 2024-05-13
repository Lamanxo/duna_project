package com.duna.dunaback.service;

import com.duna.dunaback.entities.AppLike;
import com.duna.dunaback.enums.AdvertType;
import com.duna.dunaback.repositories.AppLikeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppLikeService {

    private final AppLikeRepo appLikeRepo;

    public Long countLikesByAdvertIdAndAdvertType(Long advertId, AdvertType advertType) {
        return appLikeRepo.countByAdvertIdAndAdvertType(advertId, advertType);
    }

    public List<AppLike> getAllLikesByAdvertIdAndType(Long advertId, AdvertType advertType) {
        return appLikeRepo.findAllByAdvertIdAndAdvertTypeOrderByCreatedAt(advertId, advertType);
    }

    public void postLike(Long advertId, AdvertType advertType, Long userId) {
        AppLike appLike = new AppLike();
        appLike.setAdvertId(advertId);
        appLike.setUserId(userId);
        appLike.setAdvertType(advertType);
        appLike.setCreatedAt(LocalDateTime.now());
        appLikeRepo.save(appLike);
    }
}
