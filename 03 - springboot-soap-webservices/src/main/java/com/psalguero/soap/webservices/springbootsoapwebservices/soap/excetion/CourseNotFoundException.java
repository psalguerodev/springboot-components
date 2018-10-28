package com.psalguero.soap.webservices.springbootsoapwebservices.soap.excetion;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode= FaultCode.CUSTOM, customFaultCode="{http://patrick.salguero.com/course}001_COURSE_NOT_FOUND")
public class CourseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 0L;

	public CourseNotFoundException(String message) {
		super(message);
	}
	
	
}
