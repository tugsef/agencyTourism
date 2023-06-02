package com.tourism.agency.business.concretes.hotels.rooms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.rooms.DateService;
import com.tourism.agency.business.requests.hotels.rooms.CreateDate;
import com.tourism.agency.business.requests.hotels.rooms.CreateDateRequest;
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

	
	@Override
	public Result createDate(CreateDateRequest createDateRequest) {
		
		List<CreateDate> dates = new ArrayList<CreateDate>();
		
		 DateFormat formatter;
		 formatter = new SimpleDateFormat("dd/MM/yyyy");
		 Date startDate = null;
		 
		 try 
		    {
		      startDate = (Date) formatter.parse(createDateRequest.getCheckInDate());
		    } catch (ParseException e) 
		    {
		      e.printStackTrace();
		    }
		 Date endDate = null;
		    try 
		    {
		      endDate = (Date) formatter.parse(createDateRequest.getCheckOutDate());
		    } catch (ParseException e) 
		    {
		      e.printStackTrace();
		    }
		    long interval = 24 * 1000 * 60 * 60;
		    long endTime = endDate.getTime();
		    long curTime = startDate.getTime();
		    CreateDate createDate = null;
		    while (curTime <= endTime) 
		    {
		    	createDate = new CreateDate();
		    	createDate.setDate(new Date(curTime));
		    	createDate.setRoomId(createDateRequest.getRoomId());
		    	dates.add(createDate);
		      curTime += interval;
		    }
		    
		List<DateRoom> dateRooms =   dates.stream().map(date -> this.mapperService.forRequest().map(date, DateRoom.class)).collect(Collectors.toList());
		this.repository.saveAll(dateRooms);
		return new SuccessResult("Başarılı");
	}

	
}
