package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	public Employee findByLoginname(String loginname );


}
