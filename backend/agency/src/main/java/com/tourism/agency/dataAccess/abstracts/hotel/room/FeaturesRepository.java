package com.tourism.agency.dataAccess.abstracts.hotel.room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.room.Feature;

public interface FeaturesRepository extends JpaRepository<Feature, Integer> {

	boolean existsByRoomIdAndProperty(int id , String property);
	boolean existsByIdAndRoomId(int id , int roomId);
	boolean existsById(int id);
	List<Feature> findByPropertyAndActive(String property , boolean active);
}
