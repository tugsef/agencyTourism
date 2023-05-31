package com.tourism.agency.business.concretes.hotels.rooms;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.hotels.rooms.FeatureService;
import com.tourism.agency.business.requests.hotels.rooms.CreateFeaturesRequest;
import com.tourism.agency.business.requests.hotels.rooms.UpdateFeatureRequest;
import com.tourism.agency.business.responses.hotels.rooms.FindAllByPropertyResponse;
import com.tourism.agency.business.rules.hotels.rooms.FeatureBussinessRules;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.core.utilities.result.SuccessDataResult;
import com.tourism.agency.core.utilities.result.SuccessResult;
import com.tourism.agency.dataAccess.abstracts.hotel.room.FeaturesRepository;
import com.tourism.agency.entities.hotel.room.Feature;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class FeatureManager implements FeatureService {

	private FeaturesRepository repository;
	private ModelMapperService mapperService;
	private FeatureBussinessRules rules;

	@Override
	public Result create(CreateFeaturesRequest featuresRequest) {
		this.rules.checkIfRoomIdAndPropertyExists(featuresRequest.getRoomId(), featuresRequest.getProperty());
		Feature feature = this.mapperService.forRequest().map(featuresRequest , Feature.class);
		feature.setId(-1);
		this.repository.save(feature);
		
		return new SuccessResult("Data added");
	}

	@Override
	public Result update(UpdateFeatureRequest featureRequest) {
		this.rules.checkIfIdAndRoomId(featureRequest.getId(), featureRequest.getRoomId());
		Feature feature = this.mapperService.forRequest().map(featureRequest, Feature.class);
		this.repository.save(feature);
		return new SuccessResult("Room feature update");
	}

	@Override
	public Result delete(int id) {
		this.rules.checkIfIdexists(id);
		this.repository.deleteById(id);
		return new SuccessResult("Room feature deleted");
	}

	@Override
	public DataResult<List<FindAllByPropertyResponse>> findByProperty(String property) {
		List<Feature> features = this.repository.findByPropertyAndActive(property , true);
		List<FindAllByPropertyResponse> responses = features.stream().map(feature -> 
									this.mapperService.forResponse().map(feature, FindAllByPropertyResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<FindAllByPropertyResponse>>(responses , "Listed " + property);
	}

}
