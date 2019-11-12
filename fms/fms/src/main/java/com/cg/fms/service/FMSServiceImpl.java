package com.cg.fms.service;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.fms.dto.Employee;
import com.cg.fms.dto.TrainingAdmin;
import com.cg.fms.dto.TrainingCoordinator;
import com.cg.fms.dto.TrainingCourse;
import com.cg.fms.dto.TrainingFeedback;
import com.cg.fms.dto.TrainingParticipant;
import com.cg.fms.exception.MyException;
import com.cg.fms.repository.EmployeeRepository;
import com.cg.fms.repository.TrainingAdminRepository;
import com.cg.fms.repository.TrainingCoordinatorRepository;
import com.cg.fms.repository.TrainingCourseRepository;
import com.cg.fms.repository.TrainingFeedbackRepository;
import com.cg.fms.repository.TrainingParticipantRepository;


@Service("FMSService")
public class FMSServiceImpl implements FMSService {

	
	@Autowired
	private TrainingAdminRepository adminDao;
	@Autowired
	private TrainingCoordinatorRepository coordinatorDao;
	@Autowired
	private TrainingCourseRepository courseDao;
	@Autowired
	private TrainingFeedbackRepository feedbackDao;
	@Autowired
	private TrainingParticipantRepository participantDao;
	@Autowired
	private EmployeeRepository employeeDao;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public TrainingCourse addTrainingCourse(TrainingCourse course) throws MyException {

		TrainingCourse newCourse= courseDao.save(course);
		if(newCourse == null)
		{
			throw new MyException("Course is not added");
		}
		return newCourse;
	}
	@Override
	public TrainingFeedback addTrainingFeedback(TrainingFeedback feedback) throws MyException {

		TrainingFeedback newFeedback= feedbackDao.save(feedback);
		if(newFeedback == null)
		{
			throw new MyException("feedback is not added");
		}
		return newFeedback;
	}
	@Override
	public boolean deleteTrainingCourse(Integer courseId) throws MyException {
		// TODO Auto-generated method stub
		TrainingCourse newCourse=courseDao.findById(courseId).get();
		if(newCourse==null)
		{
			throw new MyException("Course Id doesn't exist");
		}
		
		newCourse.setDeleted(true);
		courseDao.save(newCourse);
		System.out.println(courseId+" gets deleted");
		return true;
		
	}



	@Override
	public TrainingCourse updateCourse(Integer courseId,TrainingCourse course) throws MyException {
		// TODO Auto-generated method stub
		
		TrainingCourse newCourse=courseDao.findById(courseId).get();
		if(newCourse!=null)
		{
			
			newCourse.setCourseName(course.getCourseName());
			newCourse.setCourseDescription(course.getCourseDescription());
			newCourse.setCourseDuration(course.getCourseDuration());
			newCourse.setCourseStartDate(course.getCourseStartDate());
			newCourse.setCourseEndDate(course.getCourseEndDate());
			courseDao.save(newCourse);
			return newCourse;
		}
		else
		{
			throw new MyException("course not updated");
		}
		
		
	}

