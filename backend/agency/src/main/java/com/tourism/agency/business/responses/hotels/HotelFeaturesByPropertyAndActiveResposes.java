package com.tourism.agency.business.responses.hotels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelFeaturesByPropertyAndActiveResposes {
	
	private int hotelId;
	private String hotelType;
	private String hotelName;
	private String hotelDecsription;
	private String hotelTelephone;
	private float hotelRating;
	private int hotelStar;
		
}
