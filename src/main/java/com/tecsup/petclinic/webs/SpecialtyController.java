package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.services.SpecialtyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SpecialtyController {
    private final SpecialtyService service;
    public SpecialtyController(SpecialtyService service) { this.service = service; }
    @GetMapping("/specialties")
    public List<Specialty> findAll() { return service.findAll(); }
    @GetMapping("/specialties/{id}")
    public ResponseEntity<Specialty> findById(@PathVariable Integer id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
