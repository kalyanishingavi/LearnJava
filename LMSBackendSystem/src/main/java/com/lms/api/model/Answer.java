package com.lms.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String answerText;
	
	private int likes;
	
	@Column(nullable = false)
	private String username;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dateOfPost;
	
	
	@JsonBackReference
	@ManyToMany(mappedBy = "answer")
	private List<Question> question;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
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

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public LocalDate getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(LocalDate dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	
}
