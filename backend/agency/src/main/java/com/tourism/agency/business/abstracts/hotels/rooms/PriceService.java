package com.tourism.agency.business.abstracts.hotels.rooms;

import com.tourism.agency.business.requests.hotels.rooms.CreatePricesRequests;
import com.tourism.agency.core.utilities.result.Result;

public interface PriceService {

	Result create(CreatePricesRequests pricesRequests);
}
