package com.tourism.agency.business.abstracts.hotels;

import java.util.List;

import com.tourism.agency.business.requests.hotels.HotelFeatureCreateRequest;
import com.tourism.agency.business.responses.hotels.HotelFeaturesByPropertyAndActiveResposes;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;

public interface HotelFeatureService {
	
	Result create(HotelFeatureCreateRequest createRequest);
	
	DataResult<List<HotelFeaturesByPropertyAndActiveResposes>> findAllPropertyAndActive(String property);
	
	

}
