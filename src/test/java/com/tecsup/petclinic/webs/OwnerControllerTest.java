package com.tecsup.petclinic.webs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OwnerControllerTest {
    @Autowired private MockMvc mockMvc;

    @Test
    void testFindAllOwners() throws Exception {
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(10)))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    void testFindOwnerOK() throws Exception {
        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("George")))
                .andExpect(jsonPath("$.lastName", is("Franklin")))
                .andExpect(jsonPath("$.city", is("Madison")));
    }

    @Test
    void testFindOwnerKO() throws Exception {
        mockMvc.perform(get("/owners/666")).andExpect(status().isNotFound());
    }
}
