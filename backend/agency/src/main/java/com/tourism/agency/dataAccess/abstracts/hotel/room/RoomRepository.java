package com.tourism.agency.dataAccess.abstracts.hotel.room;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.room.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

	boolean existsByHotelIdAndType(int id, String type);

	boolean existsByHotelId(int hotelId);

	boolean existsById(int id);

	List<Room> findByHotelIdAndInventoryGreaterThanEqualAndDateRoomsDateIn(int hotelId , int inventory , List<Date> dates );

}
