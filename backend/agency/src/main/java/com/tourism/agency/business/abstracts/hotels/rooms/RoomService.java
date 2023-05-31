package com.tourism.agency.business.abstracts.hotels.rooms;

import java.util.List;

import com.tourism.agency.business.requests.hotels.rooms.RoomCreateRequests;
import com.tourism.agency.business.requests.hotels.rooms.RoomUpdateRequests;
import com.tourism.agency.business.responses.hotels.rooms.RoomsGetAllResponses;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;

public interface RoomService {

	Result create(RoomCreateRequests createRequests);
	
	DataResult<List<RoomsGetAllResponses>> getAllReponses();
	
	Result update(RoomUpdateRequests updateRequests);
	
	Result deleteById(int id);
}
