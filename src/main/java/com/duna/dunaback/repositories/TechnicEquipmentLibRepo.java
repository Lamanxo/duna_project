package com.duna.dunaback.repositories;

import com.duna.dunaback.entities_mini.TechnicEquipmentLib;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnicEquipmentLibRepo extends JpaRepository<TechnicEquipmentLib, Long> {

    Optional<TechnicEquipmentLib> findById(Long id);
    Optional<TechnicEquipmentLib> findByName(String name);
}
