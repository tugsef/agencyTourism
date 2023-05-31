package com.tourism.agency.business.concretes.hotels.rooms;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.rooms.PriceService;
import com.tourism.agency.business.requests.hotels.rooms.CreatePricesRequests;
import com.tourism.agency.business.rules.hotels.rooms.PriceBussinessRules;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.core.utilities.result.SuccessResult;
import com.tourism.agency.dataAccess.abstracts.hotel.room.PriceRepository;
import com.tourism.agency.entities.hotel.room.Price;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class PriceManager implements PriceService{
	
	private PriceRepository repository;
	private ModelMapperService mapperService;
	private PriceBussinessRules rules;

	@Override
	public Result create(CreatePricesRequests pricesRequests) {
		this.rules.checkIfByRoomIdAndType(pricesRequests.getRoomId(), pricesRequests.getType());
		Price price = this.mapperService.forRequest().map(pricesRequests, Price.class);
		price.setId(-1);
		this.repository.save(price);
		
		return new SuccessResult("Data added");
	}

}
