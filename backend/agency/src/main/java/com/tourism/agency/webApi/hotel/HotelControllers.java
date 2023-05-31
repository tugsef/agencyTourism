package com.tourism.agency.webApi.hotel;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.hotels.HotelService;
import com.tourism.agency.business.requests.hotels.HotelCreateRequests;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.entities.hotel.Hotel;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/hotels")
@CrossOrigin
public class HotelControllers {

	private HotelService hotelService;
	
	@GetMapping("/getAll")
	public DataResult<List<Hotel>> getAll(){
		return this.hotelService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result create(@RequestBody @Valid HotelCreateRequests createRequests) {
	  return this.hotelService.create(createRequests);
	}
	
	@PostMapping("/getAll")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result creatAll(@RequestBody Hotel hotel) {
		return this.hotelService.createAll(hotel);
	}
}
