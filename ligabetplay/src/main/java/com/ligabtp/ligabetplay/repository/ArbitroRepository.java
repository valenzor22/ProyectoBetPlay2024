package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.Arbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitroRepository extends JpaRepository<Arbitro, Integer> {
}
