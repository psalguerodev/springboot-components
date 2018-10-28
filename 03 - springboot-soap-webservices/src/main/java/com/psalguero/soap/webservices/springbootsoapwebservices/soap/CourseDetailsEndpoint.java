package com.psalguero.soap.webservices.springbootsoapwebservices.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.patricksalguero.courses.CourseDetails;
import com.patricksalguero.courses.GetCourseDetailsRequest;
import com.patricksalguero.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {
	// request .-> GetCourseDetailsRequest
	// response .-> GetCourseDetailsResponse
	private static Logger LOG = LoggerFactory.getLogger(CourseDetailsEndpoint.class);
	// http://patricksalguero.com/courses
	// GetCourseDetailsRequest
	@PayloadRoot(namespace="http://patricksalguero.com/courses", localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest
		(@RequestPayload GetCourseDetailsRequest courseDetails){
		LOG.info("[COURSE] BEGIN REQUEST");
		LOG.info("[COURSE] REQUEST {}", courseDetails.toString());
		CourseDetails details = new CourseDetails();
		details.setDescription("Spring Boot Learn");
		details.setId(courseDetails.getId());
		details.setName("Spring Boot Web Services");
		LOG.info("ID COURSE {}", courseDetails.getId());
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(details);
		LOG.info("[COURSE] END REQUEST");
		return response;
	}
}
