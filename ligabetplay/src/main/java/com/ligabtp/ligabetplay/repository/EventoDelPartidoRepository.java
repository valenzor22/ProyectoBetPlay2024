package com.ligabtp.ligabetplay.repository;


import com.ligabtp.ligabetplay.domain.EventoDelPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoDelPartidoRepository extends JpaRepository<EventoDelPartido, Integer> {
}