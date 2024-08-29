package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "livros")
public class Livros {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "O nome não pode ser vazio!")
	private String nome;
	
	@NotBlank(message = "O gênero não pode ser vazio!")
	private String genero;
	
	@NotBlank(message = "O autor não pode ser vazio!")
	private String autor;

	@NotBlank(message = "O nome da editora não pode ser vazio!")
	private String editora ;
	
	@ManyToOne
	@JoinColumn(name = "biblioteca_id")
	private Biblioteca biblioteca;
	
	public Livros() {}
	
	public Livros(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca bibliotecas) {
		this.biblioteca = bibliotecas;
	}
	
}
