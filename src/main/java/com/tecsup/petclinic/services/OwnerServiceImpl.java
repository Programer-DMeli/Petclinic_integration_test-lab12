package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository repository;
    public OwnerServiceImpl(OwnerRepository repository) { this.repository = repository; }
    public List<Owner> findAll() { return repository.findAll(); }
    public Optional<Owner> findById(Long id) { return repository.findById(id); }
}
