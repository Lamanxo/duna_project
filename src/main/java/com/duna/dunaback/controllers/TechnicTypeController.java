package com.duna.dunaback.controllers;

import com.duna.dunaback.entities_mini.TechnicType;
import com.duna.dunaback.service.TechnicTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TechnicTypeController {

    private final TechnicTypeService technicTypeService;

    @GetMapping("/technic-type-lib/{name}")
    public List<TechnicType> findAllByLetter(@PathVariable String name) {
        return technicTypeService.findAllByNameByLetter(name);
    }

    //test get All from table
    @GetMapping("/technic-type-lib/all")
    public List<TechnicType> findAllFromTable() {
        return technicTypeService.findAllFromTable();
    }
}
