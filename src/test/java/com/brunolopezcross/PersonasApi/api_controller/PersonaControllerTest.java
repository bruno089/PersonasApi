package com.brunolopezcross.PersonasApi.api_controller;

import com.brunolopezcross.PersonasApi.DatosParaTests;
import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.exception.BadRequestException;
import com.brunolopezcross.PersonasApi.service.PersonaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PersonaControllerTest {
    @InjectMocks PersonaController personaController;
    @Mock        PersonaService personaService;

    @Nested
    @DisplayName(" Pruebas para buscarPersonasPorTipoDocumento en PersonaController ")
    class buscarPersonasPorTipoDocumentoTests {

        @DisplayName("Debe lanzar BadRequestException cuando se llama con valor nulo")
        @Test
        void testDebeLanzarBadRequestExceptionConValorNuloOVacio(){

            BadRequestException ex = assertThrows(BadRequestException.class, () -> {
                personaController.buscarPersonasPorTipoDocumento("");
            });

            BadRequestException ex2 = assertThrows(BadRequestException.class, () -> {
                personaController.buscarPersonasPorTipoDocumento(null);
            });
        }

        @DisplayName("Debe lanzar BadRequestException cuando se llama con otro valor que no sea DNI, CEDULA o PASAPORTE")
        @Test
        void testDebeLanzarBadRequestExceptionConValorNoValido(){

            BadRequestException ex = assertThrows(BadRequestException.class, () -> {
                personaController.buscarPersonasPorTipoDocumento("otroValor");
            });

            BadRequestException ex2 = assertThrows(BadRequestException.class, () -> {
                personaController.buscarPersonasPorTipoDocumento("cedula con espacios");
            });
        }

        @DisplayName("No debe lanzar BadRequestException con valores (dni,cedula,pasaporte )en minúscula")
        @Test
        void testNoDebeLanzarBadRequestExceptionConDniEnMinuscula(){

            when(personaService.buscarPersonasPorTipoDocumento(Mockito.anyString())).thenReturn(DatosParaTests.getPersonaDtoList());
            String tipoDoc = "dni";
            List<PersonaDto> list = personaController.buscarPersonasPorTipoDocumento(tipoDoc);
            verify(personaService,times(1)).buscarPersonasPorTipoDocumento(tipoDoc);
            assertNotNull(list);
            assertEquals(2,list.size());
        }

        @DisplayName("No debe lanzar BadRequestException con valores (dni,cedula,pasaporte )en minúscula")
        @Test
        void testNoDebeLanzarBadRequestExceptionConCedulaEnMinuscula(){
            String tipoDoc = "cedula";

            when(personaService.buscarPersonasPorTipoDocumento(tipoDoc)).thenReturn(DatosParaTests.getPersonaDtoList());

            List<PersonaDto> list = personaController.buscarPersonasPorTipoDocumento(tipoDoc);
            verify(personaService,times(1)).buscarPersonasPorTipoDocumento(tipoDoc);
            assertNotNull(list);
            assertEquals(2,list.size());
        }

    }
}