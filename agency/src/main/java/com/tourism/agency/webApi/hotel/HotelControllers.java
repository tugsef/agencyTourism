package com.tourism.agency.webApi.hotel;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.HotelService;
import com.tourism.agency.core.utilities.DataResult;
import com.tourism.agency.entities.hotel.Hotel;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class HotelControllers {

	private HotelService hotelService;
	
	@GetMapping("/getAll")
	public DataResult<List<Hotel>> getAll(){
		return this.hotelService.getAll();
	}
	
	
}
