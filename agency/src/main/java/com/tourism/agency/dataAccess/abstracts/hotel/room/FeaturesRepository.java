package com.tourism.agency.dataAccess.abstracts.hotel.room;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.room.Feature;

public interface FeaturesRepository extends JpaRepository<Feature, Integer> {

}
