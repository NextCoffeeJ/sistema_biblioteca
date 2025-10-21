package model;

public class Bibliotecario extends Usuario {
   private int limiteLivro = 15;

   public Bibliotecario(String nome, String cpf, String email, String telefone, String matricula, String senha) {
      super(nome, cpf, email, telefone, matricula, senha);
   }

   public int getLimiteLivro() {
      return limiteLivro;
   }

   public void setLimiteLivro(int limiteLivro) {
      this.limiteLivro = limiteLivro;
   }
}