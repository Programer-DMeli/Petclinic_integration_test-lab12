package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.services.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class OwnerController {
    private final OwnerService service;
    public OwnerController(OwnerService service) { this.service = service; }
    @GetMapping("/owners")
    public List<Owner> findAll() { return service.findAll(); }
    @GetMapping("/owners/{id}")
    public ResponseEntity<Owner> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
