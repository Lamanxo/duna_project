package com.duna.dunaback.repositories;

import com.duna.dunaback.entities_mini.TechnicType;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechnicTypeRepo extends JpaRepository<TechnicType, Long> {
    List<TechnicType> findAllByNameContainingIgnoreCaseOrderByNameAsc(String name);

    Optional<TechnicType> findById(Long id);

    Optional<TechnicType> findByName(String name);


    @Query("select a from TechnicType a")
    List<TechnicType> findAllFromTable();
}
