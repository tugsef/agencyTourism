package com.tourism.agency.core.utilities.cloudinary;

import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class CloudinaryManager implements CloudinaryService {
	
	 private Cloudinary cloudinary;
	 

	@Override
	public Cloudinary getCloudinary() {
		this.cloudinary.config.cloudName = Config.cloud_name;
		this.cloudinary.config.apiKey = Config.api_key;
		this.cloudinary.config.apiSecret=Config.api_secret;
		
		return this.cloudinary ;
	}


	





}
