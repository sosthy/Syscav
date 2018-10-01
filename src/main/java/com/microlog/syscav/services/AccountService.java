package com.microlog.syscav.services;

import java.util.List;

import com.microlog.syscav.entities.AppRole;
import com.microlog.syscav.entities.AppUser;
import com.microlog.syscav.entities.Employee;

public interface AccountService 
{
	public List<Employee> listEmployee();
	public Employee getEmployee(Long id);
	public Employee createEmployee(Employee employee);
	public Employee editEmployee(Employee employee);
	public boolean deleteEmployee(Long id);
	public boolean lockEmployee(Long id);
	public boolean unlockEmployee(Long id);
	
	public List<AppRole> listRoles();
	public AppRole getRole(Long id);
	public AppRole createRole(AppRole role);
	public AppRole editRole(AppRole appRole);
	public boolean deleteRole(Long id);
	
	public AppUser findUserByEmail(String email);
	public Long usersCount();
	public Long rolesCount();
	
}
