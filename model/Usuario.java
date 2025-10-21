package model;

import java.io.Serializable;

public class Usuario implements Serializable {
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

public void exibirDados() {
	System.out.println("Nome: " + nome);
	System.out.println("CPF: " + cpf);
	System.out.println("Email: " + email);
	System.out.println("Telefone: " + telefone);
	System.out.println("Matrícula: " + matricula);
	System.out.println("Senha: " + senha);
	System.out.println("----------------------");
}
}