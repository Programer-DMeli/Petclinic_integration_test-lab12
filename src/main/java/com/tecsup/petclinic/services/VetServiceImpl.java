package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.repositories.VetRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class VetServiceImpl implements VetService {
	private final VetRepository vetRepository;

	public VetServiceImpl(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public List<VetDTO> findAll() {
		return vetRepository.findAll().stream().map(this::toDto).toList();
	}

	@Override
	public VetDTO findById(Integer id) {
		return vetRepository.findById(id)
				.map(this::toDto)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	private VetDTO toDto(Vet vet) {
		return VetDTO.builder()
				.id(vet.getId())
				.firstName(vet.getFirstName())
				.lastName(vet.getLastName())
				.email(vet.getEmail())
				.phone(vet.getPhone())
				.active(vet.getActive())
				.build();
	}
}
