package com.microlog.syscav.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microlog.syscav.entities.AppUser;


@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		AppUser user = accountService.findUserByEmail(email);
		
		if(user == null)
			throw new UsernameNotFoundException(email);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});
		
		return new User(user.getEmail(), user.getPassword(), authorities);
	}

}
