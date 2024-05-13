package com.duna.dunaback.repositories;

import com.duna.dunaback.entities.AdvertMini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertMiniRepo extends JpaRepository<AdvertMini, Long> {

    List<AdvertMini> findAllByAuthorId(Long authorId);

    @Query("select a from AdvertMini a where a.isActive = ?1 and a.isBanned = ?2")
    List<AdvertMini> findAllByActiveIsTrueAndBannedIsFalse(boolean isActive, boolean isBanned);
}
