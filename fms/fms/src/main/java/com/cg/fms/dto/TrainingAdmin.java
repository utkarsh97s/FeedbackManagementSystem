package com.cg.fms.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@EntityListeners(AuditingEntityListener.class)
@EnableJpaAuditing
@Audited
public class TrainingAdmin extends Employee{
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<TrainingCoordinator> coordinatorList;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<TrainingCourse> courseList;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<TrainingParticipant> participantList;
	
	public TrainingAdmin() {
		super();
	}

	public List<TrainingParticipant> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<TrainingParticipant> participantList) {
		this.participantList = participantList;
	}

	public List<TrainingCoordinator> getCoordinatorList() {
		return coordinatorList;
	}

	public void setCoordinatorList(List<TrainingCoordinator> coordinatorList) {
		this.coordinatorList = coordinatorList;
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
		result = prime * result + ((coordinatorList == null) ? 0 : coordinatorList.hashCode());
		result = prime * result + ((courseList == null) ? 0 : courseList.hashCode());
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
		TrainingAdmin other = (TrainingAdmin) obj;
		if (coordinatorList == null) {
			if (other.coordinatorList != null)
				return false;
		} else if (!coordinatorList.equals(other.coordinatorList))
			return false;
		if (courseList == null) {
			if (other.courseList != null)
				return false;
		} else if (!courseList.equals(other.courseList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrainingAdmin [coordinatorList=" + coordinatorList + ", courseList=" + courseList + "]";
	}

	
	
	
	

}
