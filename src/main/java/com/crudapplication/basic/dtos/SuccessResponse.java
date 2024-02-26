package com.crudapplication.basic.dtos;



public class SuccessResponse {
	private String status;
	private String message;
	private Integer statusCode;
	private Object data;
	
	@Override
	public String toString() {
		return "SuccessResponse [status=" + status + ", message=" + message + ", statusCode=" + statusCode + ", data="
				+ data + "]";
	}

	public SuccessResponse(String status, String message, Integer statusCode, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}
	
	
}
