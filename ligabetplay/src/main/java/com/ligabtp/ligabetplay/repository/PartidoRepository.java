package com.ligabtp.ligabetplay.repository;



import com.ligabtp.ligabetplay.domain.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {
}
