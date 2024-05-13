package com.duna.dunaback.service;

import com.duna.dunaback.entities_mini.MaterialType;
import com.duna.dunaback.repositories.MaterialTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialTypeService {
    private final MaterialTypeRepo materialTypeRepo;

    public List<MaterialType> findALlFromTable() {
        return materialTypeRepo.findAllFromTable();
    }

    public MaterialType findById(Long id) {
        return entityOrException(id);
    }

    private MaterialType entityOrException (Long id) {
        return materialTypeRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Material type not found! Wrong id: " + id));
    }
}
