package com.tourism.agency.business.concretes.hotels.rooms;

import java.io.File;

import org.springframework.stereotype.Service;

import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.tourism.agency.business.abstracts.hotels.rooms.RoomImagesService;
import com.tourism.agency.business.requests.hotels.rooms.RoomImagesRequests;
import com.tourism.agency.core.utilities.cloudinary.CloudinaryService;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.dataAccess.abstracts.hotel.room.RoomImagesRepository;
import com.tourism.agency.entities.hotel.room.RoomImages;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Service
@AllArgsConstructor
public class RoomImageManager implements RoomImagesService {
	
	private CloudinaryService cloudinaryService;
	private ModelMapperService modelMapperService;
	private RoomImagesRepository roomImagesRepository;
	
	@Override
	public void createImg(RoomImagesRequests requests) {

		RoomImages roomImages = this.modelMapperService.forRequest().map(requests, RoomImages.class);
		this.roomImagesRepository.save(roomImages);

		try {
			this.cloudinaryService.getCloudinary().uploader().upload(new File(roomImages.getUrl()),
					ObjectUtils.asMap("public_id", "add"));
		} catch (Exception e) {
			System.out.println(e);
		}
		String urltest = this.cloudinaryService.getCloudinary().url()
				.transformation(new Transformation().width(100).height(150).crop("fill")).generate("olympic_flag10");
		System.out.println(urltest);
	}
		
		
	}

