package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cg.fms.dto.TrainingFeedback;

@Repository
public interface TrainingFeedbackRepository  extends JpaRepository<TrainingFeedback,Integer>{

}
