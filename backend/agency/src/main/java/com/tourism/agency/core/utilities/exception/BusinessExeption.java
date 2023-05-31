package com.tourism.agency.core.utilities.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BusinessExeption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessExeption(String message) {
		super(message);
	}
}
