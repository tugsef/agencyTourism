package com.tourism.agency.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.HotelService;
import com.tourism.agency.core.utilities.DataResult;
import com.tourism.agency.core.utilities.SuccessDataResult;
import com.tourism.agency.dataAccess.abstracts.hotel.HotelsRepository;
import com.tourism.agency.entities.hotel.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class HotelManager implements HotelService{
	
	private HotelsRepository hotelsRepository;

	@Override
	public DataResult<List<Hotel>> getAll() {
		
		return new SuccessDataResult<List<Hotel>>
						(this.hotelsRepository.findAll(), "Data Listelendi" );
	}
	
	
}
