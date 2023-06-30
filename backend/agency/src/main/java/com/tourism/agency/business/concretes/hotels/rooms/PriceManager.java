package com.tourism.agency.business.concretes.hotels.rooms;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.rooms.PriceService;
import com.tourism.agency.business.requests.hotels.rooms.CreatePricesRequests;
import com.tourism.agency.business.requests.hotels.rooms.FilterRequest;
import com.tourism.agency.business.responses.hotels.rooms.GetAllResponsePrice;
import com.tourism.agency.business.responses.hotels.rooms.GetByQ1Responses;
import com.tourism.agency.business.rules.hotels.rooms.PriceBussinessRules;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.core.utilities.result.SuccessDataResult;
import com.tourism.agency.core.utilities.result.SuccessResult;
import com.tourism.agency.dataAccess.abstracts.hotel.room.PriceRepository;
import com.tourism.agency.entities.hotel.room.Price;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class PriceManager implements PriceService {

	private PriceRepository repository;
	private ModelMapperService mapperService;
	private PriceBussinessRules rules;

	@Override
	public Result create(CreatePricesRequests pricesRequests) {
		this.rules.checkIfByRoomIdAndType(pricesRequests.getRoomId(), pricesRequests.getType());
		Price price = this
				.mapperService
				.forRequest()
				.map(pricesRequests, Price.class);
		price.setId(-1);
		this.repository.save(price);

		return new SuccessResult("Data added");
	}

	@Override
	public DataResult<List<GetAllResponsePrice>> getAll() {
		List<Price> prices = this
				.repository
				.findAll();
		List<GetAllResponsePrice> getAllResponsePrices = prices.stream()
				.map(price -> this.mapperService.forResponse().map(price, GetAllResponsePrice.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllResponsePrice>>(getAllResponsePrices, "Data listed");
	}

	@Override
	public DataResult<List<GetByQ1Responses>> getAllByPriceQ1(double q1) {
			
		List<Price> prices = this
				.repository
				.findByQ1(q1);
		
		List<GetByQ1Responses> responses = prices.stream()
				.map(p -> this
						.mapperService
						.forResponse()
						.map(p, GetByQ1Responses.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetByQ1Responses>>(responses, "Data Listed Price q1");
	}

	@Override
	public DataResult<List<GetByQ1Responses>> getAllPriceSortAsc(int pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 7, Sort.by("q1").ascending());
		List<Price> prices = this.repository.findAll(pageable).getContent();
		List<GetByQ1Responses> priByQ1Responses = prices.stream()
				.map(price -> this.mapperService.forResponse().map(price, GetByQ1Responses.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetByQ1Responses>>(priByQ1Responses, "Price Asc Price Otel");
	}

	@Override
	public DataResult<List<GetByQ1Responses>> getAllPriceSortDesc(int pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 7, Sort.by("q1").descending());
		List<Price> prices = this.repository.findAll(pageable).getContent();
		List<GetByQ1Responses> priByQ1Responses = prices.stream()
				.map(price -> this.mapperService.forResponse().map(price, GetByQ1Responses.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetByQ1Responses>>(priByQ1Responses, "Price Asc Price Otel");
	}

	@Override
	public DataResult<List<GetByQ1Responses>> filterHotel(FilterRequest filterRequest) {
		List<Price> prices = null;
		List<String> roomTypes = filterRequest.getRoomTypes().stream().filter(type -> type != null)
				.collect(Collectors.toList());
		List<Integer> hotelStars = filterRequest.getHotelStars().stream().filter(type -> type != null)
				.collect(Collectors.toList());

		System.out.println(roomTypes);
		System.out.println(hotelStars);
		System.out.println(filterRequest);

	
		
		if (roomTypes.isEmpty() && hotelStars.isEmpty()) {
			System.out.println("1");
			prices = this.repository.findByq1Between(filterRequest.getFirstPrice(), filterRequest.getLastPrice());

		} else if (!roomTypes.isEmpty() && !hotelStars.isEmpty()) {
			prices = this.repository.findByq1BetweenAndRoomTypeInAndRoomHotelStarIn(filterRequest.getFirstPrice(),
					filterRequest.getLastPrice(), roomTypes, hotelStars);
		} else if (!hotelStars.isEmpty()) {
			System.out.println("2");
			prices = this.repository.findByRoomHotelStarIn(hotelStars);
		} else if (!roomTypes.isEmpty()) {
			System.out.println("3");
			prices = this.repository.findByRoomTypeIn(roomTypes);
		} else {
			System.out.println("4");
			prices = this.repository.findByq1BetweenOrRoomTypeInOrRoomHotelStarIn(filterRequest.getFirstPrice(),
					filterRequest.getLastPrice(), roomTypes, hotelStars);
		}

		List<GetByQ1Responses> priceResponses = prices.stream()
				.map(price -> this.mapperService.forResponse().map(price, GetByQ1Responses.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetByQ1Responses>>(priceResponses, "Data listed");
	}
}
