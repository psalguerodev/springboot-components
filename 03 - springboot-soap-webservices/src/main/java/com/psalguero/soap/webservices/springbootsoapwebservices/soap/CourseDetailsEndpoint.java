package com.psalguero.soap.webservices.springbootsoapwebservices.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.patricksalguero.courses.CourseDetails;
import com.patricksalguero.courses.GetCourseDetailsRequest;
import com.patricksalguero.courses.GetCourseDetailsResponse;
import com.psalguero.soap.webservices.springbootsoapwebservices.soap.bean.Course;
import com.psalguero.soap.webservices.springbootsoapwebservices.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	private CourseDetailsService service;

	// request .-> GetCourseDetailsRequest
	// response .-> GetCourseDetailsResponse
	private static Logger LOG = LoggerFactory.getLogger(CourseDetailsEndpoint.class);

	// http://patricksalguero.com/courses
	// GetCourseDetailsRequest
	@PayloadRoot(namespace = "http://patricksalguero.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest courseDetails) {
		LOG.info("[COURSE] BEGIN REQUEST");
		Course course = service.findById(courseDetails.getId());
		
		LOG.info("[COURSE] ID COURSE {}", courseDetails.getId());
		LOG.info("[COURSE] FIND COURSE {}", course.toString());
		LOG.info("[COURSE] END REQUEST");
		return mapCourse(courseDetails, course);
	}

	private GetCourseDetailsResponse mapCourse(GetCourseDetailsRequest courseDetails, Course course) {
		CourseDetails details = new CourseDetails();
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		details.setDescription(course.getDescription());
		details.setId(courseDetails.getId());
		details.setName(course.getName());
		response.setCourseDetails(details);
		return response;
	}
}
