package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {
}
