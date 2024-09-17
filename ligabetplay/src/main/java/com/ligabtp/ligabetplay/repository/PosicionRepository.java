package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicionRepository extends JpaRepository<Posicion, Integer> {
}
