package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.TipoArbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoArbitroRepository extends JpaRepository<TipoArbitro, Integer> {
}
