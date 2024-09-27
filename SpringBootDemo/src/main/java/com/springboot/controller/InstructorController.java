package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.StatsDto;
import com.springboot.model.Course;
import com.springboot.model.Instructor;
import com.springboot.repository.CourseRepository;
import com.springboot.repository.InstructorRepository;

@RestController
public class InstructorController {
	
	@Autowired
	InstructorRepository instructorRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/instructor")
	public Instructor addInstructor(@RequestBody Instructor instructor) {
		instructorRepository.save(instructor);
		return instructor;
	}
	
	@GetMapping("/instructor")
	public List<Instructor> getAllInstructor() {
		List<Instructor> list = instructorRepository.findAll();
		return list;
	}
	
	@PostMapping("/instructor/course/{iid}/{cid}")
	public Instructor AssignProjectToInstructor(@PathVariable("iid") Long iid, @PathVariable("cid") Long cid) {
		/*
		 * Getting instructor by using Instructor id
		 */
		Instructor instructor = instructorRepository.getById(iid);
		/*
		 * Getting course details by course Id
		 */
		Course course = courseRepository.getById(cid);
		/*
		 * fetch list of Course and adding the course in it
		 */
		List<Course> list = instructor.getCourse();
		list.add(course);
		instructor.setCourse(list);
		instructorRepository.save(instructor);
		return instructor;
	}
	
	@GetMapping("/instructor/course/{cid}")
	public List<Instructor> getInstructorByCourseId(@PathVariable Long cid){
		List<Instructor> list = instructorRepository.getInstructorByCourseId(cid);
		return list;
	}
	
	@GetMapping("/instructor/maxsalary")
	public StatsDto getMaxInstructorSalary() {
		
		List<Double[]> list = instructorRepository.getMaxSalary();
		Double[] stats = list.get(0);
		
		double max = stats[0];
		double min = stats[1];
		double count = stats[2];
		
		StatsDto dto = new StatsDto();
		dto.setCount(count);
		dto.setMaxSalary(max);
		dto.setMinSalary(min);
		
		return dto;
		
	}
	
	
	
 }
