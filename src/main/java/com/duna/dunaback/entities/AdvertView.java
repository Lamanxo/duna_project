package com.duna.dunaback.entities;

import com.duna.dunaback.enums.AdvertType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "views")
@RequiredArgsConstructor
@Setter
@Getter
public class AdvertView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "advert_type")
    private AdvertType advertType;
    @Column(name = "advert_id")
    private Long advertId;
    @Column(name = "views_count")
    private Long viewsCount;
}
