package com.tourism.agency.dataAccess.abstracts.hotel.room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.hotel.room.Price;

public interface PriceRepository extends JpaRepository<Price, Integer> {

	boolean existsByRoomIdAndType(int roomId, String type);

	List<Price> findByQ1(double q1);

	List<Price> findByq1Between(double firstPrice, double lastPrice);

	List<Price> findByRoomTypeIn(List<String> roomTypes);

	List<Price> findByRoomHotelStarIn(List<Integer> hotelStars);

	List<Price> findByq1BetweenAndRoomTypeInAndRoomHotelStarIn(double firstPrice, double lastPrice,
			List<String> roomTypes, List<Integer> hotelStars);

	List<Price> findByq1BetweenOrRoomTypeInOrRoomHotelStarIn(double firstPrice, double lastPrice,
			List<String> roomTypes, List<Integer> hotelStars);

	List<Price> findByRoomTypeInAndRoomHotelStarIn(List<String> roomTypes, List<Integer> hotelStars);
}
