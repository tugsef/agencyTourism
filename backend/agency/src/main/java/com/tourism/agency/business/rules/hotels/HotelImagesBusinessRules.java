package com.tourism.agency.business.rules.hotels;

import java.io.File;

import org.springframework.stereotype.Service;

import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.tourism.agency.core.utilities.cloudinary.CloudinaryService;
import com.tourism.agency.core.utilities.exception.BusinessExeption;
import com.tourism.agency.dataAccess.abstracts.hotel.room.HotelImageRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class HotelImagesBusinessRules {
	
	private HotelImageRepository repository;
	private CloudinaryService cloudinaryService;
	
	public void  checkfExistsByUrl(String url) {
		
		if(this.repository.existsByUrl(url))
			throw new BusinessExeption("Previously registered under the same name");
		
		try {
			this.cloudinaryService
								.getCloudinary()
								.uploader()
								.upload(new File(url),
					ObjectUtils.asMap("public_id", "add"));
		} catch (Exception e) {
			System.out.println(e);
		}
		String urltest = this.cloudinaryService.getCloudinary().url()
				.transformation(new Transformation()
													.width(100)
													.height(150)
													.crop("fill"))
				.generate("olympic_flag10");
		System.out.println(urltest);
	}
	} 
	

