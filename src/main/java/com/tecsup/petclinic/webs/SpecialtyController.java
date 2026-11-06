package com.tecsup.petclinic.webs;

<<<<<<< HEAD
import com.tecsup.petclinic.dtos.SpecialtyDTO;
=======
import com.tecsup.petclinic.entities.Specialty;
>>>>>>> 4597f82d6d8c74e5ad37ac344792790b9562424c
import com.tecsup.petclinic.services.SpecialtyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD

@RestController
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping("/specialties/{id}")
    public ResponseEntity<SpecialtyDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.of(specialtyService.findById(id));
=======
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
>>>>>>> 4597f82d6d8c74e5ad37ac344792790b9562424c
    }
}
