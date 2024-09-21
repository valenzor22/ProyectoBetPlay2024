package com.ligabtp.ligabetplay.repository;


import com.ligabtp.ligabetplay.domain.TabladePosicion;
import com.ligabtp.ligabetplay.domain.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEvento, Integer> {
}
