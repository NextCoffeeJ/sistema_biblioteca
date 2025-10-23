package model;

public class Bibliotecario extends Usuario {
   private int limiteLivros = 15;

   public Bibliotecario(String nome, String cpf, String email, String telefone, String matricula, String senha) {
	  super(nome, cpf, email, telefone, matricula, senha);
   }

   public int getLimiteLivros() {
	  return limiteLivros;
   }

   public void setLimiteLivros(int limiteLivros) {
	  this.limiteLivros = limiteLivros;
   }

   public String getEmail(){
	  return email;
   }
}