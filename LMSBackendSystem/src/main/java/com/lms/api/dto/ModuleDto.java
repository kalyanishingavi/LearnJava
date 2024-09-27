package com.lms.api.dto;

import java.util.List;

import com.lms.api.model.Module;
import com.lms.api.model.Video;

public class ModuleDto {

	private Module module;

//	public static class Videodto{
//		private Long id;
//		private String title;
//		private String duration;
//		public Long getId() {
//			return id;
//		}
//		public void setId(Long id) {
//			this.id = id;
//		}
//		public String getTitle() {
//			return title;
//		}
//		public void setTitle(String title) {
//			this.title = title;
//		}
//		public String getDuration() {
//			return duration;
//		}
//		public void setDuration(String duration) {
//			this.duration = duration;
//		}
//		
//	}

	private List<Video> video;

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public static class ModuleStatsDto {
		private int numOfModules;
		private int numOfVideoes;
		private String contentDuration;

		public int getNumOfModules() {
			return numOfModules;
		}

		public void setNumOfModules(int numOfModules) {
			this.numOfModules = numOfModules;
		}

		public int getNumOfVideoes() {
			return numOfVideoes;
		}

		public void setNumOfVideoes(int numOfVideoes) {
			this.numOfVideoes = numOfVideoes;
		}

		public String getContentDuration() {
			return contentDuration;
		}

		public void setContentDuration(String contentDuration) {
			this.contentDuration = contentDuration;
		}

	}

}
