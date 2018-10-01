
package com.microlog.syscav.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sosthene Nouebissi
 */
@MappedSuperclass
@Data @AllArgsConstructor @NoArgsConstructor
public class Person implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "PERS_SEQ", allocationSize = 1, name = "pers_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_id")
    private Long id;
	
    private String name;
    private String surname;
    private String sex;
    private String cni;
    private String phone;
    private String photo;
    
    @Temporal(TemporalType.DATE)
    private Date birth_date;
}
