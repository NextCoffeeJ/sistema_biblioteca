package model;

public class Bibliotecario extends Usuario {
   private int limiteLivros = 15;

   public Bibliotecario(String nome, String cpf, String email, String telefone, String matricula, String senha, int limiteLivros) {
	  super(nome, cpf, email, telefone, matricula, senha);
	  this.limiteLivros = limiteLivros;
   }
}