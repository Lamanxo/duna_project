package com.duna.dunaback.repositories;

import com.duna.dunaback.entities.AdvertMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertMaterialRepo extends JpaRepository<AdvertMaterial, Long> {
    Optional<AdvertMaterial> findById(Long id);

    List<AdvertMaterial> findAllByOwnerId(Long ownerId);

}
