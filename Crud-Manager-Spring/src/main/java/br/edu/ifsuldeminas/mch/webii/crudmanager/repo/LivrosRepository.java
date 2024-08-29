package br.edu.ifsuldeminas.mch.webii.crudmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Livros;

public interface LivrosRepository 	
	extends JpaRepository<Livros, Integer> {


}
