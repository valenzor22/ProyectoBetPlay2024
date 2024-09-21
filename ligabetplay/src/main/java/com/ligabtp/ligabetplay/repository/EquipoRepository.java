package com.ligabtp.ligabetplay.repository;


import com.ligabtp.ligabetplay.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
}
