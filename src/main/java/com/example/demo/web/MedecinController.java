package com.example.demo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Medecin;
import com.example.demo.repos.MedecinRepository;

@Controller
public class MedecinController {
	
	@Autowired
	MedecinRepository repository;
	
	@GetMapping(path = "/medecin/index")
	public String index(Model model,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "taille", defaultValue = "5") int taille,
			@RequestParam(name = "search", defaultValue = "") String keyword) {
		
		Page<Medecin> medecin = repository.findByFullNameContains(keyword, PageRequest.of(page, taille));
		model.addAttribute("listOfMedecin",medecin.getContent());
		model.addAttribute("currentPage", page);
		int[] pages = new int[medecin.getTotalPages()];
		for(int i=0;i<pages.length;i++) pages[i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("keyword", keyword);

		return "medecin";
	}
	
	@PostMapping("/medecin/save")
	public String saveMedecin(Model m, Medecin medecin) {
		repository.save(medecin);
		return "redirect:/medecin/index";
	}
	@GetMapping("/medecin/ajouter")
	public String ajouterMedecin(Model model, Long id) {
		
		//model.addAttribute("medecin", repository.findById(id).get());
		return "AjoutMedecin";
	}
	
	@GetMapping("/medecin/edit")
	public String editMedecin(Model model, Long id) {
		
		model.addAttribute("medecin", repository.findById(id).get());
		
		return "EditMedecin";
	}
	
	@GetMapping(path = "/medecin/delete")
	public String deleteMedecin(Long id) {
		
		repository.deleteById(id);
		return "redirect:/medecin/index";
	}

}
