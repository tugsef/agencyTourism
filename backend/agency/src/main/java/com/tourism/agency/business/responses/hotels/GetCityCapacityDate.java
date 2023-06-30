package com.tourism.agency.business.responses.hotels;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetCityCapacityDate {

	private String city;
	private String checkInDate;
	private String checkOutDate;
	private int adult;
	private int child;
	
}
