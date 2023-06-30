package com.tourism.agency.webApi.hotel;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.hotels.HotelService;
import com.tourism.agency.business.requests.hotels.HotelCreateRequests;
import com.tourism.agency.business.requests.hotels.rooms.FilterRequest;
import com.tourism.agency.business.responses.hotels.GetAllMapHotelResponse;
import com.tourism.agency.business.responses.hotels.GetCityCapacityDate;
import com.tourism.agency.business.rules.hotels.rooms.DateRoomBusinessRules;
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
	private DateRoomBusinessRules dateRoomBusinessRules;

	@GetMapping("/getAll")
	public DataResult<List<Hotel>> getAll() {
		return this.hotelService.getAll();
	}

	@GetMapping("/getAllMap")
	public DataResult<List<GetAllMapHotelResponse>> getAllMap(@RequestParam(value = "pageNo") int pageNo,
			@RequestParam(value = "pageSize") int pageSize) {

		return this.hotelService.getAllMap(pageNo);
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

	@GetMapping("/{id}")
	public DataResult<Hotel> getById(@PathVariable int id) {
		return this.hotelService.getById(id);
	}

	@GetMapping("/ratingsort/{pageNo}")
	public DataResult<List<GetAllMapHotelResponse>> getAllRatingSort(@PathVariable int pageNo) {

		return this.hotelService.getAllRatingSort(pageNo);
	}

	@GetMapping("/starDesc/{pageNo}")
	public DataResult<List<GetAllMapHotelResponse>> getAllStarSortDesc(@PathVariable int pageNo) {
		return this.hotelService.getAllStarSortDesc(pageNo);
	}

	@GetMapping("/starAsc/{pageNo}")
	public DataResult<List<GetAllMapHotelResponse>> getAllStarSortAsc(@PathVariable int pageNo) {
		return this.hotelService.getAllStarSortAsc(pageNo);
	}

	@GetMapping("/ratingdescpriceasc/{pageNo}")
	public DataResult<List<GetAllMapHotelResponse>> findByOrderByRatingDescRoomsPricesQ1Asc(@PathVariable int pageNo) {
		return this.hotelService.findByOrderByRatingDescRoomsPricesQ1Asc(pageNo);
	}

	@PostMapping("/search")
	public DataResult<List<GetAllMapHotelResponse>> findByLocationCityAndRoomsCapacityLessThanEqualAndRoomsDateRoomsDateIn
	(@RequestBody GetCityCapacityDate cityCapacityDate) {
		
		System.out.println(cityCapacityDate);
		
		int capacity = cityCapacityDate.getChild() + cityCapacityDate.getAdult();
		
		List<Date> dates = this
				.dateRoomBusinessRules
				.dateList(cityCapacityDate.getCheckInDate(),
						
				cityCapacityDate.getCheckOutDate());
		
		return this
				.hotelService
				.findByLocationCityAndRoomsCapacityLessThanEqualAndRoomsDateRoomsDateIn
				(cityCapacityDate.getCity(), capacity, dates);
	}

	@PostMapping("/filter")
	public DataResult<List<GetAllMapHotelResponse>> filterHotel(@RequestBody FilterRequest filterRequest) {
		
		System.out.println(filterRequest);
		
		return this.hotelService.filterHotel(filterRequest);
	}

}
