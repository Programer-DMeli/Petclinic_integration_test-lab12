package com.tecsup.petclinic.webs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.petclinic.dtos.VisitDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class VisitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testCreateVisit() throws Exception {
        byte[] response = mockMvc.perform(post("/visits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "petId": 7,
                                    "visitDate": "2024-06-15",
                                    "description": "Routine checkup"
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.petId").value(7))
                .andExpect(jsonPath("$.visitDate").value("2024-06-15"))
                .andExpect(jsonPath("$.description").value("Routine checkup"))
                .andReturn().getResponse().getContentAsByteArray();

        VisitDTO visit = objectMapper.readValue(response, VisitDTO.class);
        Integer savedPetId = jdbcTemplate.queryForObject(
                "SELECT pet_id FROM visits WHERE id = ?", Integer.class, visit.id());
        assertEquals(7, savedPetId);
    }

    @Test
    void testCreateVisitForMissingPet() throws Exception {
        mockMvc.perform(post("/visits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "petId": 9999,
                                    "visitDate": "2024-06-15"
                                }
                                """))
                .andExpect(status().isNotFound());
    }
}
