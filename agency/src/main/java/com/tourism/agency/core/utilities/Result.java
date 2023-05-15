package com.tourism.agency.core.utilities;

public class Result {
	
	private boolean success;
	private String message;
	
	public Result(boolean success ) {
		this.success = success;
	}
	
	public Result(boolean success , String message) {
		this(success);
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String geMessage() {
		return this.message;
	}
}
