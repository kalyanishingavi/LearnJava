package com.lms.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.ModuleDto;
import com.lms.api.dto.ModuleDto.ModuleStatsDto;
import com.lms.api.model.Course;
import com.lms.api.model.Module;
import com.lms.api.model.Video;
import com.lms.api.repository.CourseRepository;
import com.lms.api.repository.ModuleRepository;
import com.lms.api.repository.VideoRepository;

@RestController
public class ModuleController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private VideoRepository videoRepository;

	
	/*
	 * module post API 
	 */
	
	@PostMapping("/module/{cid}")
	public Module postModule(@RequestBody Module module,@PathVariable("cid") Long cid) {
		Course course = courseRepository.getById(cid);
		module.setCourse(course);
		return moduleRepository.save(module);
	}
	/*
	 * Get all Modules by CourseId 
	 * Along with module, give video info as well
	 * 
	 * [ {
	 *    id:
	 *    name: ,
	 *    sequence: , 
	 *    videos:[
	 *       {
	 *          id:
	 *          title:
	 *          duration: 
	 *       },
	 *       {
	 *    	 
	 *       } 
	 *    ]
	 * 
	 * }, 
	 * {
	 *    id:
	 *    name: ,
	 *    sequence: , 
	 *    videos:[
	 *       {
	 *          id:
	 *          title:
	 *          duration: 
	 *       },
	 *       {
	 *    	 
	 *       } 
	 *    ]
	 * 
	 * }
	 * ]
	 */

	@GetMapping("/module/by-course/{cid}")
	public List<ModuleDto> getModuleByCourseId(@PathVariable("cid") Long cid) {
		/*
		 * fetch all modules for the course
		 */
		List<Module> listOfModule = moduleRepository.findByCourseId(cid);
		List<ModuleDto> list = new ArrayList<>();
		for(Module m : listOfModule) {
			ModuleDto dto = new ModuleDto();
			dto.setModule(m);
			/*
			 * fetch videos as per the module ID
			 */
			List<Video> listOfVideo = videoRepository.findByModuleId(m.getId());
//			List<ModuleDto.Videodto> listOfVideoDto = new ArrayList<>();
//			for(Video v : listOfVideo) {
//				ModuleDto.Videodto dt= new ModuleDto.Videodto();
//				dt.setId(v.getId());
//				dt.setTitle(v.getTitle());
//				dt.setDuration(v.getDuration());
//				listOfVideoDto.add(dt);
//			}
			dto.setVideo(listOfVideo);
			list.add(dto);
		}
		return list;
	}

	@GetMapping("/module/alternate/{cid}")
	public List<ModuleDto> getModulesByCourseId(@PathVariable("cid") Long cid) {
		/*
		 * fetch all modules from db
		 */
		List<Module> listOfModule = moduleRepository.findByCourseId(cid);
		/*
		 * fetch all videoes by course Id from DB
		 */
		List<Video> listOfVideo = videoRepository.findByCourseId(cid);
		
		List<ModuleDto> list = new ArrayList<>();
		listOfModule.parallelStream().forEach(m->{
			ModuleDto dto = new ModuleDto();
			/*
			 * filter list as per module for video by moduleID
			 */
			List<Video> listOfVideoFilter = listOfVideo.parallelStream()
					.filter(v-> v.getModule().getId().equals(m.getId())
							).collect(Collectors.toList());
			
			dto.setModule(m);
			dto.setVideo(listOfVideoFilter);
			list.add(dto);
		});
		return list;
	}
	
	
	/*
	 * Stats API for course
	 * numofmoduels
	 * numofvideoes
	 * contentduration
	 */
	
	
	@GetMapping("/course/video/stats/{cid}")
	public ModuleStatsDto courseStatsByVideo(@PathVariable("cid") Long cid) {
		ModuleDto.ModuleStatsDto dto = new ModuleDto.ModuleStatsDto();
		/*
		 * get all modules by courseId
		 */
		List<Module> listOfModule = moduleRepository.findByCourseId(cid);
		/*
		 * get all video by courseID
		 */
		List<Video> listOfVideo = videoRepository.findByCourseId(cid);
		/*
		 * get the durations of the courses by course Id
		 */
		List<String> listOfDuration = listOfVideo.stream()
									.map(v->v.getDuration())
									.collect(Collectors.toList());
		/*
		 * looping through the durations and spilt duration by ":" to get indivisuals duration as
		 * first as minutes and second as seconds 
		 */
		int totalMins=0;
		int totalSec=0;
		int totalHrs=0;
		for(String d:listOfDuration){
			/*
			 * parsing string to integer for addition
			 */
			totalMins += Integer.parseInt(d.split(":")[0]);
			totalSec += Integer.parseInt(d.split(":")[1]);
		};
		
		/*
		 * adding the seconds in minutes 
		 */
		totalMins = totalMins + totalSec/60;
		/*
		 * converting mins to hrs
		 */
		totalHrs = totalMins/60;
		/*
		 * remaining minutes by converting minutes to hrs
		 */
		totalMins = totalMins%60;
		
		totalSec = totalSec%60;

		/*
		 * get number of modules by module list size
		 */
		if(listOfModule != null)
			dto.setNumOfModules(listOfModule.size());
		/*
		 * get number of videos by video list size
		 */
		if(listOfVideo != null)
			dto.setNumOfVideoes(listOfVideo.size());
		dto.setContentDuration(totalHrs +"Hrs " +  totalMins +"Min " + totalSec + "Sec");
		return dto;
	}
	
}
