package com.brunolopezcross.PersonasApi.api_controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PersonaControllerIntegrationTest {
    MockMvc mockMvc;
    @Mock PersonaController personaController;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(personaController).build();
    }

    @DisplayName("Registro Personas sin datos - Bad Request")
    @Test
    void registrar() throws Exception {
        this.mockMvc.perform(post("/personas")
                        .content("asdasdasdasdasdas")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    void buscarPersonasPorNombreLikeNoCaseSensitive () throws Exception {
        //Todo  no esta funcionando cuando es vacio
        mockMvc.perform(get("/personas/nombre")
                        .queryParam("nombre", "nombre")
                )
                .andExpect(status().isOk());
    }


}