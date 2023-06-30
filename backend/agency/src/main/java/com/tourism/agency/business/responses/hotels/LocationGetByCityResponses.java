package com.tourism.agency.business.responses.hotels;

import java.util.List;

import com.tourism.agency.entities.hotel.room.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationGetByCityResponses {
	

	private int hotelId;
	private String hotelType;
	private String hotelName;
	private String hotelDecsription;
	private String hotelTelephone;
	private float hotelRating;
	private int hotelStar;
	private String city;
	private String district;
	private String adress;
	private String description;
	private String feature;
	private String latitude;
	private String longitude;
	private List<Room> rooms;

	
}
