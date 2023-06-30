package com.tourism.agency.dataAccess.abstracts.hotel;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.Hotel;

public interface HotelsRepository extends JpaRepository<Hotel, Integer> {

	boolean existsByName(String name);

	List<Hotel> findByOrderByRatingDescRoomsPricesQ1Asc(Pageable pageable);

	List<Hotel> findByLocationCityAndRoomsInventoryGreaterThanEqualAndRoomsDateRoomsDateIn(String city, int capacity,
			List<Date> date);

	List<Hotel> findByStarInOrRoomsTypeInOrRoomsPricesQ1Between(List<Integer> hotelStars, List<String> roomTypes,
			double firstPrice, double lastPrice);
	
	

}