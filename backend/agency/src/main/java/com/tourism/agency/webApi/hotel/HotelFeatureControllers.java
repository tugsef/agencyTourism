package com.tourism.agency.webApi.hotel;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.hotels.HotelFeatureService;
import com.tourism.agency.business.requests.hotels.HotelFeatureCreateRequest;
import com.tourism.agency.business.responses.hotels.HotelFeaturesByPropertyAndActiveResposes;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/hotels/feature")
public class HotelFeatureControllers {

	private HotelFeatureService featureService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result create(@RequestBody @Valid HotelFeatureCreateRequest createRequest) {
		
		return this.featureService.create(createRequest);
	}
	
	@GetMapping("/{property}")
	public DataResult<List<HotelFeaturesByPropertyAndActiveResposes>> findAllPropertyAndActive(@PathVariable String property){
		return this.featureService.findAllPropertyAndActive(property);
	}
}
