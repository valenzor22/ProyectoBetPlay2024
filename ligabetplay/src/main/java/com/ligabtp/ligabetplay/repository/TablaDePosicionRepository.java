package com.ligabtp.ligabetplay.repository;



import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablaDePosicionRepository extends JpaRepository<TablaDePosicion, Integer> {
    Optional<TablaDePosicion> findByNombre(String nombre);
}
