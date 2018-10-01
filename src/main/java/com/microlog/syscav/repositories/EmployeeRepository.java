package com.microlog.syscav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microlog.syscav.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{
	
}
