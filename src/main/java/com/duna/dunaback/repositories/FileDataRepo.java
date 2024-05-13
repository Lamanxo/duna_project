package com.duna.dunaback.repositories;

import com.duna.dunaback.entities.FileData;
import com.duna.dunaback.enums.AdvertType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileDataRepo extends JpaRepository<FileData, Long> {
    Optional<FileData> findByName(String name);
    List<FileData> findAllByOrderIdAndAdvertType(Long orderId, AdvertType advertType);
}
