package com.microlog.syscav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microlog.syscav.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> 
{
	public AppUser findByEmail(String email);
}
