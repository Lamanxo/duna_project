package com.duna.dunaback.repositories;

import com.duna.dunaback.entities.AdvertDump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertDumpRepo extends JpaRepository<AdvertDump, Long> {
    Optional<AdvertDump> findById(Long id);
    List<AdvertDump> findAllByOwnerId(Long id);
}
