package com.lms.api.dto;

public class ForumDto {

	private Long id;

	private String Topic;

	private int noOfQuestions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic = topic;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public static class forumStatsdto {
		private int totalNumberOfTopics;
		private int totalNumberOfQuestions;
		private int totalNumberOfAnswers;
		private int totalNumberOfUsers;

		public int getTotalNumberOfTopics() {
			return totalNumberOfTopics;
		}

		public void setTotalNumberOfTopics(int totalNumberOfTopics) {
			this.totalNumberOfTopics = totalNumberOfTopics;
		}

		public int getTotalNumberOfQuestions() {
			return totalNumberOfQuestions;
		}

		public void setTotalNumberOfQuestions(int totalNumberOfQuestions) {
			this.totalNumberOfQuestions = totalNumberOfQuestions;
		}

		public int getTotalNumberOfAnswers() {
			return totalNumberOfAnswers;
		}

		public void setTotalNumberOfAnswers(int totalNumberOfAnswers) {
			this.totalNumberOfAnswers = totalNumberOfAnswers;
		}

		public int getTotalNumberOfUsers() {
			return totalNumberOfUsers;
		}

		public void setTotalNumberOfUsers(int totalNumberOfUsers) {
			this.totalNumberOfUsers = totalNumberOfUsers;
		}

	}
}
