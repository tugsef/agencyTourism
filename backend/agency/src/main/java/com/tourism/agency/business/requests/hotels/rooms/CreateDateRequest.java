package com.tourism.agency.business.requests.hotels.rooms;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDateRequest {
	private int roomId;
	private String checkInDate;
	private String checkOutDate;
}
