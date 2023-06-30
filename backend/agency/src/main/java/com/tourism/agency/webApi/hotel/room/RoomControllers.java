package com.tourism.agency.webApi.hotel.room;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.hotels.rooms.RoomService;
import com.tourism.agency.business.requests.hotels.rooms.RoomCreateRequests;
import com.tourism.agency.business.requests.hotels.rooms.RoomRezervationSearchRequest;
import com.tourism.agency.business.requests.hotels.rooms.RoomUpdateRequests;
import com.tourism.agency.business.responses.hotels.rooms.GetHotelIdRoomDateResponse;
import com.tourism.agency.business.responses.hotels.rooms.RoomsGetAllResponses;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/api/rooms")
@Data
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class RoomControllers {

	private RoomService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result create(@RequestBody RoomCreateRequests createRequests) {
		return this.service.create(createRequests);
		
	}
	
	@GetMapping
	public DataResult<List<RoomsGetAllResponses>> getAllResponses(){
	 return	this.service.getAllReponses();
	}
	
	@PutMapping
	public Result update(@RequestBody RoomUpdateRequests updateRequests) {
		return this.service.update(updateRequests);
		
	}
	
	@DeleteMapping("/{id}")
	public Result deleteByıd(@PathVariable int id) {
		return this.service.deleteById(id);
	}
	
	@PostMapping("/search/{id}")
	public DataResult<List<GetHotelIdRoomDateResponse>> findByHotelIdRoomDate
	(@RequestBody RoomRezervationSearchRequest request,@PathVariable int id){
		return this.service.findByHotelIdRoomDate(request, id);
	}
	
	
}
