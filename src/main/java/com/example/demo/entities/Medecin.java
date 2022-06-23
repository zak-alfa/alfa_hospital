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
public class Medecin {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)    
    private Long id ;
	
	@Column(length = 30, nullable = false)
	private String fullName;
	
	@Column(length = 20)
	private String specialite;
	
	private Boolean disponible;

	public Medecin(String fullName, String specialite, Boolean disponible) {
		super();
		this.fullName = fullName;
		this.specialite = specialite;
		this.disponible = disponible;
	}

	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
	

}
