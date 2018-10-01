package com.microlog.syscav.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microlog.syscav.entities.AppRole;
import com.microlog.syscav.entities.Employee;
import com.microlog.syscav.services.AccountService;

@RestController
public class AccountRestController 
{
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<Employee> listEmployee() 
	{
		return accountService.listEmployee();
	}
	
	@RequestMapping(value = "/users-count", method = RequestMethod.GET)
	public Long listUsersCount() 
	{
		return accountService.usersCount();
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable Long id)
	{
		return accountService.getEmployee(id);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return accountService.createEmployee(employee);
	}
	
	@RequestMapping(value="/employee/{id}", method=RequestMethod.PUT)
	public Employee editEmployee(@PathVariable Long id, @RequestBody Employee employee)
	{
		employee.setId(id);
		return accountService.editEmployee(employee);
	}
	
	@RequestMapping(value="/employee/{id}", method=RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable Long id)
	{
		return accountService.deleteEmployee(id);
	}
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public List<AppRole> listRoles() 
	{
		return accountService.listRoles();
	}
	
	@RequestMapping(value = "/roles-count", method = RequestMethod.GET)
	public Long listRolesCount() 
	{
		return accountService.rolesCount();
	}
	
	@RequestMapping(value = "/roles/{id}", method = RequestMethod.GET)
	public AppRole getRole(@PathVariable Long id)
	{
		return accountService.getRole(id);
	}
	
	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public AppRole createRole(@RequestBody AppRole role)
	{
		return accountService.createRole(role);
	}
	
	@RequestMapping(value="/roles/{id}", method=RequestMethod.PUT)
	public AppRole editRole(@PathVariable Long id, @RequestBody AppRole role)
	{
		role.setId(id);
		return accountService.editRole(role);
	}
	
	@RequestMapping(value="/roles/{id}", method=RequestMethod.DELETE)
	public boolean deleteRole(@PathVariable Long id)
	{
		return accountService.deleteRole(id);
	}

}
