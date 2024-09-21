package com.ligabtp.ligabetplay.repository;


import com.ligabtp.ligabetplay.domain.Jornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Integer> {
}