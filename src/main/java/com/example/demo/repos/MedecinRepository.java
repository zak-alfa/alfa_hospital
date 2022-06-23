package com.example.demo.repos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	Page<Medecin> findByFullNameContains(String fullName, Pageable pageable );


}
