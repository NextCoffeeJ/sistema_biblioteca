package model;

public class Professor extends Usuario {
   private String departamento;
   private int limiteLivros = 10;

   public Professor(String nome, String cpf, String email, String telefone, String matricula, String senha, String departamento, int limiteLivros) {
	  super(nome, cpf, email, telefone, matricula, senha);
	  this.departamento = departamento;
	  this.limiteLivros = limiteLivros;
   }
}