	@Override
	public boolean validateLoginCredentials(String loginName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TrainingFeedback viewFeedbackReport(Integer coordinatorId) throws MyException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<TrainingFeedback> getFeedbacks() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<TrainingCourse> getCourseList() throws MyException {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}
	
	
	@Override
	public Integer validateCourseId(Integer courseId, List<TrainingCourse> courseList) throws MyException {
		// TODO Auto-generated method stub
		String idCheck=""+courseId;
		if (idCheck.matches("^[0-9]+")) {
			Iterator<TrainingCourse> courseIterator = courseList.iterator();
			while (courseIterator.hasNext()) {
				TrainingCourse course = courseIterator.next();
				if (course.getCourseId().compareTo(new Integer(courseId)) == 0) {
					
					return course.getCourseId();
				}
			}
		}
		
		throw new MyException("CourseId is not present");
	
	}
	
	@Override
	public TrainingCourse searchCourseById(Integer courseId) throws MyException {
		// TODO Auto-generated method stub
		TrainingCourse course=courseDao.findById(courseId).get();
		if(course==null)
		{
			throw new MyException("Course with course ID "+courseId+" not found");
		}
		return course;
	}
	
	@Override
	public List<TrainingCoordinator> getCoordinators() {
		// TODO Auto-generated method stub
	    List<TrainingCoordinator> coordinators = coordinatorDao.findAll();
	
	   System.out.println(coordinators);
		return coordinators;
	}
	
	
	@Override
	public List<TrainingCourse> getCourses(Integer coordinatorId) {
		// TODO Auto-generated method stub
		TrainingCoordinator coordinator=coordinatorDao.findById(coordinatorId).get();
	    List<TrainingCourse> courses = coordinator.getCourseList();
	   
		return courses;
	}
//	@Override
//	public TrainingAdmin getAdmin(String employeeName) throws MyException {
//		System.out.println(employeeName);
//		TrainingAdmin employee=adminDao.findByLoginname(employeeName);
//		System.out.println("service "+employee);
//		if(employee!=null) {
//			
//			return employee;
//		}
//		throw new MyException("TrainingAdmin not present");
//	}
	@Override
	public Employee getUser(String employeeName) throws MyException {
		System.out.println("dssdfg"+employeeName);
		Employee employee=employeeDao.findByLoginname(employeeName);
		System.out.println(employee.getEmployeeRole());
		System.out.println("service "+employee);
		if(employee!=null) {
			System.out.println("returning");
			return employee;
		}
		throw new MyException("Employee not present");
	}
	
//	@Override
//	public TrainingCoordinator getCoordinator(String employeeName) throws MyException {
//		System.out.println(employeeName);
//		TrainingCoordinator employee=coordinatorDao.findByLoginname(employeeName);
//		System.out.println("service "+employee);
//		if(employee!=null) {
//			return employee;
//		}
//		throw new MyException("TrainingCoordinator not present");
//	}
//	
//	@Override
//	public TrainingParticipant getParticipant(String employeeName) throws MyException {
//		System.out.println(employeeName);
//		TrainingParticipant employee= participantDao.findByLoginname(employeeName);
//		System.out.println("service "+employee);
//		if(employee!=null) {
//			return employee;
//		}
//		throw new MyException("TrainingParticipant not present");
//	}
	@Override
	public TrainingAdmin addAdmin(TrainingAdmin admin) throws MyException {
		if(admin==null) {
			throw new MyException("Employee can not be null");
		}
		if(!admin.getEmployeeName().matches("[a-zA-Z]+")) {
			throw new MyException("Name must have only alphabets");
		}
	
		
		if(!admin.getUserPassword().matches("\\d{8,}")) {
			throw new MyException("Passord must have minimum 8 charecters");
		}
			
		
		admin.setEmployeeRole("ROLE_ADMIN");
		admin.setUserPassword(bcryptEncoder.encode(admin.getUserPassword()));
		adminDao.save(admin);
		admin.setLoginname(admin.getEmployeeName()+admin.getEmployeeId());
		adminDao.save(admin);
		return admin;
		
	}
	
	@Override
	public TrainingCoordinator addCoordinator(TrainingCoordinator employee) throws MyException {
		if(employee==null) {
			throw new MyException("Employee can not be null");
		}
		if(!employee.getEmployeeName().matches("[a-zA-Z]+")) {
			throw new MyException("Name must have only alphabets");
		}
	
		
		if(!employee.getUserPassword().matches("\\d{8,}")) {
			throw new MyException("Passord must have minimum 8 charecters");
		}
		List<TrainingCoordinator> coordinators = coordinatorDao.findAll();
		
			
			
			
		
		employee.setEmployeeRole("ROLE_COORDINATOR");
		employee.setUserPassword(bcryptEncoder.encode(employee.getUserPassword()));
		coordinatorDao.save(employee);
		employee.setLoginname(employee.getEmployeeName()+employee.getEmployeeId());
		coordinatorDao.save(employee);
		return employee;
		
	}
	
	@Override
	public TrainingParticipant addParticipant(TrainingParticipant employee) throws MyException {
		if(employee==null) {
			throw new MyException("Employee can not be null");
		}
		if(!employee.getEmployeeName().matches("[a-zA-Z]+")) {
			throw new MyException("Name must have only alphabets");
		}
	
		
		if(!employee.getUserPassword().matches("\\d{8,}")) {
			throw new MyException("Passord must have minimum 8 charecters");
		}
		List<TrainingParticipant> partcipants = participantDao.findAll();
		
			
			
			
		
		employee.setEmployeeRole("ROLE_ADMIN");
		employee.setUserPassword(bcryptEncoder.encode(employee.getUserPassword()));
		participantDao.save(employee);
		employee.setLoginname(employee.getEmployeeName()+employee.getEmployeeId());
		participantDao.save(employee);
		return employee;
		
	}
	
//	@Override
//	public List<Employee> getEmployee(Integer feedbackId) throws MyException {
//		// TODO Auto-generated method stub
//		List<Employee> user=employeeDao.findAll();
//		List<Employee> userList=new ArrayList<Employee>();
//		Iterator<Employee> iterator = user.iterator();
//		while(iterator.hasNext())
//		{
//			
//			Employee newUser=iterator.next();
//			//System.out.println(newUser.getSurvey().getSurveyId());
//			//System.out.println(newUser.getSurvey().getSurveyId().equals(surveyId));
//			if(newUser.isDeleted()==false && newUser.getSurvey().getSurveyId().equals(surveyId))
//			{
//				userList.add(newUser);
//				//System.out.println(userList.size());
//			}
//		}
//		//System.out.println(userList);
//		return userList;
//	}

	
}
