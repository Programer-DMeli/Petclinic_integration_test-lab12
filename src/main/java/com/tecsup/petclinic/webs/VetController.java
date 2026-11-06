package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.services.VetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VetController {
	private final VetService vetService;

	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@GetMapping("/vets")
	public List<VetDTO> findAll() {
		return vetService.findAll();
	}

	@GetMapping("/vets/{id}")
	public VetDTO findById(@PathVariable Integer id) {
		return vetService.findById(id);
	}
}
