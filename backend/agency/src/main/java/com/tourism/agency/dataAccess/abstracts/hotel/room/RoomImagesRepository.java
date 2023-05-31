package com.tourism.agency.dataAccess.abstracts.hotel.room;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.room.RoomImages;

public interface RoomImagesRepository extends JpaRepository<RoomImages, Integer> {

}
