package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Employee;
import com.cg.fms.dto.TrainingAdmin;
import com.cg.fms.dto.TrainingParticipant;

@Repository
public interface TrainingParticipantRepository  extends JpaRepository<TrainingParticipant,Integer> {
	public TrainingParticipant findByLoginname(String loginname );
}
