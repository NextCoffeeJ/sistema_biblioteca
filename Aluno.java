public class Aluno extends Usuario {
   private String curso;
   private int limiteLivro = 3;

   public Aluno(String nome, String cpf, String email, String telefone, String matricula, String senha, String curso, int limiteLivro) {
	  super(nome, cpf, email, telefone, matricula, senha);
	  this.curso = curso;
	  this.limiteLivro = limiteLivro;
   }
}