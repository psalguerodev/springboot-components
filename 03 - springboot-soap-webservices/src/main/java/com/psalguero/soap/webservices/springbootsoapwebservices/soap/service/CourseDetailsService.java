package com.psalguero.soap.webservices.springbootsoapwebservices.soap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.psalguero.soap.webservices.springbootsoapwebservices.soap.bean.Course;

@Component
public class CourseDetailsService {

	private static List<Course> courses = new ArrayList<Course>();

	static {
		Course course1 = new Course(1, "Angular 7+", "Basic");
		courses.add(course1);

		Course course2 = new Course(2, "Node JS", "Basic - Intermediate");
		courses.add(course2);

		Course course3 = new Course(3, "Spring Boot Web Services SOAP", "Basic development services");
		courses.add(course3);

		Course course4 = new Course(4, "Spring Boot Web Services REST", "Basic developer rest services");
		courses.add(course4);
	}

	public Course findById(int id) {
		return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
	}

	public List<Course> findAll() {
		return courses;
	}

	public int deleteById(int id) {
		int course = 0;
		for (Course c : courses) {
			if (c.getId() == id) {
				courses.remove(c);
				course = 1;
			}
		}
		return course;
	}
}
