package com.tourism.agency.business.concretes.hotels;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.HotelFeatureService;
import com.tourism.agency.business.requests.hotels.HotelFeatureCreateRequest;
import com.tourism.agency.business.responses.hotels.HotelFeaturesByPropertyAndActiveResposes;
import com.tourism.agency.business.rules.hotels.HotelFeatureBusinessRules;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.core.utilities.result.SuccessDataResult;
import com.tourism.agency.core.utilities.result.SuccessResult;
import com.tourism.agency.dataAccess.abstracts.hotel.HotelFeaturesRepository;
import com.tourism.agency.entities.hotel.HotelFeature;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class HotelFeatureManager implements HotelFeatureService{

	private HotelFeaturesRepository repository;
	private ModelMapperService mapperService;
	private HotelFeatureBusinessRules rules;
	
	@Override
	public Result create(HotelFeatureCreateRequest createRequest) {
		this.rules.existsByPropertyAndHotelId(createRequest.getProperty(), createRequest.getHotelId());
		
		HotelFeature feature =this
				.mapperService
				.forRequest()
				.map(createRequest , HotelFeature.class);	
		
		feature.setId(-1);
		
		this.repository.save(feature) ;
		return new SuccessResult("Özellik Kayıt Edildi.");
	}

	@Override
	public DataResult<List<HotelFeaturesByPropertyAndActiveResposes>> findAllPropertyAndActive(String property) {
		
		List<HotelFeature> features = this
				.repository
				.getByPropertyAndActive(property, true);
		
		List<HotelFeaturesByPropertyAndActiveResposes> resposes = features.stream()
				.map(feature -> this
						.mapperService.forResponse()
						.map(feature, HotelFeaturesByPropertyAndActiveResposes.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<HotelFeaturesByPropertyAndActiveResposes>>(resposes , "Data Listelendi");
	}


	
}
