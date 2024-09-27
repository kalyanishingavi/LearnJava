package com.lms.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.LearningTrackDto;
import com.lms.api.model.Course;
import com.lms.api.model.LearningTrack;
import com.lms.api.repository.CourseRepository;
import com.lms.api.repository.LearningTrackRepository;

@RestController
public class LearningTrackController {

	@Autowired
	private LearningTrackRepository learningTrackRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@PostMapping("/learning-track/post")
	public LearningTrack createLearningTrack(@RequestBody LearningTrack track) {
		return learningTrackRepository.save(track);
		
	}
	
	@GetMapping("/learning-track/all")
	public List<LearningTrackDto> showLearningTrack() {
		//fetch all learning track
		List<LearningTrack> list = learningTrackRepository.findAll();
		List<LearningTrackDto> listDto = new ArrayList<>();
		/*(
		 * for each learning track fetch course
		 */
		
		list.stream().forEach(lt->{
			LearningTrackDto dto = new LearningTrackDto();
			List<Course> listCourse = courseRepository.findByLearningTrackId(lt.getId());
			dto.setId(lt.getId());
			dto.setName(lt.getName());
			dto.setListCourse(listCourse);
			listDto.add(dto);
		});
		return listDto;
	}
}
