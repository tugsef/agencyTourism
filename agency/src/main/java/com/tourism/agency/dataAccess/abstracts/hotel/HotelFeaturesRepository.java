package com.tourism.agency.dataAccess.abstracts.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.HotelFeature;

public interface HotelFeaturesRepository extends JpaRepository<HotelFeature, Integer> {

}
