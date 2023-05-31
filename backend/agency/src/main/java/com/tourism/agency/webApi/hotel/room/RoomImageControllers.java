package com.tourism.agency.webApi.hotel.room;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.hotels.rooms.RoomImagesService;
import com.tourism.agency.business.requests.hotels.rooms.RoomImagesRequests;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("api/room/image")
@AllArgsConstructor
public class RoomImageControllers {
	
	private RoomImagesService service;
	
	@PostMapping
	public void createImage(@RequestBody RoomImagesRequests requests ) {
		
		this.service.createImg(requests);
	}
	
}
