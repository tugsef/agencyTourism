package com.tourism.agency.business.responses.hotels.rooms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByQ1Responses {

	private String type;
	private double q1;
	private double q2;
	private double q3;
	private double q4;
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
	private  String roomType;
	private String roomDecsription;
	private int roomCapacity;
	private int roomSquareMeters;
	private int roomInventory;
	private int roomNumberOfBeds;
}
