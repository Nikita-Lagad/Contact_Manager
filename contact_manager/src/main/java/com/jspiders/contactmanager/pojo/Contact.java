package com.jspiders.contactmanager.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="contact_data")
public class Contact {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,unique = true)
	private String photo;
	
	@Column(nullable = false,unique = true)
	private long mobile;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	@Column(nullable = false)
	private String company;
	
	@Column(nullable = false)
	private String title;

}
