package com.brunolopezcross.PersonasApi;

import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.model.Persona;
import com.brunolopezcross.PersonasApi.model.TipoDocumento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatosParaTests {


    public static List<PersonaDto> getPersonaDtoList () {

        List<PersonaDto> personaDtoList =  new ArrayList<>();

        personaDtoList.add(getPersonaDto());
        personaDtoList.add(getPersonaDto());
        return personaDtoList;
    }

    public static PersonaDto getPersonaDto(){
        PersonaDto personaDto = PersonaDto.builder()
                .apellido("Perez")
                .nombre("Juan")
                .numeroDocumento(123456789L)
                .tipoDocumento("DNI")
                .fechaNacimiento("03/12/2007")
                .build();

        return personaDto;
    }

    public static Persona getPersona(){

        Persona persona = Persona.builder()
                .nombre("Juan")
                .apellido("Perez")
                .numeroDocumento(123456789L)
                .tipoDocumento(TipoDocumento.CEDULA)
                .fechaNacimiento(LocalDate.parse("03/12/2007", DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .build();
        return persona;
    }



}
