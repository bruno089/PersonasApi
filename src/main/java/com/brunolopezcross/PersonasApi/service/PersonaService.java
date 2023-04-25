package com.brunolopezcross.PersonasApi.service;


import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.mapper.PersonaMapper;
import com.brunolopezcross.PersonasApi.model.Persona;
import com.brunolopezcross.PersonasApi.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class PersonaService {

    PersonaRepository personaRepository;
    static PersonaMapper personaMapper =  Mappers.getMapper(PersonaMapper.class);
    public PersonaDto nuevo ( PersonaDto personaDto ) {

        Persona persona = personaRepository.save(personaMapper.toPersona(personaDto));

        return personaMapper.toPersonaDto(persona);
    }
    public PersonaDto editar ( Integer id, PersonaDto personaDto ) {
        return null;
    }
    public void eliminar ( Integer id ) {
    }
    public List<PersonaDto> buscarPersonasPorNombreLikeNoCaseSensitive ( String nombre ) {
        return null;
    }
    public List<PersonaDto> buscarPersonasPorTipoDocumento ( String documento ) {
        return null;
    }
}
