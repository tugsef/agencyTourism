package com.tourism.agency.business.requests.hotels.rooms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFeaturesRequest {

	private String property;
	private String description;
	private boolean active;
	private int roomId;
}
