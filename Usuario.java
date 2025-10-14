public class Usuario {
   protected String nome;
   protected String cpf;
   protected String email;
   protected String telefone;
   protected String matricula;
   protected String senha;

   public Usuario(String nome, String cpf, String email, String telefone, String matricula, String senha) {
	  this.nome = nome;
	  this.cpf = cpf;
	  this.email = email;
	  this.telefone = telefone;
	  this.matricula = matricula;
	  this.senha = senha;
   }
}