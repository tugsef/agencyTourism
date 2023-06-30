package com.tourism.agency.business.requests.hotels.rooms;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterRequest {
	List<String> roomTypes;
	List<Integer> hotelStars;
    double	firstPrice;
    double lastPrice;
}
