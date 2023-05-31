package com.tourism.agency.business.requests.hotels.rooms;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomImagesRequests {

	@NotNull
	private String url;

	@NotNull
	private int roomId;

}
