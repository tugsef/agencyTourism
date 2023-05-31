package com.tourism.agency.business.rules.hotels.rooms;

import org.springframework.stereotype.Service;

import com.tourism.agency.core.utilities.exception.BusinessExeption;
import com.tourism.agency.dataAccess.abstracts.hotel.room.FeaturesRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class FeatureBussinessRules {

	private FeaturesRepository repository;
	
	public void checkIfRoomIdAndPropertyExists(int id , String property) {
		if(this.repository.existsByRoomIdAndProperty(id, property))
			throw new BusinessExeption("Room and Property already exists");
	}
	
	public void checkIfIdAndRoomId(int id, int room_id) {
		if(!this.repository.existsByIdAndRoomId(id, room_id))
			throw new BusinessExeption("Feature or Room not found");
	}
	
	public void checkIfIdexists(int id) {
		if(!this.repository.existsById(id)) 
			throw new BusinessExeption("Room Feature Not Found");
	}
	
}
