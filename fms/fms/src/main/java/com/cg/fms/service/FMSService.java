package com.cg.fms.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fms.dto.Employee;
import com.cg.fms.dto.TrainingAdmin;
import com.cg.fms.dto.TrainingCoordinator;
import com.cg.fms.dto.TrainingCourse;
import com.cg.fms.dto.TrainingFeedback;
import com.cg.fms.dto.TrainingParticipant;
import com.cg.fms.exception.MyException;
@Transactional
public interface FMSService {
	
	public TrainingCourse addTrainingCourse(TrainingCourse
			course) throws MyException;
	
	public boolean deleteTrainingCourse(Integer
			courseId) throws MyException;
	

	
	public boolean validateLoginCredentials(String loginName, String password);
	
	public TrainingFeedback viewFeedbackReport(Integer coordinatorId) throws MyException;
	
	public List<TrainingFeedback> getFeedbacks();

	public TrainingCourse updateCourse(Integer courseId, TrainingCourse course) throws MyException;

	public List<TrainingCourse> getCourseList() throws MyException;

	public Integer validateCourseId(Integer courseId, List<TrainingCourse> courseList) throws MyException;

	public TrainingCourse searchCourseById(Integer courseId) throws MyException;

	public TrainingFeedback addTrainingFeedback(TrainingFeedback feedback) throws MyException;

	public List<TrainingCoordinator> getCoordinators();

	public List<TrainingCourse> getCourses(Integer coordinatorId);

	

	public TrainingAdmin addAdmin(TrainingAdmin admin) throws MyException;

	public TrainingCoordinator addCoordinator(TrainingCoordinator employee) throws MyException;

	public TrainingParticipant addParticipant(TrainingParticipant employee) throws MyException;

//	public TrainingAdmin getAdmin(String employeeName) throws MyException;
//
//	public TrainingCoordinator getCoordinator(String employeeName) throws MyException;
//
//	public TrainingParticipant getParticipant(String employeeName) throws MyException;

	public Employee getUser(String employeeName) throws MyException;
	
	

}
