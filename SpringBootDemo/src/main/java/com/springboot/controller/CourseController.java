package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Course;
import com.springboot.model.Instructor;
import com.springboot.repository.CourseRepository;
import com.springboot.repository.InstructorRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	InstructorRepository instructorRepository;
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		courseRepository.save(course);
	
		return course;
	}
	
	@GetMapping("/course")
	public List<Course> getAllCourse(){
		List<Course> list = courseRepository.findAll();
		return list;
	}
	
	@PutMapping("/course/instructor/{cid}/{iid}")
	public Course assignInstructorToCourse(@PathVariable("cid") Long cid,@PathVariable("iid") Long iid) {
		/*
		 * fetching Course using course id
		 */
		Course course = courseRepository.getById(cid);
		/*
		 * fetching Instructor using id
		 */
		Instructor instructor = instructorRepository.getById(iid);
		List<Instructor> list = course.getInstructor();
		list.add(instructor);
		course.setInstructor(list);
		courseRepository.save(course);
		return course;
	}
}
