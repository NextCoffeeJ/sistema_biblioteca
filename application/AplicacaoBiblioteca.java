package application;

import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;
import model.Bibliotecario;
import model.Professor;
import service.CadastroUsuario;
import service.Login;

public class AplicacaoBiblioteca {
   public static void main(String[] args) {
	  int escolha, escolhaCadastro;
	  String nome, cpf, email, telefone, matricula, senha;

	  ArrayList<Aluno> alunos = new ArrayList<>();
	  ArrayList<Professor> professores = new ArrayList<>();
	  ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();

	  Scanner scanner = new Scanner(System.in);

	  do {
		 System.out.println("\n--- OPCOES ---");
		 System.out.println("1 - Cadastrar");
		 System.out.println("2 - Login");
		 System.out.println("0 - Encerrar");
		 System.out.print("Qual opcao deseja: ");
		 escolha = scanner.nextInt();
		 scanner.nextLine();

		 switch (escolha) {
			case 1:
			   System.out.println("\n--- CADASTRO ---");
			   do {
				  System.out.println("Escolha o tipo de cadastro:");
				  System.out.println("1 - Aluno");
				  System.out.println("2 - Professor");
				  System.out.println("3 - Bibliotecario");
				  System.out.print("Opcao: ");
				  escolhaCadastro = scanner.nextInt();
				  scanner.nextLine();

				  System.out.println("\nInsira suas informações:");

				  System.out.print("NOME: ");
				  nome = scanner.nextLine();

				  System.out.print("CPF: ");
				  cpf = scanner.nextLine();

				  System.out.print("EMAIL: ");
				  email = scanner.nextLine();

				  System.out.print("TELEFONE: ");
				  telefone = scanner.nextLine();

				  System.out.print("MATRICULA: ");
				  matricula = scanner.nextLine();

				  System.out.print("SENHA: ");
				  senha = scanner.nextLine();

				  switch (escolhaCadastro) {
					 case 1:
						System.out.print("CURSO: ");
						String curso = scanner.nextLine();
						Aluno aluno = new Aluno(nome, cpf, email, telefone, matricula, senha, curso);
						CadastroUsuario.adicionarAluno(alunos, aluno);
						System.out.println("\nAluno cadastrado com sucesso!");
						break;

					 case 2:
						System.out.print("DEPARTAMENTO: ");
						String departamento = scanner.nextLine();
						Professor professor = new Professor(nome, cpf, email, telefone, matricula, senha, departamento);
						CadastroUsuario.adicionarProfessor(professores, professor);
						System.out.println("\nProfessor cadastrado com sucesso!");
						break;

					 case 3:
						Bibliotecario bibliotecario = new Bibliotecario(nome, cpf, email, telefone, matricula, senha);
						CadastroUsuario.adicionarBibliotecario(bibliotecarios, bibliotecario);
						System.out.println("\nBibliotecário cadastrado com sucesso!");
						break;

					 default:
						System.out.println("Opção inválida. Tente novamente.\n");
						break;
				  }
			   } while (escolhaCadastro !=1 && escolhaCadastro !=2 && escolhaCadastro != 3);
			   break;

			case 2:
			   System.out.println("\n--- LOGIN ---");
			   System.out.print("EMAIL: ");
			   email = scanner.nextLine();

			   Aluno testeA = Login.buscarAlunoPorEmail(alunos, email);
			   Professor testeP = Login.buscarProfessorPorEmail(professores, email);
			   Bibliotecario testeB = Login.buscarBibliotecarioPorEmail(bibliotecarios, email);

			   if (testeA == null && testeB == null && testeP == null) {
				  System.out.println("O email não está presente na lista. Faça o cadastro primeiro.");
				  break;
			   }

			   int qtd_tentativas = 3;

			   if (testeA != null) {
				  do {
					 System.out.print("SENHA: ");
					 senha = scanner.nextLine();

					 if (testeA.getSenha().equals(senha)) {
						break;
					 } else {
						qtd_tentativas--;
						System.out.println("Senha incorreta. Tentativas restantes: " + qtd_tentativas);
					 }
				  } while (qtd_tentativas > 0);

				  if (qtd_tentativas == 0) {
					 System.out.println("Número de qtd_tentativas excedido.");
					 break;
				  } else {
					 do{

						System.out.println("Login realizado com sucesso.\n");
						System.out.println("Operacoes:");
						System.out.println("1- Pedir livro emprestado.");
						System.out.println("2- Ver Livros disponiveis.");
						System.out.println("3- Devolver livro.");
						System.out.println("4- Renovar livro");
						System.out.println("5- Ver multas.");
						System.out.println("6- Ver dados dos livros pegos");
						System.out.println("0- Encerrar execucao.");
						System.out.print("Qual opcao deseja realizar: ");
						escolhaCadastro = scanner.nextInt();

						switch(escolhaCadastro){

						}


					 } while (escolhaCadastro != 0);
				  }

			   } else if (testeP != null) {
				  do {
					 System.out.print("SENHA: ");
					 senha = scanner.nextLine();

					 if (testeP.getSenha().equals(senha)) {
						break;
					 } else {
						qtd_tentativas--;
						System.out.println("Senha incorreta. Tentativas restantes: " + qtd_tentativas);
					 }
				  } while (qtd_tentativas > 0);

				  if (qtd_tentativas == 0) {
					 System.out.println("Número de qtd_tentativas excedido.");
					 break;
				  } else {
					 do {
						System.out.println("Login realizado com sucesso.\n");
						System.out.println("Operacoes:");
						System.out.println("1- Pedir livro emprestado.");
						System.out.println("2- Ver Livros disponiveis.");
						System.out.println("3- Devolver livro.");
						System.out.println("4- Renovar livro");
						System.out.println("5- Ver multas.");
						System.out.println("6- Ver dados dos livros pegos");
						System.out.println("0- Encerrar execucao.");
						System.out.print("Qual opcao deseja realizar: ");
						escolhaCadastro = scanner.nextInt();

						switch (escolhaCadastro){

						}
					 } while (escolhaCadastro != 0);
				  }

			   } else if (testeB != null) {
				  do {
					 System.out.print("SENHA: ");
					 senha = scanner.nextLine();

					 if (testeB.getSenha().equals(senha)) {
						break;
					 } else {
						qtd_tentativas--;
						System.out.println("Senha incorreta. Tentativas restantes: " + qtd_tentativas);
					 }
				  } while (qtd_tentativas > 0);

				  if (qtd_tentativas == 0) {
					 System.out.println("Número de qtd_tentativas excedido.");
					 break;
				  } else {
					 do {
						System.out.println("Login realizado com sucesso.\n");
						System.out.println("Operacoes:");
						System.out.println("1- Pedir livro emprestado.");
						System.out.println("2- Ver Livros disponiveis.");
						System.out.println("3- Devolver livro.");
						System.out.println("4- Renovar livro");
						System.out.println("5- Ver multas.");
						System.out.println("6- Ver dados dos livros pegos");
						System.out.println("7- Ver Usuarios Cadastrados.");
						System.out.println("8- Cancelar Cadastro de Usuario.");
						System.out.println("9- Ver livros cadastrados.");
						System.out.println("10- Cadastrar livros.");
						System.out.println("11- Remover livro de acervo");
						System.out.println("12- Ver lista de emprestimos realizados");
						System.out.println("0- Encerrar execucao.");
						System.out.print("Qual opcao deseja realizar: ");
						escolhaCadastro = scanner.nextInt();

						switch(escolhaCadastro){

						}
					 } while (escolhaCadastro != 0);
				  }
			   }

			   break;

			case 0:
			   System.out.println("Encerrando programa...");
			   break;

			default:
			   System.out.println("Opção inválida. Tente novamente.\n");
			   break;
		 }

	  } while (escolha != 0);

	  scanner.close();
   }
}