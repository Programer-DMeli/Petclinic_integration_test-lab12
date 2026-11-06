package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.repositories.PetRepository;
import com.tecsup.petclinic.repositories.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final PetRepository petRepository;

    public VisitService(VisitRepository visitRepository, PetRepository petRepository) {
        this.visitRepository = visitRepository;
        this.petRepository = petRepository;
    }

    @Transactional
    public Optional<VisitDTO> create(Integer petId, LocalDate visitDate, String description) {
        return petRepository.findById(petId).map(pet -> {
            Visit visit = new Visit();
            visit.setPet(pet);
            visit.setVisitDate(visitDate);
            visit.setDescription(description);
            Visit savedVisit = visitRepository.save(visit);
            return new VisitDTO(savedVisit.getId(), pet.getId(), savedVisit.getVisitDate(),
                    savedVisit.getDescription());
        });
    }
}
