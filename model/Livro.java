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
}