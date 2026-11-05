package com.tecsup.petclinic.services;

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
}
