package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)    
    private Long id ;
	
	@Column(length = 30, nullable = false)
	private String fullName;
	
	private String Gender;
	
	@Column(length = 20)
	private String maladie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getMaladie() {
		return maladie;
	}

	public void setMaladie(String maladie) {
		this.maladie = maladie;
	}

	public Patient(String fullName, String gender, String maladie) {
		super();
		this.fullName = fullName;
		Gender = gender;
		this.maladie = maladie;
	}

	public Patient(Long id, String fullName, String gender, String maladie) {
		super();
		this.id = id;
		this.fullName = fullName;
		Gender = gender;
		this.maladie = maladie;
	}

	public Patient() {
		super();
	}
	
	

}
