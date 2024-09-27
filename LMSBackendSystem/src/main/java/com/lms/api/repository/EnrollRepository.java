package com.lms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.api.model.Enroll;
import com.lms.api.model.LearningTrack;

public interface EnrollRepository extends JpaRepository<Enroll, Long>{

	@Query("select e.learningTrack from Enroll e join e.user join e.learningTrack where e.user.id=?1")
	List<LearningTrack> findBylearningtrackid(Long uid);

}
