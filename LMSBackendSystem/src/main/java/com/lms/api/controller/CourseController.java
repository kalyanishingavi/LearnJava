package com.lms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.model.Author;
import com.lms.api.model.Course;
import com.lms.api.model.LearningTrack;
import com.lms.api.repository.AuthorRepository;
import com.lms.api.repository.CourseRepository;
import com.lms.api.repository.LearningTrackRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private LearningTrackRepository learningTrackRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping("/course/add/{lid}")
	public Course addCourse(@RequestBody Course course,@PathVariable Long lid) {
		LearningTrack track = learningTrackRepository.getById(lid);
		course.setLearningTrack(track);
		return courseRepository.save(course);
	
	}
	
	/*
	 * Assign author to course
	 */
	
	@PostMapping("/course/author/{cid}/{aid}")
	public Course addAuthorToCourse(@PathVariable Long cid,@PathVariable Long aid) {
		Course course = courseRepository.getById(cid);
		Author author = authorRepository.getById(aid);
		List<Author> list = course.getAuthor();
		list.add(author);
		course.setAuthor(list);
		courseRepository.save(course);
		return course;
	}
	
	/*
	 * unassign author to course
	 */
	@PostMapping("/course/author/remove/{cid}/{aid}")
	public Course removeAuthorToCourse(@PathVariable Long cid,@PathVariable Long aid) {
		Course course = courseRepository.getById(cid);
		Author author = authorRepository.getById(aid);
		List<Author> list = course.getAuthor();
		list.remove(author);
		course.setAuthor(list);
		courseRepository.save(course);
		return course;
	}
}
