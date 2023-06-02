package com.tourism.agency.dataAccess.abstracts.hotel.room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.room.Price;

public interface PriceRepository extends JpaRepository<Price, Integer>  {

	boolean existsByRoomIdAndType(int roomId ,String type );
	List<Price> findByQ1(double q1);
}
