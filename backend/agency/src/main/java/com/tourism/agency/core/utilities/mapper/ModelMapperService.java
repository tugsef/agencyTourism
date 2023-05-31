package com.tourism.agency.core.utilities.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public interface ModelMapperService {
	ModelMapper forResponse();
	ModelMapper forRequest();
}
