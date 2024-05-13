package com.duna.dunaback.repositories;

import com.duna.dunaback.entities.AppLike;
import com.duna.dunaback.enums.AdvertType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppLikeRepo extends JpaRepository<AppLike, Long> {

    Long countByAdvertIdAndAdvertType(Long advertId, AdvertType advertType);

    List<AppLike> findAllByAdvertIdAndAdvertTypeOrderByCreatedAt(Long advertId, AdvertType advertType);
}
