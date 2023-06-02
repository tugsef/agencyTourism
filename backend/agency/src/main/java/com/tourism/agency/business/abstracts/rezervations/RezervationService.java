package com.tourism.agency.business.abstracts.rezervations;

import java.util.List;

import com.tourism.agency.business.requests.hotels.CreateRezervationRequest;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.entities.rezervation.Rezervation;

public interface RezervationService {

	DataResult<List<Rezervation>> getAll();
	
	Result create(CreateRezervationRequest request);
	
}
