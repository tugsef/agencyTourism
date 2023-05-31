package com.tourism.agency.dataAccess.abstracts.hotel.room;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.room.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	boolean existsByHotelIdAndType(int id , String type);
	boolean existsByHotelId(int hotelId);
	boolean existsById(int id);
	
}
