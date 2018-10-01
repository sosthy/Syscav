package com.microlog.syscav.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microlog.syscav.entities.AppRole;
import com.microlog.syscav.entities.AppUser;
import com.microlog.syscav.entities.Employee;
import com.microlog.syscav.repositories.AppRoleRepository;
import com.microlog.syscav.repositories.AppUserRepository;
import com.microlog.syscav.repositories.EmployeeRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService 
{	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public List<Employee> listEmployee() 
	{
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployee(Long id) 
	{
		return employeeRepository.getOne(id);
	}
	
	@Override
	public Employee createEmployee(Employee employee) 
	{
		AppUser user = employee.getAppUser();
		user = saveUser(user);
		employee.setAppUser(user);
		
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee editEmployee(Employee employee) 
	{
		Employee temp = employeeRepository.findById(employee.getId()).get();
		
		if(!temp.getAppUser().getPassword().equals(employee.getAppUser().getPassword()))
			return createEmployee(employee);
		else
			return employeeRepository.save(employee);
	}
	
	@Override
	public boolean deleteEmployee(Long id) 
	{
		employeeRepository.deleteById(id);
		return true;
	}
	
	@Override
	public boolean lockEmployee(Long id) 
	{
		Employee employee = employeeRepository.findById(id).get();
		employee.getAppUser().setLock_status(true);
		employeeRepository.save(employee);
		return true;
	}
	
	@Override
	public boolean unlockEmployee(Long id) 
	{
		Employee employee = employeeRepository.findById(id).get();
		employee.getAppUser().setLock_status(false);
		employeeRepository.save(employee);
		return true;
	}
	
	@Override
	public List<AppRole> listRoles() 
	{
		return appRoleRepository.findAll();
	}
	
	@Override
	public AppRole getRole(Long id) 
	{
		return appRoleRepository.getOne(id);
	}
	
	@Override
	public AppRole createRole(AppRole role) 
	{
		return appRoleRepository.save(role);
	}
	
	@Override
	public AppRole editRole(AppRole role) 
	{
		return appRoleRepository.save(role);
	}
	
	@Override
	public boolean deleteRole(Long id) 
	{
		appRoleRepository.deleteById(id);
		return true;
	}
	
	@Override
	public Long usersCount()
	{
		return appUserRepository.count();
	}
	
	@Override
	public Long rolesCount()
	{
		return appRoleRepository.count();
	}
	
	@Override
	public AppUser findUserByEmail(String email) 
	{
		return appUserRepository.findByEmail(email);
	}

	public AppUser saveUser(AppUser user) 
	{
		String hashPW = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return appUserRepository.save(user);
	}
	
}
