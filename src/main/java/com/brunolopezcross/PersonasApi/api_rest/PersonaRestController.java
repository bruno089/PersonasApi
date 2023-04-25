package com.brunolopezcross.PersonasApi.api_rest;

import com.brunolopezcross.PersonasApi.dto.PersonaDto;
import com.brunolopezcross.PersonasApi.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping(PersonaRestController.PERSONAS_ENDPOINT)
@AllArgsConstructor
public class PersonaRestController {
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

    //Busquedas

    @GetMapping("/nombre")
    public List<PersonaDto> buscarPersonasPorNombreLikeNoCaseSensitive(String nombre){
        return personaService.buscarPersonasPorNombreLikeNoCaseSensitive(nombre);
    }

    @GetMapping("/tipo-documento")
    public List<PersonaDto> buscarPersonasPorTipoDocumento(String tipoDocumento){
        return personaService.buscarPersonasPorTipoDocumento(tipoDocumento);
    }
}
