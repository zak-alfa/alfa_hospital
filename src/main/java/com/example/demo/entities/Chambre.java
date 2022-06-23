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
@AllArgsConstructor @NoArgsConstructor
public class Chambre {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)    
    private Long id ;
	
	@Column(nullable = false)
	private String numEtage;
	
	private Boolean disponible;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumEtage() {
		return numEtage;
	}

	public void setNumEtage(String numEtage) {
		this.numEtage = numEtage;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Chambre(String numEtage, Boolean disponible) {
		super();
		this.numEtage = numEtage;
		this.disponible = disponible;
	}

	public Chambre(Long id, String numEtage, Boolean disponible) {
		super();
		this.id = id;
		this.numEtage = numEtage;
		this.disponible = disponible;
	}

	public Chambre() {
		super();
	}
	
	

}
