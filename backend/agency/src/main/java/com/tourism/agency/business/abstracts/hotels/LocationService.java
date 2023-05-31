package com.tourism.agency.business.abstracts.hotels;

import java.util.List;

import com.tourism.agency.business.requests.hotels.LocationCreateRequests;
import com.tourism.agency.business.responses.hotels.LocationGetByCityResponses;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;

public interface LocationService {
	
	Result create(LocationCreateRequests createRequests);
	
	DataResult<List<LocationGetByCityResponses>> findByCity(String city);
}
