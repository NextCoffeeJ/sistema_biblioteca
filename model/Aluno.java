package model;

public class Aluno extends Usuario {
    private String curso;
    private int limiteLivro;

    public Aluno(String nome, String cpf, String email, String telefone, String matricula, String senha, String curso) {
        super(nome, cpf, email, telefone, matricula, senha);
        this.curso = curso;
        this.limiteLivro = 3; 
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getLimiteLivro() {
        return limiteLivro;
    }

    public void setLimiteLivro(int limiteLivro) {
        this.limiteLivro = limiteLivro;
    }
}
