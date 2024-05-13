package com.duna.dunaback.entities;

import com.duna.dunaback.enums.AdvertType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "app_like")
public class AppLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "user_id")
    private Long userId;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "advert_type")
    private AdvertType advertType;
    @Column(name = "advert_id")
    private Long advertId;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
