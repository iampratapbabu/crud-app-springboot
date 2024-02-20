package com.crudapplication.dtos;

public class CommonResponse {
	private int statusCode;
	private boolean success;
	private String message;
	private Object resData;
	
	public CommonResponse(int statusCode, boolean success, String message, Object resData) {
		super();
		this.statusCode = statusCode;
		this.success = success;
		this.message = message;
		this.resData = resData;
	}
	
	

}
