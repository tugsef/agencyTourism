package com.tourism.agency.business.rules.hotels.rooms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.requests.hotels.rooms.CreateDate;
import com.tourism.agency.business.requests.hotels.rooms.CreateDateRequest;

@Service
public class DateRoomBusinessRules {

	public List<CreateDate> dateList(CreateDateRequest createDateRequest){
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
		    
		    
		    return dates;
	}
	public List<Date> dateList(String inDate , String outDate){
		List<Date> dates = new ArrayList<Date>();
		
		 DateFormat formatter;
		 formatter = new SimpleDateFormat("dd/MM/yyyy");
		 Date startDate = null;
		 
		 try 
		    {
		      startDate = (Date) formatter.parse(inDate);
		    } catch (ParseException e) 
		    {
		      e.printStackTrace();
		    }
		 Date endDate = null;
		    try 
		    {
		      endDate = (Date) formatter.parse(outDate);
		    } catch (ParseException e) 
		    {
		      e.printStackTrace();
		    }
		    long interval = 24 * 1000 * 60 * 60;
		    long endTime = endDate.getTime();
		    long curTime = startDate.getTime();
		    
		    while (curTime <= endTime) 
		    {
		    	
		    	dates.add(endDate);
		    	
		      curTime += interval;
		    }
		    
		    
		    return dates;
	}
}
