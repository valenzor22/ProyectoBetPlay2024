package com.ligabtp.ligabetplay.repository;

import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartidoyArbitroRepository extends JpaRepository<PartidoyArbitro, Integer> {

    Boolean existsByPartidoyArbitroId(Integer partidoyArbitroId);

}