package com.tourism.agency.business.responses.hotels.rooms;

import java.util.List;

import com.tourism.agency.entities.hotel.room.RoomImages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllResponsePrice {

	private int id;
	private String type;
	private double q1;
	private double q2;
	private double q3;
	private double q4;
	private int discount;
	private String roomType;
	private String roomDescription;
	private int roomCapacity;
	private int roomSquareMeters;
	private int roomInventory;
	private int roomnumberOfBeds;
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
	private List<RoomImages> roomRoomImages;
	
}
