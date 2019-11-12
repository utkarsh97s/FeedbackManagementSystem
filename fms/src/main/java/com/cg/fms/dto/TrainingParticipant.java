package com.cg.fms.dto;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Audited

public class TrainingParticipant extends Employee{
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER )
	@JoinColumn
    private TrainingAdmin admin;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER )
	@JoinColumn
    private TrainingCoordinator coordinator;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id",referencedColumnName = "course_id")
    private TrainingCourse course;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "feedback_id",referencedColumnName = "feedback_id")
	TrainingFeedback feedback;
	@CreatedBy
	protected String createdBy;
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date creationDate;
	@LastModifiedBy
	protected String lastModifiedBy;
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedDate;
	public TrainingParticipant() {
		super();
	}

	
	public TrainingParticipant(TrainingFeedback feedback) {
		super();
		this.feedback = feedback;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
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
		TrainingParticipant other = (TrainingParticipant) obj;
		if (feedback == null) {
			if (other.feedback != null)
				return false;
		} else if (!feedback.equals(other.feedback))
			return false;
		return true;
	}


	public TrainingFeedback getFeedback() {
		return feedback;
	}

	public void setFeedback(TrainingFeedback feedback) {
		this.feedback = feedback;
	}


	@Override
	public String toString() {
		return "TrainingParticipant [feedback=" + feedback + "]";
	}


	public TrainingAdmin getAdmin() {
		return admin;
	}


	public void setAdmin(TrainingAdmin admin) {
		this.admin = admin;
	}


	public TrainingCoordinator getCoordinator() {
		return coordinator;
	}


	public void setCoordinator(TrainingCoordinator coordinator) {
		this.coordinator = coordinator;
	}


	public TrainingCourse getCourse() {
		return course;
	}


	public void setCourse(TrainingCourse course) {
		this.course = course;
	}

	

}
