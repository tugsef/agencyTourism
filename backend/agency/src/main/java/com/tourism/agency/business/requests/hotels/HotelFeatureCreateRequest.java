package com.tourism.agency.business.requests.hotels;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelFeatureCreateRequest {

	@NotNull
	private boolean active;

	@NotNull
	private String description;

	@NotNull
	private String property;

	@NotNull
	private int hotelId;

	@NotNull
	private int numberOfBeds;

}
