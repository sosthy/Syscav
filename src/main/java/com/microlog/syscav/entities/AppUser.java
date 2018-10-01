
package com.microlog.syscav.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sosthene Nouebissi
 */
@Entity
@Table(name = "appuser")
@Data @AllArgsConstructor @NoArgsConstructor
public class AppUser implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "USER_SEQ", allocationSize = 1, name = "user_id")
    @GeneratedValue(generator = "user_id")
    private Long id;
	
	@Column(unique = true)
    private String email;
	
    private String username;
    private String password;
    private Boolean lock_status;
    
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appUser")
    private Employee employee;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles = new ArrayList<>();
    
}
