package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.EstadisticadelPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticadelPartidoRepository extends JpaRepository<EstadisticadelPartido, Integer> {
}


