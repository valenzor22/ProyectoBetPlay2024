package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEvento, Integer> {
    Optional<TipoEvento> findByNombre(String nombre);
}