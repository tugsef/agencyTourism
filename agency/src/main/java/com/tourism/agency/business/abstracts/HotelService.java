package com.tourism.agency.business.abstracts;

import java.util.List;

import com.tourism.agency.core.utilities.DataResult;
import com.tourism.agency.entities.hotel.Hotel;

public interface HotelService {
	
	DataResult<List<Hotel>> getAll();
}
