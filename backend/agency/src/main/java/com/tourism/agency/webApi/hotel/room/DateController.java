package com.tourism.agency.webApi.hotel.room;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.hotels.rooms.DateService;
import com.tourism.agency.business.requests.hotels.rooms.CreateDateRequest;
import com.tourism.agency.core.utilities.result.Result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("api/rooms/date")
public class DateController {
	private DateService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result create(@RequestBody CreateDateRequest createDateRequest) {
		System.out.println(createDateRequest.getCheckInDate());
		return this.service.createDate(createDateRequest);
	}

}
