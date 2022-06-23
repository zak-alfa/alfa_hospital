package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.RendezVous;
import com.example.demo.repos.RendezVousRepository;

@Controller
public class RendezVousContoller {
	@Autowired
    RendezVousRepository repository;
	
	@GetMapping(path = "/rendezVous/index")
	public String index(Model model,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "taille", defaultValue = "5") int taille,
			@RequestParam(name = "search", defaultValue = "") String keyword) {
		
		Page<RendezVous> rendezVous = repository.findByFullNameContains(keyword, PageRequest.of(page, taille));
		model.addAttribute("listOfRendezvous",rendezVous.getContent());
		model.addAttribute("currentPage", page);
		int[] pages = new int[rendezVous.getTotalPages()];
		for(int i=0;i<pages.length;i++) pages[i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("keyword", keyword);

		return "rendezVous";
	}
	
	@PostMapping("/rendezVous/save")
	public String saveRendezVous(Model m, RendezVous rendezVous) {
		
		//System.out.println(rendezVous.getDateRdv());
		repository.save(rendezVous);
		return "redirect:/rendezVous/index";
	}
	
	@GetMapping("/rendezVous/ajouter")
	public String ajouterPatient(Model model) {
		return "AjoutRendezVous";
	}
	
	@GetMapping("/rendezVous/edit")
	public String editRendezVous(Model model, Long id) {
		
		model.addAttribute("RendezVous", repository.findById(id).get());
		return "EditRendezVous";
	}
	
	@GetMapping(path = "/rendezVous/delete")
	public String deleteRendezVous(Long id) {
		
		repository.deleteById(id);
		return "redirect:/rendezVous/index";
	}


}
