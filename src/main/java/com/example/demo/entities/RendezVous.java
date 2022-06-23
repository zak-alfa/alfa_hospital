package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @AllArgsConstructor @NoArgsConstructor
public class RendezVous {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)    
    private Long id ;
	
	@Column(length = 30, nullable = false)
	private String fullName;
	
	@Column(length = 10, nullable = false)
	private String dateRdv;

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

	public String getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(String dateRdv) {
		this.dateRdv = dateRdv;
	}

	public RendezVous(Long id, String fullName, String dateRdv) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dateRdv = dateRdv;
	}

	public RendezVous(String fullName, String dateRdv) {
		super();
		this.fullName = fullName;
		this.dateRdv = dateRdv;
	}

	public RendezVous() {
		super();
	}
	
	

}
