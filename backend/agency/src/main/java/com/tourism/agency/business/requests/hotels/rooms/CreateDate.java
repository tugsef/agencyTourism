package com.tourism.agency.business.requests.hotels.rooms;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateDate {
	private int roomId;
	private Date date;
}
