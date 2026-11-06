package com.tecsup.petclinic.dtos;

import java.time.LocalDate;

public record VisitDTO(Long id, Integer petId, LocalDate visitDate, String description) {
}
