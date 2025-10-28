package model;

public class Professor extends Usuario {
    private String departamento;
    private int limiteLivros = 10;

    public Professor(String nome, String cpf, String email, String telefone, String matricula, String senha, String departamento) {
        super(nome, cpf, email, telefone, matricula, senha);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getLimiteLivros() {
        return limiteLivros;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setLimiteLivros(int limiteLivros) {
        if (limiteLivros > 0 && limiteLivros <= 50) { 
            this.limiteLivros = limiteLivros;
        }
    }

    @Override
    public String getEmail() {
        return super.getEmail(); 
    }

    @Override
    public String toString() {
        return "Professor: " + getNome() + " | Departamento: " + departamento + 
               " | Limite de livros: " + limiteLivros;
    }
}
