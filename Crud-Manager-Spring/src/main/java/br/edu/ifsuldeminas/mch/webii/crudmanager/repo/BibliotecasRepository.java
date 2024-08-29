package br.edu.ifsuldeminas.mch.webii.crudmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Biblioteca;

@Repository
public interface BibliotecasRepository 
	extends JpaRepository<Biblioteca, Integer> {

}
