package com.example.demo.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
	Page<Chambre> findByNumEtageContains(String numEtage, Pageable pageable );


}
