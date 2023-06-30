package com.tourism.agency.business.rules.hotels.rooms;

import org.springframework.stereotype.Service;

import com.tourism.agency.dataAccess.abstracts.hotel.room.RoomImagesRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class RoomImageBussinessRules {

	private RoomImagesRepository repository;
	
	
	
	
}
