package com.cg.fms.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Audited
public class TrainingCourse {
	@Id
	@GeneratedValue
	@Column(name="course_id")
	private Integer courseId;
	@Column(name="course_name")
	private String courseName;
	@Column(name="course_startdate")
	private LocalDateTime courseStartDate;
	@Column(name="course_enddate")
	private LocalDateTime courseEndDate;
	@Column(name="course_duration")
	private Double courseDuration;
	@Column(name="course_description")
	private String courseDescription;
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	
//	@OneToMany(mappedBy = "course")
//	private List<TrainingFeedback> feedbackList;
//	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "course")
	private TrainingParticipant participant;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	@JoinColumn
	private TrainingCoordinator coordinator;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	@JoinColumn
	private TrainingAdmin admin;
	


	public String getCourseDescription() {
		return courseDescription;
	}


	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}


	public TrainingCourse() {
		super();
	}


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Double getCourseDuration() {
		return courseDuration;
	}


	public void setCourseDuration(Double courseDuration) {
		this.courseDuration = courseDuration;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	


	public LocalDateTime getCourseStartDate() {
		return courseStartDate;
	}


	public void setCourseStartDate(LocalDateTime courseStartDate) {
		this.courseStartDate = courseStartDate;
	}


	public LocalDateTime getCourseEndDate() {
		return courseEndDate;
	}


	public void setCourseEndDate(LocalDateTime courseEndDate) {
		this.courseEndDate = courseEndDate;
	}


	public TrainingParticipant getParticipant() {
		return participant;
	}


	public void setParticipant(TrainingParticipant participant) {
		this.participant = participant;
	}


	public TrainingCoordinator getCoordinator() {
		return coordinator;
	}


	public void setCoordinator(TrainingCoordinator coordinator) {
		this.coordinator = coordinator;
	}


	public TrainingAdmin getAdmin() {
		return admin;
	}


	public void setAdmin(TrainingAdmin admin) {
		this.admin = admin;
	}


	
}
