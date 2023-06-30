package com.tourism.agency.business.responses.hotels.rooms;

import java.util.List;
import com.tourism.agency.entities.hotel.room.DateRoom;
import com.tourism.agency.entities.hotel.room.Feature;
import com.tourism.agency.entities.hotel.room.Price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetHotelIdRoomDateResponse {
	private int hotelId;
	private String hotelType;
	private String hotelName;
	private String hotelDecsription;
	private String hotelTelephone;
	private float hotelRating;
	private int hotelStar;
	private String locationCity;
	private String locationDistrict;
	private String locationAdress;
	private String locationDescription;
	private String locationFeature;
	private String locationLatitude;
	private String locationLongitude;
	private  String type;
	private String decsription;
	private int capacity;
	private int squareMeters;
	private int inventory;
	private int numberOfBeds;
	private List<Feature> features;
	private List<DateRoom> dateRooms;
	private List<Price> prices;
}
