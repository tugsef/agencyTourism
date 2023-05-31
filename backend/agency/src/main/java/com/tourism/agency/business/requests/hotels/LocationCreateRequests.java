package com.tourism.agency.business.requests.hotels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationCreateRequests {

	private String city;
	private String district;
	private String adress;
	private String description;
	private String feature;	
	private String latitude;
	private String longitude;
	private int hotelId;
	
}
