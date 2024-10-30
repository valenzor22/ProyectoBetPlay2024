package com.ligabtp.ligabetplay.repository;


import com.ligabtp.ligabetplay.domain.Jornada;
import com.ligabtp.ligabetplay.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Integer> {

    Optional<Jornada> findByNombre(String nombre);
}