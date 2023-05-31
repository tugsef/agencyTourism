package com.tourism.agency.dataAccess.abstracts.hotel.room;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.room.Price;

public interface PriceRepository extends JpaRepository<Price, Integer>  {

	boolean existsByRoomIdAndType(int roomId ,String type );
}
