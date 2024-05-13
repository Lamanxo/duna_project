package com.duna.dunaback.repositories;

import com.duna.dunaback.entities.AppComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CommentRepo extends JpaRepository<AppComment, Long> {
    Optional<AppComment> findById(Long id);

    Optional<AppComment> findByAuthorIdAndAddresseeId(Long authorId, Long addresseeId);

    List<AppComment> findAllByAddresseeIdOrderByCreatedAt(Long addresseeId);

    @Query("SELECT avg(a.rate) from AppComment a where a.addresseeId = ?1")
    Double getUserRating(Long addresseeId);

    Long countByAddresseeId(Long addresseeId);
}
