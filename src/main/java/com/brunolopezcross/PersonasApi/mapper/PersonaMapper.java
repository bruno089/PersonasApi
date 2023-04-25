package com.brunolopezcross.PersonasApi.mapper;

import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.model.Persona;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Mapper
public interface PersonaMapper {
    //@Mapping(source="personaDto.fechaNacimiento",target="fechaNacimiento",dateFormat ="dd/MM/yyyy")
    @Mapping(source="personaDto.fechaNacimiento",target="fechaNacimiento",dateFormat ="dd/MM/yyyy",defaultExpression = "java(LocalDate.now())")
    Persona toPersona( PersonaDto personaDto );
    @InheritInverseConfiguration
    PersonaDto toPersonaDto( Persona persona );
}
