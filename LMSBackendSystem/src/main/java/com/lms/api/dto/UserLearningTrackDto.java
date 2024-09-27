package com.lms.api.dto;

import java.util.List;

import com.lms.api.model.LearningTrack;
import com.lms.api.model.User;

public class UserLearningTrackDto {

	private User user;
	
	private List<LearningTrack> list;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LearningTrack> getList() {
		return list;
	}

	public void setList(List<LearningTrack> list) {
		this.list = list;
	}
}
