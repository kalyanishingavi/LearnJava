package com.lms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.model.Video;
import com.lms.api.model.Module;
import com.lms.api.repository.ModuleRepository;
import com.lms.api.repository.VideoRepository;

@RestController
public class VideoController {

	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private VideoRepository videoRepository;
	
	/*
	 * Video post API
	 */
	@PostMapping("/video/{mid}")
	public Video postVideo(@RequestBody Video video,@PathVariable("mid") Long mid) {
		Module module = moduleRepository.getById(mid);
		video.setModule(module);
		return videoRepository.save(video);
	}
	
	
}
