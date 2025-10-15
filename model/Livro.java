package model;

public class Livro {
   private String titulo;
   private String autor;
   private String editora;
   private String isbn;
   private int anoPublicacao;
   private int qtdDisponivel;
   private String categoria;
   private String localizacao;

   public Livro(String titulo, String autor, String editora, String isbn, int anoPublicacao, int qtdDisponivel, String categoria, String localizacao) {
	  this.titulo = titulo;
	  this.autor = autor;
	  this.editora = editora;
	  this.isbn = isbn;
	  this.anoPublicacao = anoPublicacao;
	  this.qtdDisponivel = qtdDisponivel;
	  this.categoria = categoria;
	  this.localizacao = localizacao;
   }

   public String getTitulo() {
	  return titulo;
   }

   public String getAutor() {
	  return autor;
   }

   public String getEditora() {
	  return editora;
   }

   public String getIsbn() {
	  return isbn;
   }

   public int getAnoPublicacao() {
	  return anoPublicacao;
   }

   public int getQtdDisponivel() {
	  return qtdDisponivel;
   }

   public String categoria() {
	  return categoria;
   }

   public String localizacao() {
	  return localizacao;
   }
}