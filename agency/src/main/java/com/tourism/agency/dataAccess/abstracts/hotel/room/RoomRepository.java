package com.tourism.agency.dataAccess.abstracts.hotel.room;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.room.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
