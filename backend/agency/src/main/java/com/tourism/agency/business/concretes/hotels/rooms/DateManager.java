package com.tourism.agency.business.concretes.hotels.rooms;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.rooms.DateService;
import com.tourism.agency.business.requests.hotels.rooms.CreateDateRequest;
import com.tourism.agency.business.rules.hotels.rooms.DateRoomBusinessRules;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.core.utilities.result.SuccessResult;
import com.tourism.agency.dataAccess.abstracts.hotel.room.DateRoomRepository;
import com.tourism.agency.entities.hotel.room.DateRoom;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class DateManager implements DateService {

	private DateRoomRepository repository;
	private ModelMapperService mapperService;
	private DateRoomBusinessRules businessRules;

	@Override
	public Result createDate(CreateDateRequest createDateRequest) {

		List<DateRoom> dateRooms = this.businessRules.dateList(createDateRequest).stream()
				.map(date -> this.mapperService.forRequest().map(date, DateRoom.class)).collect(Collectors.toList());
		for (DateRoom dateRoom : dateRooms) {
			dateRoom.setId(0);
			this.repository.save(dateRoom);
		}

		return new SuccessResult("Başarılı");
	}

}
