package com.cg.fms.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Employee;
import com.cg.fms.dto.TrainingCoordinator;


@Repository
public interface TrainingCoordinatorRepository extends JpaRepository<TrainingCoordinator,Integer>{
	
	//public TrainingCoordinator findByCoordinatorId(Integer coordinatorId);
	public TrainingCoordinator findByLoginname(String loginname );

}
