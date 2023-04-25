package com.brunolopezcross.PersonasApi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "Personas")
public class Persona {

    @Id()
    @Column(name = "perId")
    Integer id;
    @Column(name = "perApellido")
    String  apellido;
    @Column(name = "perNombre")
    String  nombre;
    @Column(name = "perNumeroDocumento")
    Long    numeroDocumento;
    @Enumerated(EnumType.STRING)
    @Column(name = "perTipoDocumento")
    TipoDocumento  tipoDocumento;
    @Column(name = "perFechaNacimiento")
    LocalDate fechaNacimiento;
}
