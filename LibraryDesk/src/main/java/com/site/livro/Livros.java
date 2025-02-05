package com.site.livro;
import java.time.LocalDate;
import java.util.*;


public class Livros {
	private Integer id; 	
	private String titulo;
	private String genero;
	private String editora;
	private String autor;
	private String ISBN;
	private String categoria;
	
	
	
	public Livros() {
		
	}
	
	public Livros(Integer id, String titulo, String genero, String editora, String autor, String ISBN, String categoria) {
		this.id	= id;
		this.titulo = titulo;
		this.genero = genero;
		this.editora = editora;
		this.autor = autor;
		this.ISBN = ISBN;
		this.categoria = categoria;
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public String getAutor() {
		return autor;
	}
	
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public String toString() {
		return "id= " + id + ", Titulo= " + titulo + ", genero= " + genero+ ", editora= " + editora + ", autor=" + autor + ", ISBN= " + ISBN + ", categoria= " + categoria;
	}
	
}
