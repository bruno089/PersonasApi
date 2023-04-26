package com.brunolopezcross.PersonasApi.api_controller;

import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.exception.BadRequestException;
import com.brunolopezcross.PersonasApi.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping(PersonaController.PERSONAS_ENDPOINT)
@AllArgsConstructor
public class PersonaController {
    PersonaService personaService;
    public static final  String PERSONAS_ENDPOINT =  "/personas";
    public static final String ID = "/{id}";

    @PostMapping
    public PersonaDto nuevo( @Valid @RequestBody PersonaDto personaDto){
        return personaService.nuevo(personaDto);
    }
    @PutMapping(ID)
    public PersonaDto editar(@PathVariable Integer id, @RequestBody PersonaDto personaDto){
        return personaService.editar(id, personaDto);
    }

    @DeleteMapping(ID)
    public void eliminar(@PathVariable Integer id){
        personaService.eliminar(id);
    }


    /** Busquedas Personas */
    @GetMapping("/nombre")
    public Page<PersonaDto>buscarPersonasPorNombreLikeNoCaseSensitive(String nombre, Pageable pageable ){
        if (nombre == null || nombre.isEmpty()) {
            throw new BadRequestException("El nombre no puede ser nulo o vacío");
        }
        return personaService.buscarPersonasPorNombreLikeNoCaseSensitive(nombre,pageable);
    }
    @GetMapping("/tipo-documento")
    public Page<PersonaDto> buscarPersonasPorTipoDocumento( String tipoDocumento, Pageable pageable ){

        if (tipoDocumento == null || tipoDocumento.isEmpty()) {
            throw new BadRequestException("El tipo de documento no puede ser nulo o vacío");
        }

        String tipoDocumentoUpperCase = tipoDocumento.toUpperCase();
        if (!tipoDocumentoUpperCase.equals("DNI") && !tipoDocumentoUpperCase.equals("CEDULA") && !tipoDocumentoUpperCase.equals("PASAPORTE")) {
            throw new BadRequestException("El tipo de documento no es válido. Los valores permitidos son: DNI, CEDULA, PASAPORTE");
        }

        return personaService.buscarPersonasPorTipoDocumento(tipoDocumento, pageable);
    }

}
