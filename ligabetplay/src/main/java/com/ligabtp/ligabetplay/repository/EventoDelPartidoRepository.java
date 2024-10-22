package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EventoDelPartidoRepository extends JpaRepository<EventoDelPartido, Integer> {
    Optional<EventoDelPartido> findByNombre(String nombre);
}