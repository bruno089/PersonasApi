package com.brunolopezcross.PersonasApi.api_controller;

import com.brunolopezcross.PersonasApi.DatosParaTests;
import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.exception.BadRequestException;
import com.brunolopezcross.PersonasApi.service.PersonaService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

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
                personaController.buscarPersonasPorTipoDocumento("",null);
            });

            BadRequestException ex2 = assertThrows(BadRequestException.class, () -> {
                personaController.buscarPersonasPorTipoDocumento(null,null);
            });
        }

        @DisplayName("Debe lanzar BadRequestException cuando se llama con otro valor que no sea DNI, CEDULA o PASAPORTE")
        @Test
        void testDebeLanzarBadRequestExceptionConValorNoValido(){

            BadRequestException ex = assertThrows(BadRequestException.class, () -> {
                personaController.buscarPersonasPorTipoDocumento("otroValor",null);
            });

            BadRequestException ex2 = assertThrows(BadRequestException.class, () -> {
                personaController.buscarPersonasPorTipoDocumento("cedula con espacios",null);
            });
        }

        @DisplayName("No debe lanzar BadRequestException con valores (dni,cedula,pasaporte )en minúscula")
        @Test
        @Disabled
        void testNoDebeLanzarBadRequestExceptionConDniEnMinuscula(){

            when(personaService.buscarPersonasPorTipoDocumento(Mockito.anyString(),Mockito.any())).thenReturn(DatosParaTests.getPersonaDtoPaginated());
            String tipoDoc = "dni";
            Page<PersonaDto> personaDtoPage = personaController.buscarPersonasPorTipoDocumento(tipoDoc,null);
            verify(personaService,times(1)).buscarPersonasPorTipoDocumento(tipoDoc,null);
            assertNotNull(personaDtoPage);
            assertEquals(2,personaDtoPage.getContent().size());
        }

        @DisplayName("No debe lanzar BadRequestException con valores (dni,cedula,pasaporte )en minúscula")
        @Test
        @Disabled
        void testNoDebeLanzarBadRequestExceptionConCedulaEnMinuscula(){
            String tipoDoc = "cedula";

            when(personaService.buscarPersonasPorTipoDocumento(tipoDoc,Mockito.any())).thenReturn(DatosParaTests.getPersonaDtoPaginated());

            Page<PersonaDto> personaDtoPage = personaController.buscarPersonasPorTipoDocumento(tipoDoc,null);
            verify(personaService,times(1)).buscarPersonasPorTipoDocumento(tipoDoc,null);
            assertNotNull(personaDtoPage);
            assertEquals(2,personaDtoPage.getContent().size());
        }

    }
}