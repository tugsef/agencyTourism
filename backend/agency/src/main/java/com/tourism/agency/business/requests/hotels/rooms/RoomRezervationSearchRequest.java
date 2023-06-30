package com.tourism.agency.business.requests.hotels.rooms;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRezervationSearchRequest {
	
	@NotNull
	private String checkInDate;
	
	@NotNull
	private String checkOutDate;
	
	@NotNull
	private int adult;
	
	@NotNull
	private int child;
}
