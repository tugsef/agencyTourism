package com.tourism.agency.business.rules.hotels.rooms;

import org.springframework.stereotype.Service;

import com.tourism.agency.core.utilities.exception.BusinessExeption;
import com.tourism.agency.dataAccess.abstracts.hotel.room.RoomRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class RoomBussinessRules {
	
	private RoomRepository repository;

	public void  checkIfHotelIdAndTypeExists(int id , String type) {
		if(this.repository.existsByHotelIdAndType(id , type))
			throw new BusinessExeption("Hotel and type already exists");
	}
	
	public void checkIfHotelIdExists(int hotelId) {
		if(!this.repository.existsByHotelId(hotelId)&&this.repository.existsByHotelId(hotelId)) 
			throw new BusinessExeption("Hotel not found");

	}
	
	public void checkIfIdExists(int id) {
		if(!this.repository.existsById(id))
			throw new BusinessExeption("Room not found");
	}
	
}