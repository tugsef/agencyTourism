package com.tourism.agency.dataAccess.abstracts.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

}
