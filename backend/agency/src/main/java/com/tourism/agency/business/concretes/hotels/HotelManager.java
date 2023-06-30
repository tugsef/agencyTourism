package com.tourism.agency.business.concretes.hotels;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.HotelService;
import com.tourism.agency.business.requests.hotels.HotelCreateRequests;
import com.tourism.agency.business.requests.hotels.rooms.FilterRequest;
import com.tourism.agency.business.responses.hotels.GetAllMapHotelResponse;
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

	@Override
	public DataResult<Hotel> getById(int id) {
		Hotel hotel = this.hotelsRepository.findById(id).orElseThrow();
		return new SuccessDataResult<Hotel>(hotel, "Data Hotel Listed");
	}

	@Override
	public DataResult<List<GetAllMapHotelResponse>> getAllRatingSort(int pageNo) {
		
		Pageable pageable = PageRequest.of(pageNo - 1, 7, Sort.by("rating").descending()); // azalan
		
		List<Hotel> hotels = this.hotelsRepository.findAll(pageable).getContent();
		List<GetAllMapHotelResponse> hotelResponses = 
				hotels
				.stream()
				.map(hotel -> this.modelMapperService.forResponse().map(hotel, GetAllMapHotelResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllMapHotelResponse>>(hotelResponses, "Data Asc Rating Otel");
	}

	@Override
	public DataResult<List<GetAllMapHotelResponse>> getAllStarSortDesc(int pageNo) {
		// Sort sort = Sort.by(Sort.Direction.DESC, "star");
		Pageable pageable = PageRequest.of(pageNo - 1, 7, Sort.by("star").descending()); // azalan
		
		List<Hotel> hotels = this.hotelsRepository.findAll(pageable).getContent();
		
		List<GetAllMapHotelResponse> hotelResponses = hotels
				.stream()
				.map(hotel -> this
						.modelMapperService
						.forResponse()
						.map(hotel, GetAllMapHotelResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllMapHotelResponse>>(hotelResponses, "Data Desc Rating Otel");

	}

	@Override
	public DataResult<List<GetAllMapHotelResponse>> getAllStarSortAsc(int pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 7, Sort.by("star").ascending()); // azalan

		List<Hotel> hotels = this.hotelsRepository.findAll(pageable).getContent();
		List<GetAllMapHotelResponse> hotelResponses = 
				hotels
				.stream()
				.map(hotel -> this.modelMapperService.forResponse().map(hotel, GetAllMapHotelResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllMapHotelResponse>>(hotelResponses, "Data Asc Rating Otel");
	}

	@Override
	public DataResult<List<GetAllMapHotelResponse>> getAllMap(int pageNo) {
		
		Pageable pageable = PageRequest.of(pageNo - 1, 7);
		
		List<Hotel> hotels = this.hotelsRepository.findAll(pageable).getContent();
		
		List<GetAllMapHotelResponse> responses = 
				hotels
				.stream()
				.map(hotel -> this
						.modelMapperService
						.forResponse()
						.map(hotel, GetAllMapHotelResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<>(responses, "Data Listes");
	}

	@Override
	public DataResult<List<GetAllMapHotelResponse>> findByOrderByRatingDescRoomsPricesQ1Asc(int pageNo) {
		
		Pageable pageable = PageRequest.of(pageNo - 1, 21);
		
		List<Hotel> hotels = this.hotelsRepository.findByOrderByRatingDescRoomsPricesQ1Asc(pageable);
		
		List<GetAllMapHotelResponse> responses = 
				hotels
				.stream()
				.map(hotel -> this
						.modelMapperService
						.forResponse()
						.map(hotel, GetAllMapHotelResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<>(responses, "Data Listed");
	}

	@Override
	public DataResult<List<GetAllMapHotelResponse>> findByLocationCityAndRoomsCapacityLessThanEqualAndRoomsDateRoomsDateIn
	(String city, int capacity, List<Date> date) {
		
		List<Hotel> hotels = this
				.hotelsRepository
				.findByLocationCityAndRoomsInventoryGreaterThanEqualAndRoomsDateRoomsDateIn(city, capacity, date);
		
		List<GetAllMapHotelResponse> hotelResponses = 
				hotels
				.stream()
				.map(hotel -> this
						.modelMapperService
						.forResponse()
						.map(hotel, GetAllMapHotelResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllMapHotelResponse>>(hotelResponses, "Data Listed");
	}

	@Override
	public DataResult<List<GetAllMapHotelResponse>> filterHotel(FilterRequest filterRequest) {
		
		List<String> roomTypes = filterRequest
				.getRoomTypes()
				.stream()
				.filter(type -> type != null)
				.collect(Collectors.toList());
		
		List<Integer> hotelStars = filterRequest
				.getHotelStars()
				.stream()
				.filter(type -> type != null)
				.collect(Collectors.toList());

		System.out.println(roomTypes);
		System.out.println(filterRequest);
		
		List<Hotel> hotels = this
				.hotelsRepository
				.findByStarInOrRoomsTypeInOrRoomsPricesQ1Between(hotelStars,
						
				roomTypes, filterRequest.getFirstPrice(), filterRequest.getLastPrice());
		
		List<GetAllMapHotelResponse> hotelResponses =
				hotels.stream()
				.map(hotel -> this
						.modelMapperService
						.forResponse()
						.map(hotel, GetAllMapHotelResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllMapHotelResponse>>(hotelResponses, "Data Listed");
	}

}
