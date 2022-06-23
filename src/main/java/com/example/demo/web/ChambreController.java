package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Chambre;
import com.example.demo.repos.ChambreRepository;

@Controller
public class ChambreController {
	
	@Autowired
	ChambreRepository repository;
	
	@GetMapping(path = "/chambre/index")
	public String index(Model model,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "taille", defaultValue = "5") int taille,
			@RequestParam(name = "search", defaultValue = "") String keyword) {
		
		Page<Chambre> chambre = repository.findByNumEtageContains(keyword, PageRequest.of(page, taille));
		model.addAttribute("listOfChambre",chambre.getContent());
		model.addAttribute("currentPage", page);
		int[] pages = new int[chambre.getTotalPages()];
		for(int i=0;i<pages.length;i++) pages[i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("keyword", keyword);
		System.out.println("hi");

		return "chambre";
	}
	
	@PostMapping("/chambre/save")
	public String saveChambre(Model m, Chambre chambre) {
		repository.save(chambre);
		return "redirect:/chambre/index";
	}
	
	@GetMapping("/chambre/edit")
	public String editChambre(Model model, Long id) {
		
		model.addAttribute("chambre", repository.findById(id).get());
		return "EditChambre";
	}
	
	@GetMapping(path = "/chambre/delete")
	public String deleteChambre(Long id) {
		
		repository.deleteById(id);
		return "redirect:/chambre/index";
		}
	
}
