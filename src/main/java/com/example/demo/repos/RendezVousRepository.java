package com.example.demo.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.RendezVous;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
	Page<RendezVous> findByFullNameContains(String fullName, Pageable pageable );


}
