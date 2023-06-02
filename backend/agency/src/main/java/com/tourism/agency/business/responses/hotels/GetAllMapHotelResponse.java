package com.tourism.agency.business.responses.hotels;

import java.util.List;

import com.tourism.agency.entities.hotel.room.Price;
import com.tourism.agency.entities.hotel.room.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMapHotelResponse {
	private int id;
	private String type;
	private String name;
	private String decsription;
	private String telephone;
	private float rating;
	private int star;
	private String locationCity;
	private String locationDistrict;
	private String locationAdress;
	private String locationDescription;
	private String locationFeature;
	private String locationLatitude;
	private String locationLongitude;
	private List<Room> rooms;
	
}
