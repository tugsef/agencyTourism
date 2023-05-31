package com.tourism.agency.webApi.hotel.room;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.hotels.rooms.PriceService;
import com.tourism.agency.business.requests.hotels.rooms.CreatePricesRequests;
import com.tourism.agency.business.responses.hotels.rooms.GetAllResponsePrice;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/rooms/prices")
public class PriceControllers {

	private PriceService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result create(CreatePricesRequests pricesRequests) {
		return this.service.create(pricesRequests);
	}
	
	@GetMapping
	public DataResult<List<GetAllResponsePrice>> getAll(){
		return this.service.getAll();
	}
}
