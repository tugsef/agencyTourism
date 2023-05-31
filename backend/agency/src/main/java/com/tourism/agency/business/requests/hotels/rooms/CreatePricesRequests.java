package com.tourism.agency.business.requests.hotels.rooms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePricesRequests {

	private int roomId;
	private String type;
	private double q1;
	private double q2;
	private double q3;
	private double q4;
	private int discount;
}
