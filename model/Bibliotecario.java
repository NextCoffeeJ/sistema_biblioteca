package model;

public class Bibliotecario extends Usuario {
    private int limiteLivros;

    public Bibliotecario(String nome, String cpf, String email, String telefone, String matricula, String senha) {
        super(nome, cpf, email, telefone, matricula, senha);
        this.limiteLivros = 15; 
    }

    public int getLimiteLivros() {
        return limiteLivros;
    }

    public void setLimiteLivros(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }

    @Override
    public String toString() {
        return "Bibliotecário: " + getNome() + " | Limite de livros: " + limiteLivros;
    }
}
