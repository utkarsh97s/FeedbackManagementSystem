package com.cg.fms.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Audited
public class TrainingCoordinator extends Employee{
	
	@JsonIgnore
	@OneToMany(mappedBy = "coordinator",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<TrainingParticipant> participantList;
	
	@JsonIgnore
	@OneToMany(mappedBy = "coordinator",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<TrainingCourse> courseList;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	@JoinColumn
    private TrainingAdmin admin;
	
	public TrainingCoordinator() {
		super();
	}

	public TrainingCoordinator(Integer coordinatorId, String userName, String loginName, String userPassword,
			List<TrainingParticipant> participantList, List<TrainingCourse> courseList) {
		super();
		
		this.participantList = participantList;
		this.courseList = courseList;
	}



	public List<TrainingParticipant> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<TrainingParticipant> participantList) {
		this.participantList = participantList;
	}

	public List<TrainingCourse> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<TrainingCourse> courseList) {
		this.courseList = courseList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((courseList == null) ? 0 : courseList.hashCode());
	
		result = prime * result + ((participantList == null) ? 0 : participantList.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingCoordinator other = (TrainingCoordinator) obj;
		
		if (courseList == null) {
			if (other.courseList != null)
				return false;
		} else if (!courseList.equals(other.courseList))
			return false;
		
		if (participantList == null) {
			if (other.participantList != null)
				return false;
		} else if (!participantList.equals(other.participantList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrainingCoordinator [participantList=" + participantList
				+ ", courseList=" + courseList + "]";
	}

	public TrainingAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(TrainingAdmin admin) {
		this.admin = admin;
	}
	
	
	
	

}
