package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.services.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping("/visits")
    public ResponseEntity<VisitDTO> create(@RequestBody CreateVisitRequest request) {
        if (request.petId() == null || request.visitDate() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (request.description() != null && request.description().length() > 255) {
            return ResponseEntity.badRequest().build();
        }
        return visitService.create(request.petId(), request.visitDate(), request.description())
                .map(visit -> ResponseEntity.status(HttpStatus.CREATED).body(visit))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public record CreateVisitRequest(Integer petId, LocalDate visitDate, String description) {
    }
}
