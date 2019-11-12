package com.cg.fms.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class TrainingFeedback {
	@Id
	@GeneratedValue
	@Column(name="feedback_id")
	private Integer feedbackId;
	@Column(name="presentation")
	private Integer presentationSkill;
	@Column(name="doubt_clarification")
	private Integer doubtClarification;
	@Column(name="timemanagement")
	private Integer timeManagement;
	@Column(name="handout")
	private Integer handoutProvided;
	@Column(name="resource")
	private Integer resourceAvailability;
	@Column(name="average")
	private Double averageRating;
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
	
//	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER )
//	@JoinColumn
//	private TrainingCourse course;
	@OneToOne(mappedBy = "feedback",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private TrainingParticipant participant;

	public TrainingFeedback() {
		super();
	}

	public TrainingFeedback(Integer presentationSkill, Integer doubtClarification, Integer timeManagement,
			Integer handoutProvided, Integer resourceAvailability, Double averageRating, TrainingCourse course) {
		super();
		this.presentationSkill = presentationSkill;
		this.doubtClarification = doubtClarification;
		this.timeManagement = timeManagement;
		this.handoutProvided = handoutProvided;
		this.resourceAvailability = resourceAvailability;
		this.averageRating = averageRating;
		
	}




	public Integer getPresentationSkill() {
		return presentationSkill;
	}

	public void setPresentationSkill(Integer presentationSkill) {
		this.presentationSkill = presentationSkill;
	}

	public Integer getDoubtClarification() {
		return doubtClarification;
	}

	public void setDoubtClarification(Integer doubtClarification) {
		this.doubtClarification = doubtClarification;
	}

	public Integer getTimeManagement() {
		return timeManagement;
	}

	public void setTimeManagement(Integer timeManagement) {
		this.timeManagement = timeManagement;
	}

	public Integer getHandoutProvided() {
		return handoutProvided;
	}

	public void setHandoutProvided(Integer handoutProvided) {
		this.handoutProvided = handoutProvided;
	}

	public Integer getResourceAvailability() {
		return resourceAvailability;
	}

	public void setResourceAvailability(Integer resourceAvailability) {
		this.resourceAvailability = resourceAvailability;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averageRating == null) ? 0 : averageRating.hashCode());
		
		result = prime * result + ((doubtClarification == null) ? 0 : doubtClarification.hashCode());
		result = prime * result + ((handoutProvided == null) ? 0 : handoutProvided.hashCode());
		result = prime * result + ((presentationSkill == null) ? 0 : presentationSkill.hashCode());
		result = prime * result + ((resourceAvailability == null) ? 0 : resourceAvailability.hashCode());
		result = prime * result + ((timeManagement == null) ? 0 : timeManagement.hashCode());
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
		TrainingFeedback other = (TrainingFeedback) obj;
		if (averageRating == null) {
			if (other.averageRating != null)
				return false;
		} else if (!averageRating.equals(other.averageRating))
			return false;
		
		if (doubtClarification == null) {
			if (other.doubtClarification != null)
				return false;
		} else if (!doubtClarification.equals(other.doubtClarification))
			return false;
		if (handoutProvided == null) {
			if (other.handoutProvided != null)
				return false;
		} else if (!handoutProvided.equals(other.handoutProvided))
			return false;
		if (presentationSkill == null) {
			if (other.presentationSkill != null)
				return false;
		} else if (!presentationSkill.equals(other.presentationSkill))
			return false;
		if (resourceAvailability == null) {
			if (other.resourceAvailability != null)
				return false;
		} else if (!resourceAvailability.equals(other.resourceAvailability))
			return false;
		if (timeManagement == null) {
			if (other.timeManagement != null)
				return false;
		} else if (!timeManagement.equals(other.timeManagement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrainingFeedback [presentationSkill=" + presentationSkill + ", doubtClarification=" + doubtClarification
				+ ", timeManagement=" + timeManagement + ", handoutProvided=" + handoutProvided
				+ ", resourceAvailability=" + resourceAvailability + ", averageRating=" + averageRating + ", " + "]";
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public TrainingParticipant getParticipant() {
		return participant;
	}

	public void setParticipant(TrainingParticipant participant) {
		this.participant = participant;
	}
	
	
	

}
