package com.tecsup.petclinic.services;

<<<<<<< HEAD
import com.tecsup.petclinic.dtos.SpecialtyDTO;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    public Optional<SpecialtyDTO> findById(Integer id) {
        return specialtyRepository.findById(id)
                .map(specialty -> new SpecialtyDTO(specialty.getId(), specialty.getName()));
    }
=======
import com.tecsup.petclinic.entities.Specialty;
import java.util.List;
import java.util.Optional;

public interface SpecialtyService {
    List<Specialty> findAll();
    Optional<Specialty> findById(Integer id);
>>>>>>> 4597f82d6d8c74e5ad37ac344792790b9562424c
}
