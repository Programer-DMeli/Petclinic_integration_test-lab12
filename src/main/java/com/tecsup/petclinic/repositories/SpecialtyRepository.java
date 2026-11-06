package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
}
=======

public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {}
>>>>>>> 4597f82d6d8c74e5ad37ac344792790b9562424c
