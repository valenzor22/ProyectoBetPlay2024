package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.EstadisticaDelPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaDelPartidoRepository extends JpaRepository<EstadisticaDelPartido, Integer> {
}

