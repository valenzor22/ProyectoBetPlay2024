package com.ligabtp.ligabetplay.repository;


import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoDelPartidoRepository extends JpaRepository<EventoDelPartido, Integer> {

    // Method to check if an EventoDelPartido exists by id_partido
    boolean existsByTipoEventoId(Integer id);

    boolean existsByPartidoId(Integer id);
}