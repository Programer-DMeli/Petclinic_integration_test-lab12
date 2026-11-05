package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.entities.Visit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class VisitPersistenceTest {

    @Autowired
    private PetRepository petRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void registersVisitForExistingPet() {
        int petId = 7;
        LocalDate visitDate = LocalDate.of(2024, 6, 15);
        Pet pet = petRepository.findById(petId).orElseThrow();

        Visit visit = new Visit();
        visit.setPet(pet);
        visit.setVisitDate(visitDate);
        visit.setDescription("Routine checkup");
        entityManager.persist(visit);
        entityManager.flush();
        entityManager.clear();

        Visit savedVisit = entityManager.find(Visit.class, visit.getId());
        assertNotNull(savedVisit);
        assertEquals(visitDate, savedVisit.getVisitDate());
        assertEquals("Routine checkup", savedVisit.getDescription());
        assertEquals(petId, savedVisit.getPet().getId());
        assertEquals("Samantha", savedVisit.getPet().getName());
    }
}
