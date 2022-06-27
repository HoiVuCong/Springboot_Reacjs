package com.vchoi.springboot.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorDetail {
	private String dataName;

	private String fieldName;

	private String fieldValue;

	private String message;
}
