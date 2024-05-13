package com.duna.dunaback.repositories;

import com.duna.dunaback.entities.AdvertView;
import com.duna.dunaback.enums.AdvertType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdvertViewRepo extends JpaRepository<AdvertView, Long> {
    Optional<AdvertView> findByAdvertIdAndAdvertType(Long advertId, AdvertType advertType);

    Long countAdvertViewByAdvertIdAndAdvertType(Long advertId, AdvertType advertType);
}
