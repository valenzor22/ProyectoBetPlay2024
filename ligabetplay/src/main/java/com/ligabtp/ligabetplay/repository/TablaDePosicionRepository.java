package com.ligabtp.ligabetplay.repository;



import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TablaDePosicionRepository extends JpaRepository<TablaDePosicion, Integer> {
    Optional<TablaDePosicion> findById(Integer Id);

    boolean existsByJornadaId(Integer id);
}
