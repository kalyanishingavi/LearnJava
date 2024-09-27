package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

	@Query("select i from Instructor i join i.course c where c.id=?1")
	List<Instructor> getInstructorByCourseId(Long cid);

	@Query("select MAX(i.salary), MIN(i.salary) , COUNT(i.id) from Instructor i")
	List<Double[]> getMaxSalary();

	

	
}
