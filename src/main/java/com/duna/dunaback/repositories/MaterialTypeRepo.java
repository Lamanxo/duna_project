package com.duna.dunaback.repositories;

import com.duna.dunaback.entities_mini.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MaterialTypeRepo extends JpaRepository<MaterialType, Long> {

    Optional<MaterialType> findById(Long id);

    @Query("select a from MaterialType a")
    List<MaterialType> findAllFromTable();
}
