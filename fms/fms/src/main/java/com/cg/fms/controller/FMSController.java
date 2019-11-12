package com.cg.fms.controller;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Employee;
import com.cg.fms.dto.EmployeeDetails;
import com.cg.fms.dto.TrainingAdmin;
import com.cg.fms.dto.TrainingCoordinator;
import com.cg.fms.dto.TrainingCourse;
import com.cg.fms.dto.TrainingFeedback;
import com.cg.fms.dto.TrainingParticipant;
import com.cg.fms.exception.MyException;
import com.cg.fms.service.FMSService;
import com.cg.fms.service.JwtUserDetailsService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FMSController {

	
	@Autowired
	private FMSService service;
	private static final Logger logger = LoggerFactory.getLogger(FMSController.class);
	
	@PostMapping(value="/addCourse")
	public ResponseEntity<?> addCourse(@ModelAttribute TrainingCourse course,@RequestParam("startDate")String startDate,@RequestParam("endDate")String endDate)
	{
		System.out.println(course);
		TrainingCourse newCourse=new TrainingCourse();
		try
		{
			//Set<Questions> listOfQuestions=new HashSet<Questions>();
			//List<Employee> employeeList=new ArrayList<Employee>();
			newCourse.setCourseName(course.getCourseName());
			newCourse.setCourseDescription(course.getCourseDescription());
			newCourse.setCourseDuration(course.getCourseDuration());
			
			newCourse.setCourseStartDate(LocalDateTime.parse(startDate,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			
			newCourse.setCourseEndDate(LocalDateTime.parse(endDate,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			
			newCourse.setDeleted(false);
			service.addTrainingCourse(newCourse);
		}
		catch(MyException exception)
		{
			return new ResponseEntity<TrainingCourse>(newCourse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<TrainingCourse>(newCourse,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/deleteCourse")
	public ResponseEntity<?> deleteCourse(@RequestParam("courseId")Integer id) throws MyException
	{
		Integer courseId=service.validateCourseId(id,service.getCourseList());
		
		if(courseId!=null)
		{
			service.deleteTrainingCourse(courseId);
			logger.trace("Course is not null");
			
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("not deleted",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping(value="/updateCourse")
	public ResponseEntity<?> updateCourse(@ModelAttribute TrainingCourse course) throws MyException
	{
		TrainingCourse result=service.updateCourse(course.getCourseId(), course);
		if(result!=null)
		{
			logger.trace("Course is not null");
			return new ResponseEntity<TrainingCourse>(result,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("not updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/viewFeedback")
	public ResponseEntity<?> viewFeedback(@ModelAttribute TrainingFeedback feedback) throws MyException{
		
		TrainingFeedback newFeedback = new TrainingFeedback();
		try
		{
		
		newFeedback.setDoubtClarification(feedback.getDoubtClarification());
		newFeedback.setHandoutProvided(feedback.getHandoutProvided());
		newFeedback.setPresentationSkill(feedback.getPresentationSkill());
		newFeedback.setResourceAvailability(feedback.getResourceAvailability());
		newFeedback.setTimeManagement(feedback.getTimeManagement());
		
		service.addTrainingFeedback(newFeedback);
		
		}catch(MyException exception)
		
		{  	logger.trace("Some Exception");
			return new ResponseEntity<TrainingFeedback>(newFeedback, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<TrainingFeedback>(newFeedback,HttpStatus.OK);
		
		}
	
	@PostMapping(value="/register")
	public ResponseEntity<String> register(@ModelAttribute TrainingParticipant employee){
		try {
			logger.trace("inside register");
			service.addParticipant(employee);
		} catch (Exception e) {
			logger.error("error in registration");
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Employee added successfully",HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getCourseList")
	public ResponseEntity<List<TrainingCourse>> viewTrainingCourses(@RequestParam("coordinatorId")Integer id) throws MyException
	{
		List<TrainingCourse> courses =service.getCourses(id);
		
		return new ResponseEntity<List<TrainingCourse>>(courses,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getCoordinatorList")
	public ResponseEntity<List<TrainingCoordinator>> viewTrainingCoordinators(Authentication authentication) throws MyException
	{	
		TrainingAdmin admin;
		EmployeeDetails details = (EmployeeDetails)authentication.getPrincipal();
		Employee user=null;
		
		List<TrainingCoordinator> coordinators =service.getCoordinators();
		try {
			
			admin = (TrainingAdmin)service.getUser(details.getUsername());
		
	
		} catch (MyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("controller"+coordinators);
		return new ResponseEntity<List<TrainingCoordinator>>(coordinators,HttpStatus.OK);
		
	}
	
	@GetMapping("/getUser")
	public Employee getUser(@RequestParam String loginName) throws MyException {
		System.out.println("Inside get user");
		Employee user = null;
		try {
			return service.getUser(loginName);
//			user.setUserPassword("1");
//		    TrainingAdmin admin = new TrainingAdmin(); 
//		 admin.setCourseList(null);
//		 admin.setCoordinatorList(null);
//		 admin.setParticipantList(null);
//		 user =(Employee)admin;
//		 System.out.println("inside role"+user.getEmployeeRole());
		} catch (MyException e) {
			// TODO Auto-generated catch block
			throw new MyException("User not present");
		}
//		System.out.println(user.getEmployeeRole());
//		return user;
	}
	
	
	
	
	
	
}
