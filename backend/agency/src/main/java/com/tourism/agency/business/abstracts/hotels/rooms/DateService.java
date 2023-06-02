package com.tourism.agency.business.abstracts.hotels.rooms;

import com.tourism.agency.business.requests.hotels.rooms.CreateDateRequest;
import com.tourism.agency.core.utilities.result.Result;

public interface DateService {

	Result createDate(CreateDateRequest createDateRequest);
	
}
