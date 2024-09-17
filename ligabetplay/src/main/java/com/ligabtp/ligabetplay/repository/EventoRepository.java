package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
