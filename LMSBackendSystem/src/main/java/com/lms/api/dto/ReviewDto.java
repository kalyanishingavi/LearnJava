package com.lms.api.dto;

import com.lms.api.model.LearningTrack;

public class ReviewDto {

	private Long id;
	private String content;
	private double rating;
	private Long userId;
	private String username;
	private String name;
	private String email;
	private Long courseId;
	private String courseName;
	private Long learningTrackId;
	private LearningTrack learningTrack;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Long getLearningTrackId() {
		return learningTrackId;
	}
	public void setLearningTrackId(Long learningTrackId) {
		this.learningTrackId = learningTrackId;
	}
	public LearningTrack getLearningTrack() {
		return learningTrack;
	}
	public void setLearningTrack(LearningTrack learningTrack) {
		this.learningTrack = learningTrack;
	}
	@Override
	public String toString() {
		return "ReviewDto [id=" + id + ", content=" + content + ", rating=" + rating + ", userId=" + userId
				+ ", username=" + username + ", name=" + name + ", email=" + email + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", learningTrackId=" + learningTrackId + ", learningTrack="
				+ learningTrack + "]";
	}

	
}
