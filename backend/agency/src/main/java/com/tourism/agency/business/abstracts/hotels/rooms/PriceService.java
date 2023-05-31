package com.tourism.agency.business.abstracts.hotels.rooms;

import java.util.List;

import com.tourism.agency.business.requests.hotels.rooms.CreatePricesRequests;
import com.tourism.agency.business.responses.hotels.rooms.GetAllResponsePrice;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;

public interface PriceService {

	Result create(CreatePricesRequests pricesRequests);
	
	DataResult<List<GetAllResponsePrice>> getAll();
}
