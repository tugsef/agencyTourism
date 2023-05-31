package com.tourism.agency.webApi.hotel;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.hotels.LocationService;
import com.tourism.agency.business.requests.hotels.LocationCreateRequests;
import com.tourism.agency.business.responses.hotels.LocationGetByCityResponses;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/location")
public class LocationControllers {
		
	private LocationService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result create(@RequestBody LocationCreateRequests createRequests) {
		return this.service.create(createRequests);
	}
	
	@GetMapping("/{city}")
	public DataResult<List<LocationGetByCityResponses>> findByCity(@PathVariable String city){
		return this.service.findByCity(city);
	}

}
