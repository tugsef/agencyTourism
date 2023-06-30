package com.tourism.agency.business.concretes.hotels.rooms;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.rooms.RoomService;
import com.tourism.agency.business.requests.hotels.rooms.RoomCreateRequests;
import com.tourism.agency.business.requests.hotels.rooms.RoomRezervationSearchRequest;
import com.tourism.agency.business.requests.hotels.rooms.RoomUpdateRequests;
import com.tourism.agency.business.responses.hotels.rooms.GetHotelIdRoomDateResponse;
import com.tourism.agency.business.responses.hotels.rooms.RoomsGetAllResponses;
import com.tourism.agency.business.rules.hotels.rooms.DateRoomBusinessRules;
import com.tourism.agency.business.rules.hotels.rooms.RoomBussinessRules;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.core.utilities.result.SuccessDataResult;
import com.tourism.agency.core.utilities.result.SuccessResult;
import com.tourism.agency.dataAccess.abstracts.hotel.room.RoomRepository;
import com.tourism.agency.entities.hotel.room.Room;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class RoomManeger implements RoomService {

	private RoomRepository repository;
	private ModelMapperService mapperService;
	private RoomBussinessRules rules;
	private DateRoomBusinessRules dateRoomBusinessRules;

	@Override
	public Result create(RoomCreateRequests createRequests) {
		
		this.rules.checkIfHotelIdExists(createRequests.getHotelId());
		
		this.rules.checkIfHotelIdAndTypeExists(createRequests.getHotelId(), createRequests.getType());

		Room room = this
				.mapperService
				.forRequest()
				.map(createRequests, Room.class);
		room.setId(-1);

		this.repository.save(room);

		return new SuccessResult("Room added");
	}

	@Override
	public DataResult<List<RoomsGetAllResponses>> getAllReponses() {
		List<Room> rooms = this
				.repository
				.findAll();

		List<RoomsGetAllResponses> getAllResponses = rooms.stream()
				.map(room -> this
						.mapperService
						.forResponse()
						.map(room, RoomsGetAllResponses.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<RoomsGetAllResponses>>(getAllResponses, "Room listed");
	}

	@Override
	public Result update(RoomUpdateRequests updateRequests) {
		
		this.rules.checkIfIdExists(updateRequests.getId());
		Room room = this
				.mapperService
				.forRequest()
				.map(updateRequests, Room.class);
		
		this.repository.save(room);
		
		return new SuccessResult("Room update");
	}

	@Override
	public Result deleteById(int id) {
		
		this.rules.checkIfIdExists(id);
		
		this.repository.deleteById(id);
		
		return new SuccessResult("Room deleted");
	}

	@Override
	public DataResult<List<GetHotelIdRoomDateResponse>> findByHotelIdRoomDate(RoomRezervationSearchRequest request, int hotelId) {
	List<Date> dates =	this.dateRoomBusinessRules.dateList(request.getCheckInDate(),request.getCheckOutDate());
	int count = request.getAdult() + request.getChild();
	System.out.println(count);
	System.out.println(dates);
	List<Room> rooms = this.repository.findByHotelIdAndInventoryGreaterThanEqualAndDateRoomsDateIn(hotelId , count ,dates);
	List<GetHotelIdRoomDateResponse> dateResponses = rooms.stream()
			.map(room -> this
					.mapperService
					.forResponse()
					.map(room, GetHotelIdRoomDateResponse.class))
			.collect(Collectors.toList());
			return new SuccessDataResult<List<GetHotelIdRoomDateResponse>>(dateResponses , "Data Date Room Listed");
	}

}
