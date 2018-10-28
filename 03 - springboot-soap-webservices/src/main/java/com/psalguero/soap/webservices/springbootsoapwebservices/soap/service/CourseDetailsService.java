package com.psalguero.soap.webservices.springbootsoapwebservices.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.psalguero.soap.webservices.springbootsoapwebservices.soap.bean.Course;

@Component
public class CourseDetailsService {

	private static List<Course> courses = new ArrayList<Course>();

	public enum Status {
		SUCCESS, FAILURE
	}
	
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

	public Status deleteById(int id) {
		Status course = Status.FAILURE;

		Iterator<Course> iterator = courses.iterator();

		while (iterator.hasNext()) {
			Course c = iterator.next();

			if (c.getId() == id) {
				iterator.remove();
				course = Status.SUCCESS;
			}
		}

		return course;
	}
}
