package com.ligabtp.ligabetplay.repository;



import com.ligabtp.ligabetplay.domain.TablaDePosicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabladePosicionRepository extends JpaRepository<TablaDePosicion, Integer> {
}
