package com.tourism.agency.business.requests.hotels.rooms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomCreateRequests {
	
	private int hotelId;
	private String type;
	private String decsription;
	private int capacity;
	private int squareMeters;
	private int inventory;
	private int numberOfBeds;

}
