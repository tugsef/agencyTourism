package com.tourism.agency.business.abstracts.hotels.rooms;

import java.util.List;

import com.tourism.agency.business.requests.hotels.rooms.CreateFeaturesRequest;
import com.tourism.agency.business.requests.hotels.rooms.UpdateFeatureRequest;
import com.tourism.agency.business.responses.hotels.rooms.FindAllByPropertyResponse;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;

public interface FeatureService {
	
	Result create(CreateFeaturesRequest featuresRequest);
	
	Result update(UpdateFeatureRequest featureRequest);
	
	Result delete(int id);
	
	DataResult<List<FindAllByPropertyResponse>>  findByProperty(String property);
	

}
