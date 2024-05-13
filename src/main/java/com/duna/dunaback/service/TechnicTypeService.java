package com.duna.dunaback.service;

import com.duna.dunaback.entities_mini.TechnicEquipmentLib;
import com.duna.dunaback.entities_mini.TechnicParameterLib;
import com.duna.dunaback.entities_mini.TechnicType;
import com.duna.dunaback.repositories.TechnicEquipmentLibRepo;
import com.duna.dunaback.repositories.TechnicParameterLibRepo;
import com.duna.dunaback.repositories.TechnicTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicTypeService {

    private final TechnicTypeRepo technicTypeRepo;
    private final TechnicEquipmentLibRepo equipmentLibRepo;
    private final TechnicParameterLibRepo parameterLibRepo;

    public List<TechnicType> findAllByNameByLetter(String name) {
        return technicTypeRepo.findAllByNameContainingIgnoreCaseOrderByNameAsc(name);
    }

    public TechnicType findById(Long id) {
        return technicTypeOrException(id);
    }

    public List<TechnicType> findAllFromTable() {
        return technicTypeRepo.findAllFromTable();
    }

    private TechnicType technicTypeOrException(Long id) {
        return technicTypeRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Technic_Type not found! Wrong id: " + id));
    }

    private TechnicEquipmentLib equipmentLibOrException(Long id) {
        return equipmentLibRepo.findById(id).orElseThrow(()->
                new EntityNotFoundException("Equipment not found! Wrong id: " + id));
    }

    private TechnicParameterLib parameterLibOrException(Long id) {
        return parameterLibRepo.findById(id).orElseThrow(()->
                new EntityNotFoundException("Parameter not found! Wrong id: " + id));
    }
}
