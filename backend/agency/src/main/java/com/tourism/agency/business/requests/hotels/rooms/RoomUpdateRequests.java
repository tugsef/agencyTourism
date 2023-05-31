package com.tourism.agency.business.requests.hotels.rooms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomUpdateRequests {

	private int id;
	private String decsription;
	private int capacity;
	private int squareMeters;
	private int inventory;
	private int hotelId;
}
