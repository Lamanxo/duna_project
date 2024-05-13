package com.duna.dunaback.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
@Table(name = "avatar_data")
public class AvatarData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "file_path")
    private String filePath;

    public AvatarData(Long userId, String name, String type, String filePath) {
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.filePath = filePath;
    }
}
