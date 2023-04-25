package com.brunolopezcross.PersonasApi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PersonaDto {
    @NotNull
    String  apellido;
    @NotNull
    String  nombre;
    @NotNull
    Long  numeroDocumento;
    @NotNull
    String  tipoDocumento;
    @NotNull
    LocalDate fechaNacimiento;
}
