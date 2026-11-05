package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import java.util.List;
import java.util.Optional;

public interface SpecialtyService {
    List<Specialty> findAll();
    Optional<Specialty> findById(Integer id);
}
