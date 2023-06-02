package com.tourism.agency.webApi.rezervation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.agency.business.abstracts.rezervations.RezervationService;
import com.tourism.agency.business.requests.hotels.CreateRezervationRequest;
import com.tourism.agency.core.utilities.result.DataResult;
import com.tourism.agency.core.utilities.result.Result;
import com.tourism.agency.entities.rezervation.Rezervation;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/rezervation")
public class RezervationControllers {

	private RezervationService service;
	
	@GetMapping("/getAll")
	public DataResult<List<Rezervation>> getAll(){
		return this.service.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result create(@RequestBody CreateRezervationRequest request) {
		return this.service.create(request);
	}
}
