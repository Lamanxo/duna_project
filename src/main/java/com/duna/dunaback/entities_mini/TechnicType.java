package com.duna.dunaback.entities_mini;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "technic_class_lib")
public class TechnicType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable (
            name = "technics_equipments_lib",
            joinColumns = @JoinColumn(name = "technic_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<TechnicEquipmentLib> equipments;
    @ManyToMany
    @JoinTable (
            name = "technics_parameters_lib",
            joinColumns = @JoinColumn(name = "technic_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_id")
    )
    private List<TechnicParameterLib> parameters;
}


