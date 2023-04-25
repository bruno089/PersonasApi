package com.brunolopezcross.PersonasApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data @Builder @AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    @NotNull
    String  apellido;
    @NotNull
    String  nombre;
    @NotNull
    Long  numeroDocumento;
    @NotNull
    @Pattern(regexp = "^(DNI|CEDULA|PASAPORTE)$", message = "El tipo de documento debe ser DNI, CEDULA o PASAPORTE")
    String  tipoDocumento;
    @NotNull
    String fechaNacimiento;
}
