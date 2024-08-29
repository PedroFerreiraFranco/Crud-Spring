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

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Livros;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.BibliotecasRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.LivrosRepository;
import jakarta.validation.Valid;

@Controller
public class LivroController {
    
    @Autowired
    private LivrosRepository livroRepo;
    
    @Autowired
    private BibliotecasRepository bibliotecaRepo;
    
    @GetMapping("/livros")
    public String listLivros(Model model) {
        List<Livros> livros = livroRepo.findAll();
        
        model.addAttribute("livros", livros);
        
        return "livro";
    }
    
    @GetMapping("/livros/form")
    public String livrosForm(Model model) {
        model.addAttribute("livro", new Livros());
        model.addAttribute("bibliotecas", bibliotecaRepo.findAll());
        return "livros_form";
    }
    
    @PostMapping("/livros/register")
    public String livroNew(@Valid
                           @ModelAttribute("livro")
                           Livros livro,
                           BindingResult erros) {
        if (erros.hasErrors()) {
            return "livros_form";
        }
        
        livroRepo.save(livro);
        
        return "redirect:/livros";
    }

    
    @GetMapping("/livros/update/{id}")
    public String livroUpdate(@PathVariable("id")
                               Integer id,
                               Model model) {
        
        Optional<Livros> livroOpt = livroRepo.findById(id);
        Livros livro;
        
        if(!livroOpt.isPresent()) {
            livro = new Livros();
        } else {
            livro = livroOpt.get();
        }
        
        model.addAttribute("livro", livro);
        model.addAttribute("bibliotecas", bibliotecaRepo.findAll());
        return "livros_form";
    }
    
    @GetMapping("/livros/delete/{id}")
    public String livroDelete(@PathVariable("id") Integer id) {
        livroRepo.deleteById(id);
        return "redirect:/livros";
    }
}
