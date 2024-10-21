package com.ligabtp.ligabetplay.repository;


import com.ligabtp.ligabetplay.domain.Equipo;
import com.ligabtp.ligabetplay.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    Optional<Equipo> findByNombre(String nombre);
}
