package com.tourism.agency.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.Agency;

public interface AcencyRepository extends JpaRepository<Agency, Integer> {

}
