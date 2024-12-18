package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.AsignacionJugadorEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AsignacionJugadorEquipoRepository extends JpaRepository<AsignacionJugadorEquipo, Integer> {

    boolean existsByEquipoId(Integer id);
    boolean existsByJugadorId(Integer id);
}

