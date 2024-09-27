package com.lms.api.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.ReviewDto;
import com.lms.api.dto.ReviewStatsDto;
import com.lms.api.model.Course;
import com.lms.api.model.Review;
import com.lms.api.model.User;
import com.lms.api.repository.CourseRepository;
import com.lms.api.repository.ReviewRepository;
import com.lms.api.repository.UserRespository;

@RestController
public class ReviewController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserRespository userRespository;

	@PostMapping("/review/{cid}")
	public Review postReview(@RequestBody Review review,
							@PathVariable("cid") Long cid,
							Principal principal) {
		/*
		 * Getting course by course ID
		 */
		Course course = courseRepository.getById(cid);
		/*
		 * getting User by username by user
		 */
		User user = userRespository.findByUsername(principal.getName());
		review.setCourse(course);
		review.setUser(user);
		return reviewRepository.save(review);
	}
	
	/*
	 * get all reviews
	 */
	@GetMapping("/review")
	public List<Review> getReviews() {
		return reviewRepository.findAll();
	}
	/*
	 * get all by course ID
	 */
	@GetMapping("/review/{cid}")
	public List<ReviewDto> getByCourseId(@PathVariable("cid") Long cid){
		List<Review> list = reviewRepository.getByCourseID(cid);
		List<ReviewDto> reviewDto = new ArrayList<>();
		for(Review r:list) {
			ReviewDto dto = new ReviewDto();
			dto.setId(r.getId());
			dto.setContent(r.getContent());
			dto.setRating(r.getRating());
			dto.setUserId(r.getUser().getId());
			dto.setUsername(r.getUser().getUsername());
			dto.setName(r.getUser().getName());
			dto.setEmail(r.getUser().getEmail());
			dto.setCourseId(r.getCourse().getId());
			dto.setCourseName(r.getCourse().getName());
			dto.setLearningTrackId(r.getCourse().getLearningTrack().getId());
			dto.setLearningTrack(r.getCourse().getLearningTrack());
			reviewDto.add(dto);
		}
		return reviewDto;
	}
	/*
	 * Sorted reviews
	 */
	
	@GetMapping("/review/sort-rating/{cid}")
	public List<Review> getReviewByCourseIdSortByRatingDESC(@PathVariable("cid") Long cid){
		List<Review> list = reviewRepository.getByCourseID(cid);
		List<Review> Sortedlist = list.stream()
		.sorted(Comparator.comparing(Review::getRating).reversed())
		.collect(Collectors.toList());
		
		return Sortedlist;
	}
	
	/*
	 * Update Review: User that have created the review can only update that review
	 */
	
	@PutMapping("/review/{rid}")
	public Review updateReview(@RequestBody Review review,
								@PathVariable("rid") Long rid,
								Principal principal) {
		/*
		 * get review by db by review ID
		 */
		Review reviewDB = reviewRepository.getById(rid);
		
		if(! principal.getName().equalsIgnoreCase(reviewDB.getUser().getUsername())) {
			throw new RuntimeException("User not allowed to edit review");
		}
		if(review.getContent()!=null)
			reviewDB.setContent(review.getContent());
		if(review.getRating()!=0.0)
			reviewDB.setRating(review.getRating());
		return reviewRepository.save(reviewDB);
		
	}
	
	@GetMapping("/review/get-stats-by-courseid/{cid}")
	public ReviewStatsDto getReviewStatsByCourseId(@PathVariable("cid") Long cid) {
		/*
		 * get all reviews by course ID 
		 */
		List<Review> list = reviewRepository.getByCourseID(cid);
		/*
		 * creating object of reviw dto
		 */
		ReviewStatsDto dto = new ReviewStatsDto();
		/*
		 * get all reviews by list.size for the course
		 */
		dto.setTotalReviews(list.size());
		/*
		 * Using streams and filter counting the ratings
		 */
		dto.setStar5(list.stream().filter(r-> r.getRating() == 5).collect(Collectors.toList()).size());
		dto.setStar4(list.stream().filter(r-> r.getRating() == 4).collect(Collectors.toList()).size());
		dto.setStar3(list.stream().filter(r-> r.getRating() == 3).collect(Collectors.toList()).size());
		dto.setStar2(list.stream().filter(r-> r.getRating() == 2).collect(Collectors.toList()).size());
		dto.setStar1(list.stream().filter(r-> r.getRating() == 1).collect(Collectors.toList()).size());
		
		/*
		 * iterating with the list and checking all reviews and count the rating as per review
		 */
//		for(Review r:list) {
//			if(r.getRating()==1)
//				dto.setStar1(dto.getStar1()+1);
//			if(r.getRating()==2)
//				dto.setStar2(dto.getStar2()+1);
//			if(r.getRating()==3)
//				dto.setStar3(dto.getStar3()+1);
//			if(r.getRating()==4)
//				dto.setStar4(dto.getStar4()+1);
//			if(r.getRating()==5)
//				dto.setStar5(dto.getStar5()+1);
//		}
		return dto;
	}
}

