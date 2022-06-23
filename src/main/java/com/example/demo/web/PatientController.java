package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Patient;
import com.example.demo.repos.PatientRepository;

@Controller
public class PatientController {
	
	@Autowired
	PatientRepository repository;
	
	@GetMapping(path = "/patient/index")
	public String index(Model model,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "taille", defaultValue = "5") int taille,
			@RequestParam(name = "search", defaultValue = "") String keyword) {
		
		Page<Patient> patient = repository.findByFullNameContains(keyword, PageRequest.of(page, taille));
		model.addAttribute("listOfPatient",patient.getContent());
		model.addAttribute("currentPage", page);
		int[] pages = new int[patient.getTotalPages()];
		for(int i=0;i<pages.length;i++) pages[i]=i;
		model.addAttribute("pages", pages);
		model.addAttribute("keyword", keyword);

		return "patient";
	}
	
	@PostMapping("/patient/save")
	public String savePatient(Model m, Patient patient) {
		repository.save(patient);
		return "redirect:/patient/index";
	}
	
	@GetMapping("/patient/ajouter")
	public String ajouterPatient(Model model) {
		return "AjoutPatient";
	}
	
	@GetMapping("/patient/edit")
	public String editPatient(Model model, Long id) {
		
		model.addAttribute("patient", repository.findById(id).get());
		return "EditPatient";
	}
	
	@GetMapping(path = "/patient/delete")
	public String deletePatient(Long id) {
		
		repository.deleteById(id);
		return "redirect:/patient/index";
	}

}
