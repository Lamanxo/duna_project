package com.duna.dunaback.repositories;

import com.duna.dunaback.entities.AdvertTechnic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdvertTechnicRepo extends JpaRepository<AdvertTechnic, Long> {
    Optional<AdvertTechnic> findById(Long id);

    List<AdvertTechnic> findAllByOwnerId(Long ownerId);
}
