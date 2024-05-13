package com.duna.dunaback.repositories;

import com.duna.dunaback.entities_mini.TechnicEquipmentLib;
import com.duna.dunaback.entities_mini.TechnicParameterLib;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnicParameterLibRepo extends JpaRepository<TechnicParameterLib, Long> {
    Optional<TechnicParameterLib> findById(Long id);
    Optional<TechnicEquipmentLib> findByName(String name);
}
