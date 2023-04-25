package com.brunolopezcross.PersonasApi.service;

import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
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
