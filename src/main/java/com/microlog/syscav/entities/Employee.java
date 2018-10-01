
package com.microlog.syscav.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sosthene Nouebissi
 */
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Employee extends Person implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "EMP_SEQ", allocationSize = 1, name = "emp_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id")
	private Long id;
	
    private Date hiring_date;
    private Integer anciennete;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private AppUser appUser;
    
    
    public void setAppUser(AppUser appUser)
    {
    	if(appUser == null)
    	{
    		if(this.appUser != null)
    		{
    			this.appUser.setEmployee(null);
    		}
    	}
    	else
    	{
    		appUser.setEmployee(this);
    	}
    	
    	this.appUser = appUser;
    }
   
}
