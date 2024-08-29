package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Biblioteca;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.BibliotecasRepository;
import jakarta.validation.Valid;

@Controller
public class BibliotecaController {
	
	@Autowired
	private BibliotecasRepository bibliotecaRepo;
	
	@GetMapping("/bibliotecas")
	public String listBiblioteca(Model model) {
		
		List<Biblioteca> bibliotecas = bibliotecaRepo.findAll();
		
		model.addAttribute("bibliotecas", bibliotecas);
		
		return "biblioteca";
	}
	
	@GetMapping("/bibliotecas/form")
	public String bibliotecaForm(@ModelAttribute("biblioteca") Biblioteca patient) { 			
		return "bibliotecas_form";
	}
	
	@PostMapping("/bibliotecas/register")
	public String bibliotecaNew(@Valid
							 @ModelAttribute("biblioteca")
							Biblioteca biblioteca,
							 BindingResult erros) {
		if (erros.hasErrors()) {
			return "bibliotecas_form";
		}
		bibliotecaRepo.save(biblioteca);
		return "redirect:/bibliotecas";
	}
	
	@GetMapping("/bibliotecas/update/{id}")
	public String bibliotecaUpdate(@PathVariable("id")
								Integer id,
								Model model) {
		
		Optional<Biblioteca> bibliotecaOpt = bibliotecaRepo.findById(id);
		Biblioteca biblioteca;
		if (!bibliotecaOpt.isPresent()) {
			biblioteca = new Biblioteca();
		} else {
			biblioteca = bibliotecaOpt.get();
		}
		
		model.addAttribute("biblioteca", biblioteca);
		
		return "bibliotecas_form";
	}
	
	@GetMapping("/bibliotecas/delete/{id}")
	public String bibliotecaDelete(@PathVariable("id") Integer id) {
	    bibliotecaRepo.deleteById(id);
	    return "redirect:/bibliotecas";
	}

	
}