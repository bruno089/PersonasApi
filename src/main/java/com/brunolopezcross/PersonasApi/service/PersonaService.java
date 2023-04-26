package com.brunolopezcross.PersonasApi.service;


import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.exception.BadRequestException;
import com.brunolopezcross.PersonasApi.mapper.PersonaMapper;
import com.brunolopezcross.PersonasApi.model.Persona;
import com.brunolopezcross.PersonasApi.model.TipoDocumento;
import com.brunolopezcross.PersonasApi.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public PersonaDto editar ( Integer id, PersonaDto personaDto ) {return null;} //Todo
    public void eliminar ( Integer id ) {} //Todo
    public Page<PersonaDto> buscarPersonasPorNombreLikeNoCaseSensitive ( String nombre, Pageable pageable ) {

        Page<Persona> personas = personaRepository.findAllByNombreContainingIgnoreCase(nombre,pageable);

        return new PageImpl<>(personaMapper.toPersonaDtoList(personas.getContent()),
                pageable, personas.getContent().size());
    }
    public  Page<PersonaDto> buscarPersonasPorTipoDocumento ( String tipoDocumento , Pageable pageable ) {

        Page<Persona> personasPaginated = personaRepository.findAllByTipoDocumentoIgnoreCase(tipoDocumento, pageable);

        return new PageImpl<>( personaMapper.toPersonaDtoList(personasPaginated.getContent()),
                pageable, personasPaginated.getTotalElements());
    }

}
