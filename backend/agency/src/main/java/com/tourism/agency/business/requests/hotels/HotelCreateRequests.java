package com.tourism.agency.business.requests.hotels;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
							
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelCreateRequests {

	@NotNull
	private String decsription;

	@NotNull
	private String name;

	@NotNull
	private float rating;

	private String telephone;

	@NotNull
	private String type;
	
	@NotNull
	private int star;

	@NotNull
	private int agencyId;
	
	
	
	
}
