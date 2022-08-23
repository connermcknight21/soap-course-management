package com.in28minutes.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;

@Component
public class CourseDetailsService {

	public enum Status{
		SUCCESS, FAILURE;
	}
	
	private static List<Course> courses = new ArrayList<>();
	{
		Course course1 = new Course(1, "Spring", "10 Steps");
		courses.add(course1);
		
		Course course2 = new Course(2, "Spring MVC", "10Examples");
		courses.add(course2);
		
		Course course3 = new Course(3, "Spring Boot", "6k students");
		courses.add(course3);
		
		Course course4 = new Course(4, "Maven", "Most popular maven course on internet");
		courses.add(course4);
	}
	
	//course - 1 ( get one course)
	public Course findById(int id) {
		for (Course course : courses) {
			
			if(course.getId()==id)
				return course;
		}
		return null;
	}
	
	//courses
	public List<Course> findAll(){
		return courses;
	}
	
	//deleteCourse
	public Status deleteById(int id) {
		Iterator<Course> iter = courses.iterator();
		Course course;
		while(iter.hasNext()) {
			course = iter.next();
			
			if(course.getId()==id) {
				iter.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
	
	//update course & new course
	
}
