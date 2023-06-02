package com.tourism.agency.business.concretes.rezervations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourism.agency.business.abstracts.rezervations.RezervationService;
import com.tourism.agency.business.requests.hotels.CreateRezervationRequest;
import com.tourism.agency.core.utilities.mapper.ModelMapperService;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.core.utilities.result.SuccessDataResult;
import com.tourism.agency.core.utilities.result.SuccessResult;
import com.tourism.agency.dataAccess.abstracts.rezervation.RezervationRepository;
import com.tourism.agency.entities.rezervation.Rezervation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class RezervationManager implements RezervationService {

	private RezervationRepository repository;
	private ModelMapperService mapperService;
	
	
	@Override
	public DataResult<List<Rezervation>> getAll() {
		List<Rezervation> rezervations = this.repository.findAll();
		return new SuccessDataResult<List<Rezervation>>(rezervations , "Data listed");
	}


	@Override
	public Result create(CreateRezervationRequest request) {
		Rezervation rezervation = this.mapperService.forRequest().map(request , Rezervation.class);
		rezervation.setId(-1);
		
		
	
	
		
		this.repository.save(rezervation);
		return new SuccessResult("Data Created");
	}

}
