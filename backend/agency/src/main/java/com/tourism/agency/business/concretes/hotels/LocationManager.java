package com.tourism.agency.business.concretes.hotels;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.LocationService;
import com.tourism.agency.business.requests.hotels.LocationCreateRequests;
import com.tourism.agency.business.responses.hotels.LocationGetByCityResponses;
import com.tourism.agency.business.rules.hotels.LocationBusinessRules;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.core.utilities.result.SuccessDataResult;
import com.tourism.agency.core.utilities.result.SuccessResult;
import com.tourism.agency.dataAccess.abstracts.hotel.LocationRepository;
import com.tourism.agency.entities.hotel.Location;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class LocationManager implements LocationService{
	
	private ModelMapperService mapperService;
	private LocationRepository repository;
	private LocationBusinessRules rules;
	
	@Override
	public Result create(LocationCreateRequests createRequests) {

		this.rules.checkIfHotelIdExists(createRequests.getHotelId());
		this.rules.checkIfLatitudeAndLongitudeExists(createRequests.getLatitude(), createRequests.getLongitude());

		Location location = this.mapperService.forRequest().map(createRequests, Location.class);
		location.setId(-1);
		this.repository.save(location);
		return new SuccessResult("Successful insertion");
	}

	@Override
	public DataResult<List<LocationGetByCityResponses>> findByCity(String city) {
		List<Location> locations = this.repository.findByCity(city);

	List<LocationGetByCityResponses> cityResponses = locations.stream().map(location -> this.mapperService
				.forResponse().map(location, LocationGetByCityResponses.class)).collect(Collectors.toList());
	return new SuccessDataResult<List<LocationGetByCityResponses>>(cityResponses , "Data Listed");
	}





}
