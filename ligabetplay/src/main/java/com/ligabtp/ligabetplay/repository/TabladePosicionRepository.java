package com.ligabtp.ligabetplay.repository;


import com.ligabtp.ligabetplay.domain.TabladePosicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabladePosicionRepository extends JpaRepository<TabladePosicion, Integer> {
}
