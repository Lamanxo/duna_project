package com.duna.dunaback.entities;

import com.duna.dunaback.enums.AdvertType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
@Table(name = "file_data")
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "advert_type")
    private AdvertType advertType;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "file_path")
    private String filePath;

    public FileData(Long orderId, String name, String type, String filePath) {
        this.orderId = orderId;
        this.name = name;
        this.type = type;
        this.filePath = filePath;
    }
}
