package com.ligabtp.ligabetplay.repository;



import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablaDePosicionRepository extends JpaRepository<TablaDePosicion, Integer> {
}
