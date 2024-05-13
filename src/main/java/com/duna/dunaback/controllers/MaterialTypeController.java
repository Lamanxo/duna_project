package com.duna.dunaback.controllers;

import com.duna.dunaback.entities_mini.MaterialType;
import com.duna.dunaback.service.MaterialTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MaterialTypeController {
    private final MaterialTypeService service;

    @GetMapping("/material-type/{id}")
    public MaterialType findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/material-type/all")
    public List<MaterialType> findAllFromTable() {
        return service.findALlFromTable();
    }
}
