package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import java.util.List;
import java.util.Optional;

public interface OwnerService {
    List<Owner> findAll();
    Optional<Owner> findById(Long id);
}
