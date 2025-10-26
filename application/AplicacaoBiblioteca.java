package application;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import service.CadastroLivro;
import service.CadastroUsuario;
import controller.Login;


public class AplicacaoBiblioteca {
   public static void main(String[] args) {
	  int escolha, escolhaCadastro, escolhaLogin, qtdDisponivel, opcao, verificacaoEmail;
	  String nome, cpf, email, telefone, matricula, senha;
	  String titulo, autor, editora, isbn, anoPublicacao, categoria, localizacao;

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

				  System.out.print("TELEFONE: ");
				  telefone = scanner.nextLine();

				  System.out.print("CPF: ");
				  cpf = scanner.nextLine();

				  System.out.print("MATRICULA: ");
				  matricula = scanner.nextLine();

				  switch (escolhaCadastro) {
					 case 1:
						do {
						   System.out.print("EMAIL: ");
						   email = scanner.nextLine();

						   verificacaoEmail = Login.emailDuplicadoAluno(alunos, email);

						   if (verificacaoEmail == 0) {
							  System.out.print("SENHA: ");
							  senha = scanner.nextLine();

							  System.out.print("CURSO: ");
							  String curso = scanner.nextLine();
							  Aluno aluno = new Aluno(nome, cpf, email, telefone, matricula, senha, curso);
							  CadastroUsuario.adicionarAluno(alunos, aluno);
							  System.out.println("\nAluno cadastrado com sucesso!");
							  break;
						   } else {
							  System.out.println("\nEmail já existente!");
							  System.out.println("Informe um email válido!\n");
						   }
						} while (true);

						break;

					 case 2:
						do {
						   System.out.print("EMAIL: ");
						   email = scanner.nextLine();

						   verificacaoEmail = Login.emailDuplicadoProfessor(professores, email);

						   if (verificacaoEmail == 0) {
							  System.out.print("SENHA: ");
							  senha = scanner.nextLine();

							  System.out.print("DEPARTAMENTO: ");
							  String departamento = scanner.nextLine();
							  Professor professor = new Professor(nome, cpf, email, telefone, matricula, senha, departamento);
							  CadastroUsuario.adicionarProfessor(professores, professor);
							  System.out.println("\nProfessor cadastrado com sucesso!");
							  break;
						   } else {
							  System.out.println("\nEmail já existente!");
							  System.out.println("Informe um email válido!\n");
						   }
						} while (true);

						break;

					 case 3:
						do {
						   System.out.print("EMAIL: ");
						   email = scanner.nextLine();

						   verificacaoEmail = Login.emailDuplicadoBibliotecario(bibliotecarios, email);

						   if (verificacaoEmail == 0) {
							  System.out.print("SENHA: ");
							  senha = scanner.nextLine();

							  Bibliotecario bibliotecario = new Bibliotecario(nome, cpf, email, telefone, matricula, senha);
							  CadastroUsuario.adicionarBibliotecario(bibliotecarios, bibliotecario);
							  System.out.println("\nBibliotecário cadastrado com sucesso!");
							  break;
						   } else {
							  System.out.println("\nEmail já existente!");
							  System.out.println("Informe um email válido!\n");
						   }
						} while (true);

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
				  System.out.println("\nEmail incorreto! Ou não cadastrado!\n");

				  do {
					 int op;
					 System.out.println("1 - Inserir novamente.");
					 System.out.println("2 - Retornar ao menu principal.");
					 System.out.print("Digite aqui: ");
					 op = scanner.nextInt();

					 scanner.nextLine();
					 if (op == 1) {
						System.out.println("\n--- LOGIN ---");
						System.out.print("EMAIL: ");
						email = scanner.nextLine();

						aluno = Login.buscarAlunoPorEmail(alunos, email);
						professor = Login.buscarProfessorPorEmail(professores, email);
						bibliotecario = Login.buscarBibliotecarioPorEmail(bibliotecarios, email);
						if (aluno == null && bibliotecario == null && professor == null) {
						   System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
						} else {
						   break;
						}
					 } else  if (op == 2) {
						break;
					 } else {
						System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
					 }
				  } while (true);
			   }

			   int qtdTentativas = 3;

			   if (aluno != null) {
				  do {
					 System.out.print("SENHA: ");
					 senha = scanner.nextLine();

					 if (aluno.getSenha().equals(senha)) {
						break;
					 } else {
						qtdTentativas--;
						System.out.println("Senha incorreta. \nTentativas restantes: " + qtdTentativas);
					 }
				  } while (qtdTentativas > 0);

				  if (qtdTentativas == 0) {
					 System.out.println("Número de tentativas excedida.");
					 int resposta;
					 do {
					   System.out.println("1 - Redefinir senha agora.");
					   System.out.println("2 - Mais tarde.");
					   System.out.print("Digite aqui: ");
					   resposta= scanner.nextInt();
					   scanner.nextLine();
					   	if (resposta == 1) {
						   System.out.print("MATRICULA: ");
						   matricula = scanner.nextLine();
						   Login.redefinirSenhaAluno(alunos, matricula);
						   break;
						} else if (resposta == 2) {
						   System.out.println("Até mais");
						} else {
						   System.out.println("Desculpa, não entendi, digite uma das opções\n");
						}
					} while (resposta != 2);
					 break;

				  } else {
					 System.out.println("\nLogin realizado com sucesso.\n");
					 do{
						System.out.println("\nOperacoes:");
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
							  Login.emprestimoLivroAluno(livros, titulo, alunos, email);
							  break;
						   case 2:
							  System.out.println("Vendo livros disponiveis.");
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
						qtdTentativas--;
						System.out.println("Senha incorreta. \nTentativas restantes: " + qtdTentativas);
					 }
				  } while (qtdTentativas > 0);

				  if (qtdTentativas == 0) {
					 System.out.println("Número de tentativas excedida.");
					 int resposta;
					 do {
						System.out.println("1 - Redefinir senha agora.");
						System.out.println("2 - Mais tarde.");
						System.out.print("Digite aqui: ");
						resposta= scanner.nextInt();
						scanner.nextLine();
						if (resposta == 1) {
						   System.out.print("MATRICULA: ");
						   matricula = scanner.nextLine();
						   Login.redefinirSenhaProfessor(professores, matricula);
						   break;
						} else if (resposta == 2) {
						   System.out.println("Até mais");
						} else {
						   System.out.println("Desculpa, não entendi, digite uma das opções\n");
						}
					 } while (resposta != 2);
					 break;

				  } else {
					 System.out.println("\nLogin realizado com sucesso.\n");
					 do {
						System.out.println("\nOperacoes:");
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
							  Login.emprestimoLivroProfessor(livros, titulo, professores, email);
							  break;
						   case 2:
							  System.out.println("Vendo livros disponiveis.");
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
						qtdTentativas--;
						System.out.println("Senha incorreta. \nTentativas restantes: " + qtdTentativas);
					 }
				  } while (qtdTentativas > 0);

				  if (qtdTentativas == 0) {
					 System.out.println("Número de tentativas excedida.");
					 int resposta;
					 do {
						System.out.println("1 - Redefinir senha agora.");
						System.out.println("2 - Mais tarde.");
						System.out.print("Digite aqui: ");
						resposta= scanner.nextInt();
						scanner.nextLine();
						if (resposta == 1) {
						   System.out.print("MATRICULA: ");
						   matricula = scanner.nextLine();
						   Login.redefinirSenhaBibliotecario(bibliotecarios, matricula);
						   break;
						} else if (resposta == 2) {
						   System.out.println("Até mais");
						} else {
						   System.out.println("Desculpa, não entendi, digite uma das opções\n");
						}
					 } while (resposta != 2);
					 break;

				  } else {
					 System.out.println("\nLogin realizado com sucesso.\n");
					 do {
						System.out.println("\nOperacoes:");
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
							  Login.emprestimoLivroBibliotecario(livros, titulo, bibliotecarios, email);
							  break;
						   case 2:
							  System.out.println("Vendo livros disponiveis.");
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
							  System.out.println("1 - Aluno");
							  System.out.println("2 - Professor");
							  System.out.println("3 - Bibliotecario");
							  System.out.print("Digite uma opção: ");
							  opcao = scanner.nextInt();
							  scanner.nextLine();
							  if (opcao == 1) {
								 System.out.print("MATRICULA: ");
								 matricula = scanner.nextLine();
								 Login.cancelarCadastroAluno(alunos, matricula);
							  } else if (opcao == 2) {
								 System.out.print("MATRICULA: ");
								 matricula = scanner.nextLine();
								 Login.cancelarCadastroProfessor(professores, matricula);
							  } else if (opcao == 3) {
								 System.out.print("MATRICULA: ");
								 matricula = scanner.nextLine();
								 Login.cancelarCadastroBibliotecario(bibliotecarios, matricula);
							  } else {
								 System.out.println("Desculpa, não entendi, digite uma das opções\n");
							  }
							  break;
						   case 9:
							  Login.mostrarLivros(livros);
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

							  scanner.nextLine();
							  System.out.print("CATEGORIA: ");
							  categoria = scanner.nextLine();

							  System.out.print("LOCALIZACAO: ");
							  localizacao = scanner.nextLine();

							  Livro livro = new Livro(titulo, autor, editora, isbn, anoPublicacao, qtdDisponivel, categoria, localizacao);
							  CadastroLivro.adicionarLivro(livros, livro);
							  System.out.println("Livro cadastrado com sucesso.");
							  break;
						   case 11:
							  System.out.print("ISBN: ");
							  isbn = scanner.nextLine();
							  Login.removerLivro(livros, isbn);
							  break;
						   case 12:
							  System.out.println("Ver lista de emprestimos realizados.");
							  break;
						   case 13:
							  System.out.println("1 - Aluno");
							  System.out.println("2 - Professor");
							  System.out.println("3 - Bibliotecario");
							  System.out.print("Digite uma opção: ");
							  opcao = scanner.nextInt();
							  scanner.nextLine();
							  if (opcao == 1) {
								 Login.mostrarAlunos(alunos);
							  } else if (opcao == 2) {
								 Login.mostrarProfessores(professores);
							  } else if (opcao == 3) {
								 Login.mostrarBibliotecarios(bibliotecarios);
							  } else {
								 System.out.println("Desculpa, não entendi, digite uma das opções\n");
							  }
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