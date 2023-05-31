package com.tourism.agency.webApi.hotel.room;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.hotels.rooms.FeatureService;
import com.tourism.agency.business.requests.hotels.rooms.CreateFeaturesRequest;
import com.tourism.agency.business.requests.hotels.rooms.UpdateFeatureRequest;
import com.tourism.agency.business.responses.hotels.rooms.FindAllByPropertyResponse;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/rooms/features")
public class FeatureControllers {

	private FeatureService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result create(@RequestBody CreateFeaturesRequest featuresRequest) {
		return this.service.create(featuresRequest);
	}
	
	@PutMapping
	public Result update(@RequestBody UpdateFeatureRequest featureRequest) {
		return this.service.update(featureRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result deleteById(@PathVariable int id) {
		return this.service.delete(id);
	}
	
	@GetMapping("/{property}")
	public DataResult<List<FindAllByPropertyResponse>> findByProperty(@PathVariable String property) {
		return this.service.findByProperty(property);
	}
	
	
}
