package model;

public class Livro {
   private String titulo;
   private String autor;
   private String editora;
   private String isbn;
   private String anoPublicacao;
   private int qtdDisponivel;
   private String categoria;
   private String localizacao;

   public Livro(String titulo, String autor, String editora, String isbn, String anoPublicacao, int qtdDisponivel, String categoria, String localizacao) {
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

   public String getAnoPublicacao() {
	  return anoPublicacao;
   }

   public int getQtdDisponivel() {
	  return qtdDisponivel;
   }

   public String getCategoria() {
	  return categoria;
   }

   public String getLocalizacao() {
	  return localizacao;
   }

   public void setTitulo(String titulo) {
	  this.titulo = titulo;
   }

   public void setAutor(String autor) {
	  this.autor = autor;
   }

   public void setEditora(String editora) {
	  this.editora = editora;
   }

   public void setIsbn(String isbn) {
	  this.isbn = isbn;
   }

   public void setAnoPublicacao(String anoPublicacao) {
	  this.anoPublicacao = anoPublicacao;
   }

   public void setQtdDisponivel(int qtdDisponivel) {
	  this.qtdDisponivel = qtdDisponivel;
   }

   public void setCategoria(String categoria) {
	  this.categoria = categoria;
   }

   public void setLocalizacao(String localizacao) {
	  this.localizacao = localizacao;
   }
}