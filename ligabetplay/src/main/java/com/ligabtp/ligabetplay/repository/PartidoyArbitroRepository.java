package com.ligabtp.ligabetplay.repository;


import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoyArbitroRepository extends JpaRepository<PartidoyArbitro, Integer> {
}
