package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Integer> {
}
