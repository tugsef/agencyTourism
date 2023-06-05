package com.tourism.agency.business.abstracts.hotels;

import java.util.List;

import com.tourism.agency.business.requests.hotels.HotelCreateRequests;
import com.tourism.agency.business.responses.hotels.GetAllMapHotelResponse;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.entities.hotel.Hotel;

public interface HotelService {

	DataResult<List<Hotel>> getAll();

	Result create(HotelCreateRequests createRequests);
	
	Result createAll(Hotel hotel);
	
	DataResult<Hotel> getById(int id);
	
	DataResult<List<GetAllMapHotelResponse>> getAllRatingSort(int pageNo);
	
	DataResult<List<GetAllMapHotelResponse>> getAllStarSortDesc(int pageNo);
	DataResult<List<GetAllMapHotelResponse>> getAllStarSortAsc(int pageNo);
	
}
