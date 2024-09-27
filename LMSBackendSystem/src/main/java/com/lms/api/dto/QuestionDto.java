package com.lms.api.dto;

import java.time.LocalDate;
import java.util.List;

public class QuestionDto {

	public static class modelDto{
		private Long questionID;
		private String QuestionText;
		private int likes;
		private String username;
		private LocalDate dateOfPost;
		private int NumberofAnswers;
		public Long getQuestionID() {
			return questionID;
		}
		public void setQuestionID(Long questionID) {
			this.questionID = questionID;
		}
		public String getQuestionText() {
			return QuestionText;
		}
		public void setQuestionText(String questionText) {
			QuestionText = questionText;
		}
		public int getLikes() {
			return likes;
		}
		public void setLikes(int likes) {
			this.likes = likes;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public int getNumberofAnswers() {
			return NumberofAnswers;
		}
		public void setNumberofAnswers(int numberofAnswers) {
			NumberofAnswers = numberofAnswers;
		}
		public LocalDate getDateOfPost() {
			return dateOfPost;
		}
		public void setDateOfPost(LocalDate dateOfPost) {
			this.dateOfPost = dateOfPost;
		}
		
	}
	private Long forumID;
	private String Topic;
	private List<modelDto> Questions;
	public Long getForumID() {
		return forumID;
	}
	public void setForumID(Long forumID) {
		this.forumID = forumID;
	}
	public String getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic = topic;
	}
	public List<modelDto> getQuestions() {
		return Questions;
	}
	public void setQuestions(List<modelDto> questions) {
		Questions = questions;
	}
	
	
	
}
