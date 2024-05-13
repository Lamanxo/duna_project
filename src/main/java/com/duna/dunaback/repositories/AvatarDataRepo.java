package com.duna.dunaback.repositories;

import com.duna.dunaback.entities.AvatarData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AvatarDataRepo extends JpaRepository<AvatarData, Long> {
    Optional<AvatarData> findByUserId(Long userId);

    @Transactional
    void removeByUserId(Long userId);
}
