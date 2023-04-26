package com.brunolopezcross.PersonasApi.mapper;

import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.model.Persona;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;


@Mapper
public interface PersonaMapper {
    @Mapping(source="personaDto.fechaNacimiento",target="fechaNacimiento",dateFormat ="dd/MM/yyyy",defaultExpression = "java(LocalDate.now())")
    Persona toPersona( PersonaDto personaDto );
    @InheritInverseConfiguration
    PersonaDto toPersonaDto( Persona persona );
    @IterableMapping(elementTargetType = PersonaDto.class)
    List<PersonaDto> toPersonaDtoList( List<Persona> personas);
    @IterableMapping(elementTargetType = Persona.class)
    List<Persona> toPersonaList( List<PersonaDto> personasDtos);
}
