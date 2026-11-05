package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    private final SpecialtyRepository repository;
    public SpecialtyServiceImpl(SpecialtyRepository repository) { this.repository = repository; }
    public List<Specialty> findAll() { return repository.findAll(); }
    public Optional<Specialty> findById(Integer id) { return repository.findById(id); }
}
