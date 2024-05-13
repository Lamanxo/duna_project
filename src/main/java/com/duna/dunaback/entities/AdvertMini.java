package com.duna.dunaback.entities;

import com.duna.dunaback.enums.AdvertType;
import com.duna.dunaback.enums.TransactionTypeTechnic;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "adverts_mini")
public class AdvertMini {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "advert_type")
    @Enumerated(EnumType.ORDINAL)
    private AdvertType advertType;
    @Column(name = "transaction_type")
    @Enumerated(EnumType.ORDINAL)
    private TransactionTypeTechnic transactionType;
    @Column(name = "title")
    private String title;
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "advert_id")
    private Long advertId;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_banned")
    private boolean isBanned;
}
