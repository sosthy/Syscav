
package com.microlog.syscav.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sosthene Nouebissi
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppRole implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "ROLE_SEQ", allocationSize = 1, name = "role_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id")
    private Long id;
	
    private String roleName;
    private String description;
    
}
