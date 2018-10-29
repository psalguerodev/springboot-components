package com.psalguero.rest.webservices.springbootrestwebservices.exceptions;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String detail;

	public ExceptionResponse() {

	}

	public ExceptionResponse(Date timestamp, String message, String detail) {
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return String.format("ExceptionResponse [timestamp=%s, message=%s, detail=%s]", timestamp, message, detail);
	}

}
