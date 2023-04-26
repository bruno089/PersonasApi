package com.brunolopezcross.PersonasApi.mapper;

import com.brunolopezcross.PersonasApi.DatosParaTests;
import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.model.Persona;
import com.brunolopezcross.PersonasApi.model.TipoDocumento;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonaMapperTest {
    static PersonaMapper personaMapper =  Mappers.getMapper(PersonaMapper.class);

    @Test
    void toPersona () {

        PersonaDto personaDto = DatosParaTests.getPersonaDto();

        Persona persona  = personaMapper.toPersona(personaDto);

        assertEquals(personaDto.getNombre(), persona.getNombre());
        assertEquals(personaDto.getApellido(), persona.getApellido());
        assertEquals(personaDto.getNumeroDocumento(), persona.getNumeroDocumento());
        assertEquals(personaDto.getTipoDocumento(), persona.getTipoDocumento().name());
        assertEquals(LocalDate.parse("03/12/2007", DateTimeFormatter.ofPattern("dd/MM/yyyy")), persona.getFechaNacimiento());
    }

    @Test
    void toPersonaDto () {

        Persona persona = DatosParaTests.getPersona();

        PersonaDto personaDto = personaMapper.toPersonaDto(persona);

        assertEquals(persona.getNombre(), personaDto.getNombre());
        assertEquals(persona.getApellido(), personaDto.getApellido());
        assertEquals(persona.getNumeroDocumento(), personaDto.getNumeroDocumento());
        assertEquals(persona.getTipoDocumento().name(), personaDto.getTipoDocumento());
        String personaFechaNacimiento = persona.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals(personaFechaNacimiento, personaDto.getFechaNacimiento());
    }

}