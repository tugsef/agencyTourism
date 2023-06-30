package com.tourism.agency.webApi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.requests.hotels.rooms.FilterRequest;
import com.tourism.agency.business.responses.hotels.GetAllMapHotelResponse;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.dataAccess.abstracts.hotel.HotelsRepository;
import com.tourism.agency.entities.hotel.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
@Data
@AllArgsConstructor

public class TestSecurityController {
	private HotelsRepository repository;
	private ModelMapperService mapperService;
	@PostMapping
	public List<GetAllMapHotelResponse>  filter(@RequestBody FilterRequest filterRequest){
		List<String> roomTypes = filterRequest
												.getRoomTypes()
												.stream()
												.filter(type -> type!=null)
												.collect(Collectors.toList());
		List<Integer> hotelStars = filterRequest
				.getHotelStars()
				.stream()
				.filter(type -> type!=null)
				.collect(Collectors.toList());
		
		System.out.println(roomTypes);
		System.out.println(filterRequest);
		
		List<Hotel> hotels =this
				.repository
				.findByStarInOrRoomsTypeInOrRoomsPricesQ1Between
				(hotelStars, roomTypes,filterRequest.getFirstPrice(),filterRequest.getLastPrice());
		
		List<GetAllMapHotelResponse> hotelResponses = 
				hotels.stream()
				.map(hotel -> 
		this
		.mapperService
		.forResponse()
		.map(hotel , GetAllMapHotelResponse.class))
				.collect(Collectors.toList());
		
		return hotelResponses;
	}
}
