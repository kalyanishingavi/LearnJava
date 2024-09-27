package com.lms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.api.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, Long>{

	@Query("select q.questionText from Forum f join f.question q where f.id=?1")
	List<String> getQuestionText(Long fid);

	

}
