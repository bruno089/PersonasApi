package com.brunolopezcross.PersonasApi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Column(name = "perTipoDocumento")
    String  tipoDocumento;
    @Column(name = "perFechaNacimiento")
    LocalDate fechaNacimiento;
}
