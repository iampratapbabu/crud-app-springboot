package com.crudapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResponse {
	private int statusCode;
	private boolean success;
	private String message;
	private Object resData;
		
}
