package com.microlog.syscav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microlog.syscav.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> 
{
	public AppRole findByRoleName(String roleName);
}
