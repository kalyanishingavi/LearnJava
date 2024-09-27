package com.lms.api.dto;

import java.util.List;

import com.lms.api.model.Course;

public class LearningTrackDto {

	private Long id;
	
	private String name;
	
	private List<Course> listCourse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}
	
}
