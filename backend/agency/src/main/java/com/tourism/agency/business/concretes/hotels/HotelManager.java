package com.tourism.agency.business.concretes.hotels;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.HotelService;
import com.tourism.agency.business.requests.hotels.HotelCreateRequests;
import com.tourism.agency.business.rules.hotels.HotelBussinessRules;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.core.utilities.result.SuccessDataResult;
import com.tourism.agency.core.utilities.result.SuccessResult;
import com.tourism.agency.dataAccess.abstracts.hotel.HotelsRepository;
import com.tourism.agency.entities.hotel.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class HotelManager implements HotelService {

	private HotelsRepository hotelsRepository;
	private ModelMapperService modelMapperService;
	private HotelBussinessRules rules;
	
	@Override
	public DataResult<List<Hotel>> getAll() {
		return new SuccessDataResult<List<Hotel>>(this.hotelsRepository.findAll(), "Data listed");
	}

	@Override
	public Result create(HotelCreateRequests createRequests) {
		this.rules.existsByName(createRequests.getName());
		Hotel hotel = this.modelMapperService.forRequest().map(createRequests, Hotel.class);
		hotel.setId(-1);
		this.hotelsRepository.save(hotel);
		return new SuccessResult("Successful insertion");
	}

	@Override
	public Result createAll(Hotel hotel) {
	this.hotelsRepository.save(hotel);
		return new SuccessResult("Güncellendi");
	}


	
	

}
