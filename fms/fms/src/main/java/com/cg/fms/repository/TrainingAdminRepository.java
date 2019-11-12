package com.cg.fms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Employee;
import com.cg.fms.dto.TrainingAdmin;


@Repository
public interface TrainingAdminRepository extends JpaRepository<TrainingAdmin,Integer>
{
	public TrainingAdmin findByLoginname(String loginname );
}
