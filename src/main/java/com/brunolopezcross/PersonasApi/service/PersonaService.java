package com.brunolopezcross.PersonasApi.service;


import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonaService {
    PersonaRepository personaRepository;
    public PersonaDto nuevo ( PersonaDto personaDto ) {
        return null;
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
