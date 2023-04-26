package com.brunolopezcross.PersonasApi.repository;

import com.brunolopezcross.PersonasApi.model.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonaRepository  extends JpaRepository<Persona, Integer> {
    Page<Persona> findAllByNombreContainingIgnoreCase(String nombre, Pageable pageable);


    @Query("SELECT p FROM Personas p WHERE UPPER(p.tipoDocumento) = UPPER(:tipoDocumento)")
    Page<Persona> findAllByTipoDocumentoIgnoreCase( @Param("tipoDocumento") String tipoDocumento, Pageable pageable);
}
