package com.brunolopezcross.PersonasApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity(name = "Personas")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Persona {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
