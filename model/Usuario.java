package model;
//Penso que essa clase poderia quem saber ser abstrata ja que ta servindo só para outras classes herdarem dela, mas seila não exatamente como funciona isso.
public class Usuario {
   protected String nome;
   protected String cpf;
   protected String email;
   protected String telefone;
   protected String matricula;
   protected String senha;
   //protected double multa; Quem sabe adicionar isso aqui. Explicação no main.
   
   public Usuario(String nome, String cpf, String email, String telefone, String matricula, String senha) {
	  this.nome = nome;
	  this.cpf = cpf;
	  this.email = email;
	  this.telefone = telefone;
	  this.matricula = matricula;
	  this.senha = senha;
   }

   public String getNome() {
	  return nome;
   }

   public String getCpf() {
	  return cpf;
   }

   public String getEmail() {
	  return email;
   }

   public String getTelefone() {
	  return telefone;
   }

   public String getMatricula() {
	  return matricula;
   }

   public String getSenha() {
	  return senha;
   }

   public void setNome(String nome) {
	  this.nome = nome;
   }

   public void setCpf(String cpf) {
	  this.cpf = cpf;
   }

   public void setEmail(String email) {
	  this.email = email;
   }

   public void setTelefone(String telefone) {
	  this.telefone = telefone;
   }

   public void setMatricula(String matricula) {
	  this.matricula = matricula;
   }

   public void setSenha(String senha) {
	  this.senha = senha;
   }
}
