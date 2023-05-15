package com.tourism.agency.core.utilities;

public class ErrorResult extends Result{

	public ErrorResult() {
		super(false);
	}
	
	public ErrorResult(String message) {
		super(false,message);
	}
}
