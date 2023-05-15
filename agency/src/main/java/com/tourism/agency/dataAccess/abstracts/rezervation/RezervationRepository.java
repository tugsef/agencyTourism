package com.tourism.agency.dataAccess.abstracts.rezervation;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.rezervation.Rezervation;

public interface RezervationRepository extends JpaRepository<Rezervation, Integer>{

}
