package com.cg.fms.service;

import com.cg.fms.dto.Employee;
import com.cg.fms.dto.EmployeeDetails;
import com.cg.fms.exception.MyException;
import com.cg.fms.model.UserDto;
import com.cg.fms.repository.EmployeeRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	FMSService service = new FMSServiceImpl();
	@Autowired
	private EmployeeDetails userDetails;

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		
		Optional<Employee> user;
		try {
			System.out.println("123"+loginName);
			user = Optional.of(service.getUser(loginName));
			System.out.println("123"+user);
		
			user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+loginName));
			return user.map(EmployeeDetails::new).get();
		} catch (MyException e) {
			e.printStackTrace();
		}
	
		return null;

	}
	
	public Employee save(UserDto user) {
		Employee newUser = new Employee();
		newUser.setEmployeeName(user.getUsername());
		newUser.setUserPassword(bcryptEncoder.encode(user.getPassword()));
		return repository.save(newUser);
	}

}
