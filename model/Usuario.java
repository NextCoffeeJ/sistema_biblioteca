package model;

public class Usuario {
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String matricula;
    private String senha;
    private double multa;

    public Usuario(String nome, String cpf, String email, String telefone, String matricula, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.senha = senha;
        this.multa = 0.0; 
    }

   
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getMatricula() { return matricula; }
    public String getSenha() { return senha; }
    public double getMulta() { return multa; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    
    public void setSenha(String senha) {
        if (senha != null && senha.length() >= 4) {
            this.senha = senha;
        }
    }

    
    public void setMulta(double multa) {
        if (multa >= 0) {
            this.multa = multa;
        }
    }

    @Override
    public String toString() {
        return "Usuário: " + nome + " | Matrícula: " + matricula + " | Multa: R$" + String.format("%.2f", multa);
    }
}
