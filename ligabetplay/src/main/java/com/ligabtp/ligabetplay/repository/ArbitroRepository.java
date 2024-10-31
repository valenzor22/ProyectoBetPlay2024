package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.Arbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ArbitroRepository extends JpaRepository<Arbitro, Integer> {

    Optional<Arbitro> findByNombre(String nombre);
}

