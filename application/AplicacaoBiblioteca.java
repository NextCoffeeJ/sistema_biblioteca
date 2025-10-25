package application;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import service.CadastroLivro;
import service.CadastroUsuario;
import service.Login;

public class AplicacaoBiblioteca {
   public static void main(String[] args) {
	  int escolha, escolhaCadastro, escolhaLogin;
	  String nome, cpf, email, telefone, matricula, senha;
	  String titulo, autor, editora, isbn, anoPublicacao, categoria, localizacao;
	  int qtdDisponivel;

	  ArrayList<Usuario> usuarios = new ArrayList<>();
	  ArrayList<Aluno> alunos = new ArrayList<>();
	  ArrayList<Professor> professores = new ArrayList<>();
	  ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();
	  ArrayList<Livro> livros = new ArrayList<>();

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

				  Usuario usuario = new Usuario(nome, cpf, email, telefone, matricula, senha);
				  CadastroUsuario.adicionarUsuario(usuarios,  usuario);

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

			   Aluno aluno = Login.buscarAlunoPorEmail(alunos, email);
			   Professor professor = Login.buscarProfessorPorEmail(professores, email);
			   Bibliotecario bibliotecario = Login.buscarBibliotecarioPorEmail(bibliotecarios, email);

			   if (aluno == null && bibliotecario == null && professor == null) {
				  System.out.println("O email não está presente na lista. \nFaça o cadastro primeiro.");
				  break;
			   }

			   int qtd_tentativas = 3;

			   if (aluno != null) {
				  do {
					 System.out.print("SENHA: ");
					 senha = scanner.nextLine();

					 if (aluno.getSenha().equals(senha)) {
						break;
					 } else {
						qtd_tentativas--;
						System.out.println("Senha incorreta. \nTentativas restantes: " + qtd_tentativas);
					 }
				  } while (qtd_tentativas > 0);

				  if (qtd_tentativas == 0) {
					 System.out.println("Número de tentativas excedida.");
					 break;
				  } else {
					 System.out.println("Login realizado com sucesso.\n");
					 do{
						System.out.println("Operacoes:");
						System.out.println("1 - Pedir livro emprestado.");
						System.out.println("2 - Ver Livros disponiveis.");
						System.out.println("3 - Devolver livro.");
						System.out.println("4 - Renovar livro");
						System.out.println("5 - Ver multas.");
						System.out.println("6 - Ver dados dos livros pegos.");
						System.out.println("7 - Logout.");
						System.out.println("0 - Fechar app.");
						System.out.print("Qual opcao deseja realizar: ");
						escolhaLogin = scanner.nextInt();

						scanner.nextLine();
						switch(escolhaLogin){
						   case 1:
							  System.out.print("TITULO: ");
							  titulo = scanner.nextLine();
							  Livro livroTitulo = Login.buscarLivroPorIsbn(livros, titulo);

							  if (livroTitulo == null) {
								 System.out.println("Livro não encontrado");
							  } else {
								 System.out.println("Livro encontrado");
								 //Resto da implementação
							  }
							  break;
						   case 2:
							  System.out.println("Vendo livros disponiveis.");
                              CadastroLivro.mostrarLivrosDisponiveis(livros);
							  break;
						   case 3:
							  System.out.println("Devolvendo Livro.");
							  break;
						   case 4:
							  System.out.println("Renovando Livro.");
							  break;
						   case 5:
							  System.out.println("Vendo multas");
							  break;
						   case 6:
							  System.out.println("Vendo dados dos livros pegos.");
							  break;
						   case 7:
							  System.out.println("Logout realizado com sucesso.");
							  break;
						   case 0:
							  escolha = 0;
							  System.out.println("Até mais...");
							  break;
						   default:
							  System.out.println("Opcao invalida.");
							  break;
						}

					 } while (escolha != 0 && escolhaLogin != 7);
				  }

			   } else if (professor != null) {
				  do {
					 System.out.print("SENHA: ");
					 senha = scanner.nextLine();

					 if (professor.getSenha().equals(senha)) {
						break;
					 } else {
						qtd_tentativas--;
						System.out.println("Senha incorreta. \nTentativas restantes: " + qtd_tentativas);
					 }
				  } while (qtd_tentativas > 0);

				  if (qtd_tentativas == 0) {
					 System.out.println("Número de tentativas excedida.");
					 break;
				  } else {
					 System.out.println("Login realizado com sucesso.\n");
					 do {
						System.out.println("Operacoes:");
						System.out.println("1 - Pedir livro emprestado.");
						System.out.println("2 - Ver Livros disponiveis.");
						System.out.println("3 - Devolver livro.");
						System.out.println("4 - Renovar livro");
						System.out.println("5 - Ver multas.");
						System.out.println("6 - Ver dados dos livros pegos.");
						System.out.println("7 - Logout.");
						System.out.println("0 - Fechar app.");
						System.out.print("Qual opcao deseja realizar: ");
						escolhaLogin = scanner.nextInt();

						scanner.nextLine();
						switch (escolhaLogin){
						   case 1:
							  System.out.print("TITULO: ");
							  titulo = scanner.nextLine();
							  Livro livroTitulo = Login.buscarLivroPorIsbn(livros, titulo);

							  if (livroTitulo == null) {
								 System.out.println("Livro não encontrado");
							  } else {
								 System.out.println("Livro encontrado");
								 //Resto da implementação
							  }
							  break;
						   case 2:
							  System.out.println("Vendo livros disponiveis.");
                              CadastroLivro.mostrarLivrosDisponiveis(livros);
							  break;
						   case 3:
							  System.out.println("Devolvendo Livro.");
							  break;
						   case 4:
							  System.out.println("Renovando Livro.");
							  break;
						   case 5:
							  System.out.println("Vendo multas");
							  break;
						   case 6:
							  System.out.println("Vendo dados dos livros pegos.");
							  break;
						   case 7:
							  System.out.println("Logout realizado com sucesso.");
							  break;
						   case 0:
							  escolha = 0;
							  System.out.println("Até mais...");
							  break;
						   default:
							  System.out.println("Opcao invalida.");
							  break;
						}
					 } while (escolha != 0  && escolhaLogin != 7);
				  }

			   } else if (bibliotecario != null) {
				  do {
					 System.out.print("SENHA: ");
					 senha = scanner.nextLine();

					 if (bibliotecario.getSenha().equals(senha)) {
						break;
					 } else {
						qtd_tentativas--;
						System.out.println("Senha incorreta. \nTentativas restantes: " + qtd_tentativas);
					 }
				  } while (qtd_tentativas > 0);

				  if (qtd_tentativas == 0) {
					 System.out.println("Número de tentativas excedida.");
					 break;
				  } else {
					 System.out.println("Login realizado com sucesso.\n");
					 do {
						System.out.println("Operacoes:");
						System.out.println("1 - Pedir livro emprestado.");
						System.out.println("2 - Ver Livros disponiveis.");
						System.out.println("3 - Devolver livro.");
						System.out.println("4 - Renovar livro.");
						System.out.println("5 - Ver multas.");
						System.out.println("6 - Ver dados dos livros pegos.");
						System.out.println("7 - Logout.");
						System.out.println("8 - Cancelar Cadastro de Usuario.");
						System.out.println("9 - Ver livros cadastrados.");
						System.out.println("10 - Cadastrar livro.");
						System.out.println("11 - Remover livro de acervo.");
						System.out.println("12 - Ver lista de emprestimos realizados.");
						System.out.println("13 - Ver Usuarios Cadastrados.");
						System.out.println("0 - Fechar app.");
						System.out.print("Qual opcao deseja realizar: ");
						escolhaLogin = scanner.nextInt();

						scanner.nextLine();
						switch(escolhaLogin){
						   case 1:
							  System.out.print("TITULO: ");
							  titulo = scanner.nextLine();
							  Livro livroTitulo = Login.buscarLivroPorIsbn(livros, titulo);

							  if (livroTitulo == null) {
								 System.out.println("Livro não encontrado");
							  } else {
								 System.out.println("Livro encontrado");
								 //Resto da implementação
							  }
							  break;
						   case 2:
							  System.out.println("Vendo livros disponiveis.");
                              CadastroLivro.mostrarLivrosDisponiveis(livros);
							  break;
						   case 3:
							  System.out.println("Devolvendo Livro.");
							  break;
						   case 4:
							  System.out.println("Renovando Livro.");
							  break;
						   case 5:
							  System.out.println("Vendo multas");
							  break;
						   case 6:
							  System.out.println("Vendo dados dos livros pegos.");
							  break;
						   case 7:
							  System.out.println("Logout realizado com sucesso.");
							  break;
						   case 8:
							  System.out.print("INFORME A MATRICULA DO ALUNO: ");
							  matricula = scanner.nextLine();
							  Login.cancelarCadastro(usuarios, matricula);
							  break;
						   case 9:
							  Livro mostrarColecao = Login.mostrarLivros(livros);
							  if (mostrarColecao == null) {
								 System.out.println("Lista vazia");
							  }
							  System.out.println("---------");
							  break;
						   case 10:
							  System.out.println("Insira as informações");

							  System.out.print("TITULO: ");
							  titulo = scanner.nextLine();

							  System.out.print("AUTOR: ");
							  autor = scanner.nextLine();

							  System.out.print("EDITORA: ");
							  editora = scanner.nextLine();

							  System.out.print("ISBN: ");
							  isbn = scanner.nextLine();

							  System.out.print("ANO PUBLICAÇÃO: ");
							  anoPublicacao = scanner.nextLine();

							  System.out.print("QUANTIDADE DISPONIVEL: ");
							  qtdDisponivel = scanner.nextInt();

							  System.out.print("CATEGORIA: ");
							  categoria = scanner.nextLine();

							  System.out.print("LOCALIZACAO: ");
							  localizacao = scanner.nextLine();

							  Livro livro = new Livro(titulo, autor, editora, isbn, anoPublicacao, qtdDisponivel, categoria, localizacao);
							  CadastroLivro.adicionarLivro(livros, livro);
							  System.out.println("Livro cadastrado com sucesso.");
							  break;
						   case 11:
							  System.out.print("TITULO: ");
							  titulo = scanner.nextLine();
							  Login.removerLivro(livros, titulo);
							  break;
						   case 12:
							  System.out.println("Ver lista de emprestimos realizados.");
							  break;
						   case 13:
							  Usuario user = Login.mostrarUsuarios(usuarios);
							  if (user == null) {
								 System.out.println("Lista vazia");
							  }
							  System.out.println("---------");
							  break;
						   case 0:
							  escolha = 0;
							  System.out.println("Até mais...");
							  break;
						   default:
							  System.out.println("Opcao invalida.");
							  break;
						}
					 } while (escolha != 0 && escolhaLogin != 7);
				  }
			   }

			   break;

			case 0:
			   System.out.println("Até mais...");
			   break;

			default:
			   System.out.println("Opção inválida. Tente novamente.\n");
			   break;
		 }

	  } while (escolha != 0);

	  scanner.close();
   }
}
