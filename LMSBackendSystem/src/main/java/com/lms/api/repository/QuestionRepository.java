package com.lms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.api.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	@Query("select q from Forum f join f.question q where f.id=?1")
	List<Question> findByForumId(Long fid);

}
