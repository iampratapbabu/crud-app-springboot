package com.crudapplication.myresponse;

public class MyResponse {
	public int statusCode;
	public String message;
	public Object resData;
	
	public MyResponse(int statusCode,String message,Object resData) {
		this.statusCode = statusCode;
		this.message = message;
		this.resData = resData;
	}
	

}
