package com.tourism.agency;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudinary.Cloudinary;
import com.tourism.agency.core.utilities.exception.BusinessExeption;
import com.tourism.agency.core.utilities.exception.DataIntegrityViolationProblemException;
import com.tourism.agency.core.utilities.exception.HttpMessageNotReadableProblemException;
import com.tourism.agency.core.utilities.exception.JpaObjectRetrievalFailureProblemException;
import com.tourism.agency.core.utilities.exception.JpaSystemProblemException;
import com.tourism.agency.core.utilities.exception.ProblemDetails;
import com.tourism.agency.core.utilities.exception.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class AgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgencyApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBussinessException(BusinessExeption businessExeption) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessExeption.getMessage());
		problemDetails.setSuccess(false);
		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValitadionException(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation.Exception");
		validationProblemDetails.setSuccess(false);
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return validationProblemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
	public DataIntegrityViolationProblemException handleDataIntegrity(
			DataIntegrityViolationException dataIntegrityViolationException) {
		DataIntegrityViolationProblemException problemException = new DataIntegrityViolationProblemException();
		problemException.setMessage(dataIntegrityViolationException.getMessage());
		problemException.setSuccess(false);
		return problemException;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public HttpMessageNotReadableProblemException handleHttpMessageNotReadableException(
			HttpMessageNotReadableException exception) {
		HttpMessageNotReadableProblemException problemException = new HttpMessageNotReadableProblemException();
		problemException.setSuccess(false);
		problemException.setMessage("HttpMessageNotReadableException:" + exception.getMessage());

		return problemException;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public JpaSystemProblemException handleJpaSystemExeption(JpaSystemException exception) {
		JpaSystemProblemException problemException = new JpaSystemProblemException();
		problemException.setSuccess(false);
		problemException.setMessage("JpaSystemException" + exception.getMessage());
		return problemException;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public JpaObjectRetrievalFailureProblemException handleJpaObjectRetrievalFailureException(JpaObjectRetrievalFailureException exception) {
		JpaObjectRetrievalFailureProblemException problemException = new JpaObjectRetrievalFailureProblemException();
		problemException.setSuccess(false);
		problemException.setMessage("JpaObjectRetrievalFailureException" + exception.getMessage());
		return problemException;
	}

	@Bean
	public Cloudinary getCloudinary() {
		return new Cloudinary();
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	


}
