package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.TrainingCourse;
@Repository
public interface TrainingCourseRepository extends JpaRepository<TrainingCourse,Integer>{
	
	//public TrainingCourse findByCourseId(Integer courseId);
	
	//public TrainingCourse findByCourseName(String CourseName);
	

}
