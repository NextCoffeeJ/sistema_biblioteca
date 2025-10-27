package model;

public class Aluno extends Usuario {
   private String curso;
   private int limiteLivros = 3;

   public Aluno(String nome, String cpf, String email, String telefone, String matricula, String senha, String curso) {
	  super(nome, cpf, email, telefone, matricula, senha);
	  this.curso = curso;
   }

   public String getCurso() {
	  return curso;
   }

   public int getLimiteLivros() {
	  return limiteLivros;
   }

   public void setCurso(String curso) {
	  this.curso = curso;
   }

   public void setLimiteLivros(int limiteLivro) {
	  this.limiteLivros = limiteLivro;
   }

   public String getEmail(){
	  return email;
   }
}