package application;
import controller.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import service.CadastroLivro;
import service.CadastroUsuario;

public class AplicacaoBiblioteca {
   public static void main(String[] args) {
	  byte escolha, escolhaCadastro, escolhaLogin, opcao, tipo, matriculaIgual, telefoneIgual, cpfIgual, isbnIgual, qtdCaracter;
	  int qtdDisponivel;
	  String nome="desconhecido" , cpf="desconhecido", email, telefone="desconhecido", matricula="desconhecido", senha, curso, departamento;
	  String titulo, autor, editora, isbn, anoPublicacao, categoria, localizacao;
	  LocalDate dataEmprestimo,dataLimiteDevolucao;

	  ArrayList<Aluno> alunos = new ArrayList<>();
	  ArrayList<Professor> professores = new ArrayList<>();
	  ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();
	  ArrayList<Livro> livros = new ArrayList<>();
	  ArrayList<Emprestimo> emprestimos = new ArrayList<>();

	  Scanner scanner = new Scanner(System.in);

	  do {
		 System.out.println("\n--- OPCOES ---");
		 System.out.println("1 - Cadastrar");
		 System.out.println("2 - Login");
		 System.out.println("0 - Encerrar");
		 System.out.print("Qual opcao deseja: ");
		 escolha = scanner.nextByte();
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
				  escolhaCadastro = scanner.nextByte();
				  scanner.nextLine();

				  if (escolhaCadastro == 1 || escolhaCadastro == 2 || escolhaCadastro == 3) {


					 System.out.println("\nInsira suas informações:\n");

					 do {
						System.out.print("NOME: ");
						nome = scanner.nextLine().strip();
						if (nome.isEmpty()) {
						   System.out.println("\nVocê precisa inserir um nome válido!\n");
						}
					 } while (nome.isEmpty());
				  }
				  switch (escolhaCadastro) {
					 case 1:
						do {
						   System.out.print("CPF: ");
						   cpf = scanner.nextLine().strip();
						   if (cpf.isEmpty()) {
							  System.out.println("Você precisa inserir um cpf válido!\n");
						   }
						} while (cpf.isEmpty());


						tipo = 1;
						cpfIgual = Busca.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);

						if (cpfIgual == 1) {
						   do {
							  System.out.println("\nEsse cpf já foi cadastrado!");
							  System.out.println("Insira um cpf válida!\n");
							  do {
								 System.out.print("CPF: ");
								 cpf =scanner.nextLine().strip();
								 if (cpf.isEmpty()) {
									System.out.println("Você precisa inserir um cpf válido!\n");
								 }
							  } while (cpf.isEmpty());


							  cpfIgual = Busca.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);
						   } while (cpfIgual == 1);
						}

						do {
						   System.out.print("TELEFONE: ");
						   telefone = scanner.nextLine().strip();
						   if (telefone.isEmpty()) {
							  System.out.println("Você precisa inserir um telefone válido!\n");
						   }
						} while (telefone.isEmpty());

						tipo = 1;
						telefoneIgual = Busca.telefoneDuplicado(alunos, professores, bibliotecarios, telefone, tipo);


						if (telefoneIgual == 1) {
						   do {
							  System.out.println("\nEsse telefone já foi cadastrado!");
							  System.out.println("Insira um telefone válida!\n");
							  do {
								 System.out.print("TELEFONE: ");
								 telefone = scanner.nextLine().strip();
								 if (telefone.isEmpty()) {
									System.out.println("Você precisa inserir um telefone válido!\n");
								 }
							  } while (telefone.isEmpty());


							  telefoneIgual = Busca.matriculaDuplicada(alunos, professores, bibliotecarios, telefone, tipo);
						   } while (telefoneIgual == 1);
						}

						do {
						   do {
							  System.out.print("MATRICULA: ");
							  matricula = scanner.nextLine().strip();
							  if (matricula.isEmpty()) {
								 System.out.println("Você precisa inserir uma matricula válido!\n");
							  }
						   } while (matricula.isEmpty());
						   qtdCaracter = scanner.nextByte();
						   if (qtdCaracter < 8) {
							  System.out.println("A matricula tem que ter 8 digitos!\n");
						   } else  if (qtdCaracter > 8) {
							  System.out.println("A matricula tem que ter 8 digitos!\n");
						   }
						} while (qtdCaracter != 8);

						tipo = 1;
						matriculaIgual = Busca.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);


						if (matriculaIgual == 1) {
						   do {
							  System.out.println("\nEssa matricula já pertence a um aluno!");
							  System.out.println("Insira uma matricula válida!\n");

							  do {
								 do {
									System.out.print("MATRICULA: ");
									matricula = scanner.nextLine().strip();
									if (matricula.isEmpty()) {
									   System.out.println("Você precisa inserir uma matricula válido!\n");
									}
								 } while (matricula.isEmpty());
								 qtdCaracter = (byte) matricula.length();
								 if (qtdCaracter < 8) {
									System.out.println("A matricula tem que ter 8 digitos!\n");
								 } else  if (qtdCaracter > 8) {
									System.out.println("A matricula tem que ter 8 digitos!\n");
								 }
							  } while (qtdCaracter != 8);

							  matriculaIgual = Busca.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);
						   } while (matriculaIgual == 1);
						}

						do {
						   do {
							  System.out.print("EMAIL: ");
							  email = scanner.nextLine().strip();
							  if (email.isEmpty()) {
								 System.out.println("Você precisa inserir um email válido!\n");
							  }
						   } while (email.isEmpty());

						   Aluno verificacaoEmail = Busca.buscarAlunoPorEmail(alunos, email);


						   if (verificacaoEmail == null) {
							  do {
								 do {
									System.out.print("SENHA: ");
									senha = scanner.nextLine().strip();
									if (senha.isEmpty()) {
									   System.out.println("Você precisa inserir uma senha válido!\n");
									}
								 } while (senha.isEmpty());
								 qtdCaracter = (byte) senha.length();
								 if (qtdCaracter < 8) {
									System.out.println("A senha tem que ter pelo menos 8 digitos!\n");
								 }
							  } while (qtdCaracter < 8);

							  do {
								 System.out.print("CURSO: ");
								 curso = scanner.nextLine().strip();
								 if (curso.isEmpty()) {
									System.out.println("Você precisa inserir um curso válido!\n");
								 }
							  } while (curso.isEmpty());


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
						   System.out.print("CPF: ");
						   cpf = scanner.nextLine().strip();
						   if (cpf.isEmpty()) {
							  System.out.println("Você precisa inserir um cpf válido!\n");
						   }
						} while (cpf.isEmpty());


						tipo = 2;
						cpfIgual = Busca.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);


						if (cpfIgual == 1) {
						   do {
							  System.out.println("\nEsse cpf já foi cadastrado!");
							  System.out.println("Insira um cpf válida!\n");


							  do {
								 System.out.print("CPF: ");
								 cpf = scanner.nextLine().strip();
								 if (cpf.isEmpty()) {
									System.out.println("Você precisa inserir um cpf válido!\n");
								 }
							  } while (cpf.isEmpty());


							  cpfIgual = Busca.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);
						   } while (cpfIgual == 1);
						}


						do {
						   System.out.print("TELEFONE: ");
						   telefone = scanner.nextLine().strip();
						   if (telefone.isEmpty()) {
							  System.out.println("Você precisa inserir um telefone válido!\n");
						   }
						} while (telefone.isEmpty());

						tipo = 2;
						telefoneIgual = Busca.telefoneDuplicado(alunos, professores, bibliotecarios, telefone, tipo);

						if (telefoneIgual == 1) {
						   do {
							  System.out.println("\nEsse telefone já foi cadastrado!");
							  System.out.println("Insira um telefone válida!\n");


							  do {
								 System.out.print("TELEFONE: ");
								 telefone = scanner.nextLine().strip();
								 if (telefone.isEmpty()) {
									System.out.println("Você precisa inserir um telefone válido!\n");
								 }
							  } while (telefone.isEmpty());

							  telefoneIgual = Busca.matriculaDuplicada(alunos, professores, bibliotecarios, telefone, tipo);
						   } while (telefoneIgual == 1);
						}

						do {
						   do {
							  System.out.print("MATRICULA: ");
							  matricula = scanner.nextLine().strip();
							  if (matricula.isEmpty()) {
								 System.out.println("Você precisa inserir uma matricula válido!\n");
							  }
						   } while (matricula.isEmpty());
						   qtdCaracter = (byte) matricula.length();
						   if (qtdCaracter < 8) {
							  System.out.println("A matricula tem que ter 8 digitos!\n");
						   } else  if (qtdCaracter > 8) {
							  System.out.println("A matricula tem que ter 8 digitos!\n");
						   }
						} while (qtdCaracter != 8);

						tipo = 2;
						matriculaIgual = Busca.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);


						if (matriculaIgual == 1) {
						   do {
							  System.out.println("\nEssa matricula já pertence a um professor!");
							  System.out.println("Insira uma matricula válida!\n");


							  do {
								 do {
									System.out.print("MATRICULA: ");
									matricula = scanner.nextLine().strip();
									if (matricula.isEmpty()) {
									   System.out.println("Você precisa inserir uma matricula válido!\n");
									}
								 } while (matricula.isEmpty());
								 qtdCaracter = (byte) matricula.length();
								 if (qtdCaracter < 8) {
									System.out.println("A matricula tem que ter 8 digitos!\n");
								 } else  if (qtdCaracter > 8) {
									System.out.println("A matricula tem que ter 8 digitos!\n");
								 }
							  } while (qtdCaracter != 8);


							  matriculaIgual = Busca.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);
						   } while (matriculaIgual == 1);
						}

						do {
						   do {
							  System.out.print("EMAIL: ");
							  email = scanner.nextLine().strip();
							  if (email.isEmpty()) {
								 System.out.println("Você precisa inserir um email válido!\n");
							  }
						   } while (email.isEmpty());


						   Professor verificacaoEmail = Busca.buscarProfessorPorEmail(professores, email);


						   if (verificacaoEmail == null) {

							  do {
								 do {
									System.out.print("SENHA: ");
									senha = scanner.nextLine().strip();
									if (senha.isEmpty()) {
									   System.out.println("Você precisa inserir uma senha válido!\n");
									}
								 } while (senha.isEmpty());
								 qtdCaracter = (byte) senha.length();
								 if (qtdCaracter < 8) {
									System.out.println("A senha tem que ter pelo menos 8 digitos!\n");
								 }
							  } while (qtdCaracter < 8);


							  do {
								 System.out.print("DEPARTAMENTO: ");
								 departamento = scanner.nextLine().strip();
								 if (departamento.isEmpty()) {
									System.out.println("Você precisa inserir um departamento válido!\n");
								 }
							  } while (departamento.isEmpty());


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
						   System.out.print("CPF: ");
						   cpf = scanner.nextLine().strip();
						   if (cpf.isEmpty()) {
							  System.out.println("Você precisa inserir um cpf válido!\n");
						   }
						} while (cpf.isEmpty());

						tipo = 3;
						cpfIgual = Busca.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);


						if (cpfIgual == 1) {
						   do {
							  System.out.println("\nEsse cpf já foi cadastrado!");
							  System.out.println("Insira um cpf válida!\n");


							  do {
								 System.out.print("CPF: ");
								 cpf = scanner.nextLine().strip();
								 if (cpf.isEmpty()) {
									System.out.println("Você precisa inserir um cpf válido!\n");
								 }
							  } while (cpf.isEmpty());


							  cpfIgual = Busca.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);
						   } while (cpfIgual == 1);
						}


						do {
						   System.out.print("TELEFONE: ");
						   telefone = scanner.nextLine().strip();
						   if (telefone.isEmpty()) {
							  System.out.println("Você precisa inserir um telefone válido!\n");
						   }
						} while (telefone.isEmpty());


						tipo = 3;
						telefoneIgual = Busca.telefoneDuplicado(alunos, professores, bibliotecarios, telefone, tipo);


						if (telefoneIgual == 1) {
						   do {
							  System.out.println("\nEsse telefone já foi cadastrado!");
							  System.out.println("Insira um telefone válida!\n");


							  do {
								 System.out.print("TELEFONE: ");
								 telefone = scanner.nextLine().strip();
								 if (telefone.isEmpty()) {
									System.out.println("Você precisa inserir um telefone válido!\n");
								 }
							  } while (telefone.isEmpty());


							  telefoneIgual = Busca.matriculaDuplicada(alunos, professores, bibliotecarios, telefone, tipo);
						   } while (telefoneIgual == 1);
						}

						do {
						   do {
							  System.out.print("MATRICULA: ");
							  matricula = scanner.nextLine().strip();
							  if (matricula.isEmpty()) {
								 System.out.println("Você precisa inserir uma matricula válido!\n");
							  }
						   } while (matricula.isEmpty());
						   qtdCaracter = (byte) matricula.length();
						   if (qtdCaracter < 8) {
							  System.out.println("A matricula tem que ter 8 digitos!\n");
						   } else  if (qtdCaracter > 8) {
							  System.out.println("A matricula tem que ter 8 digitos!\n");
						   }
						} while (qtdCaracter != 8);

						tipo = 3;
						matriculaIgual = Busca.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);


						if (matriculaIgual == 1) {
						   do {
							  System.out.println("\nEssa matricula já pertence a um bibliotecario!");
							  System.out.println("Insira uma matricula válida!\n");

							  do {
								 do {
									System.out.print("MATRICULA: ");
									matricula = scanner.nextLine().strip();
									if (matricula.isEmpty()) {
									   System.out.println("Você precisa inserir uma matricula válido!\n");
									}
								 } while (matricula.isEmpty());
								 qtdCaracter = (byte) matricula.length();
								 if (qtdCaracter < 8) {
									System.out.println("A matricula tem que ter 8 digitos!\n");
								 } else  if (qtdCaracter > 8) {
									System.out.println("A matricula tem que ter 8 digitos!\n");
								 }
							  } while (qtdCaracter != 8);

							  matriculaIgual = Busca.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);
						   } while (matriculaIgual == 1);
						}

						do {

						   do {
							  System.out.print("EMAIL: ");
							  email = scanner.nextLine().strip();
							  if (email.isEmpty()) {
								 System.out.println("Você precisa inserir um email válido!\n");
							  }
						   } while (email.isEmpty());


						   Bibliotecario verificacaoEmail = Busca.buscarBibliotecarioPorEmail(bibliotecarios, email);


						   if (verificacaoEmail == null) {

							  do {
								 do {
									System.out.print("SENHA: ");
									senha = scanner.nextLine().strip();
									if (senha.isEmpty()) {
									   System.out.println("Você precisa inserir uma senha válido!\n");
									}
								 } while (senha.isEmpty());
								 qtdCaracter = (byte) senha.length();
								 if (qtdCaracter < 8) {
									System.out.println("A senha tem que ter pelo menos 8 digitos!\n");
								 }
							  } while (qtdCaracter < 8);


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
			   } while (escolhaCadastro != 1 && escolhaCadastro != 2 && escolhaCadastro != 3);
			   break;

			case 2:
			   System.out.println("\n--- LOGIN ---");

			   do {
				  System.out.print("EMAIL: ");
				  email = scanner.nextLine().strip();
				  if (email.isEmpty()) {
					 System.out.println("Você precisa inserir um email válido!\n");
				  }
			   } while (email.isEmpty());

			   Aluno aluno = Busca.buscarAlunoPorEmail(alunos, email);
			   Professor professor = Busca.buscarProfessorPorEmail(professores, email);
			   Bibliotecario bibliotecario = Busca.buscarBibliotecarioPorEmail(bibliotecarios, email);

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
						do {
						   System.out.print("EMAIL: ");
						   email = scanner.nextLine();
						   if (email.isEmpty()) {
							  System.out.println("Você precisa inserir um email válido!\n");
						   }
						} while (email.isEmpty());

						aluno = Busca.buscarAlunoPorEmail(alunos, email);
						professor = Busca.buscarProfessorPorEmail(professores, email);
						bibliotecario = Busca.buscarBibliotecarioPorEmail(bibliotecarios, email);
						if (aluno == null && bibliotecario == null && professor == null) {
						   System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
						} else {
						   break;
						}
					 } else if (op == 2) {
						break;
					 } else {
						System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
					 }
				  } while (true);
			   }

			   int qtdTentativas = 3;

			   if (aluno != null) {
				  do {


					 do {
						System.out.print("SENHA: ");
						senha = scanner.nextLine().strip();
						if (senha.isEmpty()) {
						   System.out.println("Informe uma senha válida!");
						}
					 } while (senha.isEmpty());


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
						resposta = scanner.nextInt();
						scanner.nextLine();
						if (resposta == 1) {
						   do {
							  System.out.print("MATRICULA: ");
							  matricula = scanner.nextLine().strip();
							  if (matricula.isEmpty()) {
								 System.out.println("Informe uma matricula válida!");
							  }
						   } while (matricula.isEmpty());
						   RedefinirSenha.redefinirSenhaAluno(alunos, matricula);
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
						System.out.println("7 - Redefinir senha.");
						System.out.println("8 - Ver meus dados.");
						System.out.println("9 - Logout.");
						System.out.println("0 - Fechar app.");
						System.out.print("Qual opcao deseja realizar: ");
						escolhaLogin = scanner.nextByte();

						scanner.nextLine();
						switch (escolhaLogin) {
						   case 1:
							  do {
								 int escolhaLivro;

								 if (aluno.getLimiteLivros() == 0) {
									System.out.println("Voce não pode fazer mais emprestimos.");
									System.out.println("Voce so pode pegar 2 livros emprestados ao mesmo tempo.");
									System.out.println("Voce atingiu o limite de livros maximo.");
									System.out.println("Devolva algum livro para  poder fazer pedir outros livros emprestados.");
									break;
								 }
								 if (aluno.getMulta() != 0) {
									System.out.println("Voce esta com uma multa pendente no valor de R$" + aluno.getMulta());
									System.out.println("Pague a multa antes de fazer outro emprestimo!");
									break;
								 }
								 System.out.print("TITULO: ");
								 titulo = scanner.nextLine().strip();
								 Livro livro = Busca.buscarLivroPorNome(livros, titulo);
								 if (titulo.isEmpty()) {
									System.out.println("Titulo inválido!");
									System.out.println("Deseja continuar? ");
									System.out.println("1 - sim");
									System.out.println("2 - nao");
									escolhaLivro = scanner.nextInt();
									scanner.nextLine();

									if (escolhaLivro == 2) {
									   break;
									}

								 } else if (livro == null) {


									System.out.println("O Livro nao presente no acervo.");
									System.out.println("Deseja continuar? ");
									System.out.println("1 - Sim.");
									System.out.println("2 - Não.");
									System.out.print("Digite aqui: ");
									escolhaLivro = scanner.nextInt();
									scanner.nextLine();

									if (escolhaLivro == 2) {
									   break;
									}
								 } else {

									if (livro.getQtdDisponivel() == 0) {
									   System.out.println("Nao foi possivel fazer o emprestimo desse livro.");
									   System.out.println("Nao ha nenhum livro disponivel.");


									   System.out.println("Deseja continuar? ");
									   System.out.println("1 - Sim.");
									   System.out.println("2 - Não.");
									   System.out.print("Digite aqui: ");
									   escolhaLivro = scanner.nextInt();
									   scanner.nextLine();


									   if (escolhaLivro == 2) {
										  break;
									   }
									} else if (Busca.buscarEmprestimoPorAlunoETitulo(aluno, livro, emprestimos) != null) {
									   System.out.println("Voce ja fez  o emprestimo desse livro.");
									   System.out.println("Deseja continuar? ");
									   System.out.println("1 - Sim.");
									   System.out.println("2 - Não.");
									   System.out.print("Digite aqui: ");
									   escolhaLivro = scanner.nextInt();
									   scanner.nextLine();


									   if (escolhaLivro == 2) {
										  break;
									   }


									} else {
									   dataEmprestimo = LocalDate.now();
									   dataLimiteDevolucao = LocalDate.now().plusDays(10);
									   Emprestimo emprestimo = new Emprestimo(aluno, livro, dataEmprestimo, dataLimiteDevolucao);
									   emprestimos.add(emprestimo);
									   livro.setQtdDisponivel(livro.getQtdDisponivel() - 1);
									   aluno.setLimiteLivros(aluno.getLimiteLivros() - 1);
									   System.out.println("Emprestimo realizado com sucesso.\n");
									   break;
									}
								 }


							  } while (true);
							  break;
						   case 2:
							  System.out.println("Vendo livros disponiveis: ");
							  Exibicao.mostrarLivrosDisponiveis(livros);
							  break;
						   case 3:
							  System.out.println("Devolvendo Livro.");
							  Devolucao.devolverLivroAluno(livros, alunos, emprestimos);
							  break;
						   case 4:
							  System.out.println("Renovando Livro.");
							  Renovar.renovarLivroAluno(livros, alunos, emprestimos);
							  break;
						   case 5:
							  System.out.println("Vendo multas (Aluno): ");
							  Exibicao.verMultasAluno(livros, alunos, emprestimos);
							  break;
						   case 6:
							  Exibicao.dadosLivrosUsuario(emprestimos, email);
							  break;
						   case 7:
							  do {
								 System.out.print("MATRICULA: ");
								 matricula = scanner.nextLine().strip();
								 if (matricula.isEmpty()) {
									System.out.println("Insira uma matricula válida");
								 }
							  } while (matricula.isEmpty());
							  RedefinirSenha.redefinirSenhaAluno(alunos, matricula);
							  break;
						   case 8:
							  tipo = 1;
							  Exibicao.dadosUsuario(alunos, professores, bibliotecarios, email, tipo);
							  break;
						   case 9:
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


					 } while (escolha != 0 && escolhaLogin != 9);
				  }

			   } else if (professor != null) {
				  do {

					 do {
						System.out.print("SENHA: ");
						senha = scanner.nextLine().strip();
						if (senha.isEmpty()) {
						   System.out.println("Informe uma senha válida!");
						}
					 } while (senha.isEmpty());

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
						resposta = scanner.nextInt();
						scanner.nextLine();
						if (resposta == 1) {
						   do {
							  System.out.print("MATRICULA: ");
							  matricula = scanner.nextLine().strip();
							  if (matricula.isEmpty()) {
								 System.out.println("Informe uma matricula válida!");
							  }
						   } while (matricula.isEmpty());
						   RedefinirSenha.redefinirSenhaProfessor(professores, matricula);
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
						System.out.println("7 - Redefinir senha.");
						System.out.println("8 - Ver meus dados.");
						System.out.println("9 - Logout.");
						System.out.println("0 - Fechar app.");
						System.out.print("Qual opcao deseja realizar: ");
						escolhaLogin = scanner.nextByte();

						scanner.nextLine();
						switch (escolhaLogin) {
						   case 1:
							  do {
								 int escolhaLivro;
								 if (professor.getLimiteLivros() == 0) {
									System.out.println("Voce não pode fazer mais emprestimos.");
									System.out.println("Voce so pode pegar 4 livros emprestados ao mesmo tempo.");
									System.out.println("Voce atingiu o limite de livros maximo.");
									System.out.println("Devolva algum livro para  poder fazer pedir outros livros emprestados.");
									break;
								 }
								 if (professor.getMulta() != 0) {
									System.out.println("Voce esta com uma multa pendente no valor de R$" + professor.getMulta());
									System.out.println("Pague a multa antes de fazer outro emprestimo!");
									break;
								 }
								 System.out.print("TITULO: ");
								 titulo = scanner.nextLine().strip();
								 Livro livro = Busca.buscarLivroPorNome(livros, titulo);
								 if (titulo.isEmpty()) {
									System.out.println("Titulo inválido!");
									System.out.println("Deseja continuar? ");
									System.out.println("1- sim");
									System.out.println("2- nao");
									escolhaLivro = scanner.nextInt();
									scanner.nextLine();

									if (escolhaLivro == 2) {
									   break;
									}

								 } else if (livro == null) {

									System.out.println("O Livro não  está presente no acervo.");
									System.out.println("Deseja continuar? ");
									System.out.println("1 - Sim.");
									System.out.println("2 - Não.");
									escolhaLivro = scanner.nextInt();
									scanner.nextLine();

									if (escolhaLivro == 2) {
									   break;
									}

								 } else {

									if (livro.getQtdDisponivel() == 0) {
									   System.out.println("Nao foi possivel fazer o emprestimo desse livro.");
									   System.out.println("Nao ha nenhum livro disponivel.");


									   System.out.println("Deseja continuar? ");
									   System.out.println("1 - Sim.");
									   System.out.println("2 - Não.");
									   escolhaLivro = scanner.nextInt();
									   scanner.nextLine();

									   if (escolhaLivro == 2) {
										  break;
									   }

									} else if (Busca.buscarEmprestimoPorProfessorETitulo(professor, livro, emprestimos) != null) {
									   System.out.println("Voce ja fez o emprestimo desse livro.");
									   System.out.println("Deseja continuar? ");
									   System.out.println("1 - Sim.");
									   System.out.println("2 - Não.");
									   escolhaLivro = scanner.nextInt();
									   scanner.nextLine();

									   if (escolhaLivro == 2) {
										  break;
									   }

									} else {
									   dataEmprestimo = LocalDate.now();
									   dataLimiteDevolucao = LocalDate.now().plusDays(10);
									   Emprestimo emprestimo = new Emprestimo(professor, livro, dataEmprestimo, dataLimiteDevolucao);
									   emprestimos.add(emprestimo);
									   livro.setQtdDisponivel(livro.getQtdDisponivel() - 1);
									   professor.setLimiteLivros(professor.getLimiteLivros() - 1);
									   System.out.println("Emprestimo realizado com sucesso.\n");
									   break;
									}
								 }

							  } while (true);
							  break;
						   case 2:
							  System.out.println("Vendo livros disponiveis: ");
							  Exibicao.mostrarLivrosDisponiveis(livros);
							  break;
						   case 3:
							  System.out.println("Devolvendo Livro.");
							  Devolucao.devolverLivroProfessor(livros, professores, emprestimos);
							  break;
						   case 4:
							  System.out.println("Renovando Livro.");
							  Renovar.renovarLivroProfessor(livros, professores, emprestimos);
							  break;
						   case 5:
							  System.out.println("Vendo multas (Professor): ");
							  Exibicao.verMultasProfessor(livros, professores, emprestimos);
							  break;
						   case 6:
							  Exibicao.dadosLivrosUsuario(emprestimos, email);
							  break;
						   case 7:
							  do {
								 System.out.println("MATRICULA: ");
								 matricula = scanner.nextLine().strip();
								 if (matricula.isEmpty()) {
									System.out.println("Informe uma matricula válida!");
								 }
							  } while (matricula.isEmpty());
							  RedefinirSenha.redefinirSenhaProfessor(professores, matricula);
							  break;
						   case 8:
							  tipo = 2;
							  Exibicao.dadosUsuario(alunos, professores, bibliotecarios, email, tipo);
							  break;
						   case 9:
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
					 } while (escolha != 0 && escolhaLogin != 9);
				  }

			   } else if (bibliotecario != null) {
				  do {

					 do {
						System.out.print("SENHA: ");
						senha = scanner.nextLine().strip();
						if (senha.isEmpty()) {
						   System.out.println("Informe uma senha válida!");
						}
					 } while (senha.isEmpty());

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
						resposta = scanner.nextInt();
						scanner.nextLine();
						if (resposta == 1) {
						   do {
							  System.out.print("MATRICULA: ");
							  matricula = scanner.nextLine().strip();
							  if (matricula.isEmpty()) {
								 System.out.println("Informe uma matricula válida!");
							  }
						   } while (matricula.isEmpty());
						   RedefinirSenha.redefinirSenhaBibliotecario(bibliotecarios, matricula);
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
						System.out.println("7 - Redefinir senha.");
						System.out.println("8 - Cancelar Cadastro de Usuario.");
						System.out.println("9 - Ver livros cadastrados.");
						System.out.println("10 - Cadastrar livro.");
						System.out.println("11 - Remover livro de acervo.");
						System.out.println("12 - Ver lista de emprestimos realizados.");
						System.out.println("13 - Ver Usuarios Cadastrados.");
						System.out.println("14 - Ver meus dados.");
						System.out.println("15 - Logout.");
						System.out.println("16 - Alterar quantidade de livros disponíveis.");
						System.out.println("0 - Fechar app.");
						System.out.print("Qual opcao deseja realizar: ");
						escolhaLogin = scanner.nextByte();

						scanner.nextLine();
						switch (escolhaLogin) {
						   case 1:
							  do {
								 int escolhaLivro;
								 if (bibliotecario.getLimiteLivros() == 0) {
									System.out.println("Voce não pode fazer mais emprestimos.");
									System.out.println("Voce so pode pegar 2 livros emprestados ao mesmo tempo.");
									System.out.println("Voce atingiu o limite de livros maximo.");
									System.out.println("Devolva algum livro para  poder fazer pedir outros livros emprestados.");
									break;
								 }
								 if (bibliotecario.getMulta() != 0) {
									System.out.println("Você está com uma multa pendente no valor de R$" + bibliotecario.getMulta());
									System.out.println("Pague a multa antes de fazer outro emprestimo!");
									break;
								 }

								 System.out.print("TITULO: ");
								 titulo = scanner.nextLine();

								 Livro livro = Busca.buscarLivroPorNome(livros, titulo);
								 if (titulo.isEmpty()) {
									System.out.println("Titulo inválido!");
									System.out.println("Deseja continuar? ");
									System.out.println("1 - Sim.");
									System.out.println("2 - Não.");
									escolhaLivro = scanner.nextInt();
									scanner.nextLine();


									if (escolhaLivro == 2) {
									   break;
									}


								 } else if (livro == null) {


									System.out.println("O Livro nao presente no acervo.");
									System.out.println("Deseja continuar? ");
									System.out.println("1 - Sim.");
									System.out.println("2 - Não.");
									escolhaLivro = scanner.nextInt();
									scanner.nextLine();


									if (escolhaLivro == 2) {
									   break;
									}
								 } else {


									if (livro.getQtdDisponivel() == 0) {
									   System.out.println("Não foi possivel fazer o emprestimo desse livro.");
									   System.out.println("Não há nenhum livro disponivel.");


									   System.out.println("Deseja continuar? ");
									   System.out.println("1- Sim.");
									   System.out.println("2- Não.");
									   escolhaLivro = scanner.nextInt();
									   scanner.nextLine();


									   if (escolhaLivro == 2) {
										  break;
									   }
									} else if (Busca.buscarEmprestimoPorBibliotecarioETitulo(bibliotecario, livro, emprestimos) != null) {
									   System.out.println("Você já o fez o emprestimo desse livro.");
									   System.out.println("Deseja continuar? ");
									   System.out.println("1- Sim.");
									   System.out.println("2- Não.");
									   escolhaLivro = scanner.nextInt();
									   scanner.nextLine();


									   if (escolhaLivro == 2) {
										  break;
									   }


									} else {
									   dataEmprestimo = LocalDate.now();
									   dataLimiteDevolucao = LocalDate.now().plusDays(10);
									   Emprestimo emprestimo = new Emprestimo(bibliotecario, livro, dataEmprestimo, dataLimiteDevolucao);
									   emprestimos.add(emprestimo);
									   livro.setQtdDisponivel(livro.getQtdDisponivel() - 1);
									   bibliotecario.setLimiteLivros(bibliotecario.getLimiteLivros() - 1);
									   System.out.println("Emprestimo realizado com sucesso.\n");
									   break;
									}
								 }


							  } while (true);


							  break;
						   case 2:
							  System.out.println("Vendo livros disponiveis: ");
							  Exibicao.mostrarLivrosDisponiveis(livros);
							  break;
						   case 3:
							  System.out.println("Devolvendo Livro.");
							  Devolucao.devolverLivroBibliotecario(livros, bibliotecarios, emprestimos);
							  break;
						   case 4:
							  System.out.println("Renovando Livro.");
							  Renovar.renovarLivroBibliotecario(livros, bibliotecarios, emprestimos);
							  break;
						   case 5:
							  System.out.println("Vendo multas (Bibliotecário): ");
							  Exibicao.verMultasBibliotecario(livros, bibliotecarios, emprestimos);
							  break;
						   case 6:
							  Exibicao.dadosLivrosUsuario(emprestimos, email);
							  break;
						   case 7:
							  do {
								 System.out.print("MATRICULA: ");
								 matricula =scanner.nextLine().strip();
								 if (matricula.isEmpty()) {
									System.out.println("Insira uma matricula válida");
								 }
							  } while (matricula.isEmpty());
							  RedefinirSenha.redefinirSenhaBibliotecario(bibliotecarios, matricula);
							  break;
						   case 8:
							  System.out.println("1 - Aluno");
							  System.out.println("2 - Professor");
							  System.out.println("3 - Bibliotecario");
							  System.out.print("Digite uma opção: ");
							  opcao = scanner.nextByte();
							  scanner.nextLine();
							  if (opcao == 1) {
								 do {
									System.out.print("MATRICULA: ");
									matricula = scanner.nextLine().strip();
									if (matricula.isEmpty()) {
									   System.out.println("Informe uma matricula válida!");
									}
								 } while (matricula.isEmpty());
								 Cancelar.cancelarCadastroAluno(alunos, matricula);
							  } else if (opcao == 2) {
								 do {
									System.out.print("MATRICULA: ");
									matricula = scanner.nextLine().strip();
									if (matricula.isEmpty()) {
									   System.out.println("Informe uma matricula válida!");
									}
								 } while (matricula.isEmpty());
								 Cancelar.cancelarCadastroProfessor(professores, matricula);
							  } else if (opcao == 3) {
								 do {
									System.out.print("MATRICULA: ");
									matricula = scanner.nextLine().strip();
									if (matricula.isEmpty()) {
									   System.out.println("Informe uma matricula válida!");
									}
								 } while (matricula.isEmpty());
								 Cancelar.cancelarCadastroBibliotecario(bibliotecarios, matricula);
							  } else {
								 System.out.println("Desculpa, não entendi, digite uma das opções\n");
							  }
							  break;
						   case 9:
							  Exibicao.mostrarLivros(livros);
							  break;
						   case 10:
							  System.out.println("Insira as informações");
							  do {
								 System.out.print("TITULO: ");
								 titulo = scanner.nextLine().strip();
								 if (titulo.isEmpty()) {
									System.out.println("Informe um titulo válido!");
								 }
							  } while (titulo.isEmpty());

							  Livro tituloIgual = Busca.buscarLivroPorNome(livros, titulo);
							  if (tituloIgual != null) {
								 do {
									System.out.println("\nEsse titulo já foi cadastrado!");
									System.out.println("Insira um titulo válida!\n");

									do {
									   System.out.print("TITULO: ");
									   titulo = scanner.nextLine().strip();
									   if (titulo.isEmpty()) {
										  System.out.println("Informe um titulo válido!");
									   }
									} while (titulo.isEmpty());


									tituloIgual = Busca.buscarLivroPorNome(livros, titulo);
								 } while (tituloIgual != null);
							  }


							  do {
								 System.out.print("AUTOR: ");
								 autor = scanner.nextLine().strip();
								 if (autor.isEmpty()) {
									System.out.println("Informe um autor válido!");
								 }
							  } while (autor.isEmpty());


							  do {
								 System.out.print("EDITORA: ");
								 editora = scanner.nextLine().strip();
								 if (editora.isEmpty()) {
									System.out.println("Informe uma editora válido!");
								 }
							  } while (editora.isEmpty());


							  do {
								 System.out.print("ISBN: ");
								 isbn = scanner.nextLine().strip();
								 if (isbn.isEmpty()) {
									System.out.println("Informe um isbn válido!");
								 }
							  } while (isbn.isEmpty());


							  isbnIgual = Busca.isbnDuplicado(livros, isbn);


							  if (isbnIgual == 1) {
								 do {
									System.out.println("\nEsse isbn já foi cadastrado!");
									System.out.println("Insira um isbn válida!\n");
									do {
									   System.out.print("ISBN: ");
									   isbn = scanner.nextLine().strip();
									   if (isbn.isEmpty()) {
										  System.out.println("Informe um isbn válido!");
									   }
									} while (isbn.isEmpty());


									isbnIgual = Busca.isbnDuplicado(livros, isbn);
								 } while (isbnIgual == 1);
							  }


							  do {
								 System.out.print("ANO PUBLICAÇÃO: ");
								 anoPublicacao = scanner.nextLine().strip();
								 if (anoPublicacao.isEmpty()) {
									System.out.println("Informe um ano de publicação válido!");
								 }
							  } while (anoPublicacao.isEmpty());


							  do {
								 System.out.print("QUANTIDADE DISPONIVEL: ");
								 qtdDisponivel = scanner.nextInt();
								 if (qtdDisponivel < 1) {
									System.out.println("Informe uma quantidade válida válido!");


								 }
							  } while (qtdDisponivel < 1);


							  do {
								 scanner.nextLine();
								 System.out.print("CATEGORIA: ");
								 categoria = scanner.nextLine().strip();
								 if (categoria.isEmpty()) {
									System.out.println("Informe uma categoria válido!");
								 }
							  } while (categoria.isEmpty());


							  do {
								 System.out.print("LOCALIZACAO: ");
								 localizacao = scanner.nextLine().strip();
								 if (localizacao.isEmpty()) {
									System.out.println("Informe uma localização válido!");
								 }
							  } while (localizacao.isEmpty());


							  Livro livro = new Livro(titulo, autor, editora, isbn, anoPublicacao, qtdDisponivel, categoria, localizacao);
							  CadastroLivro.adicionarLivro(livros, livro);
							  System.out.println("Livro cadastrado com sucesso.");
							  break;
						   case 11:
							  do {
								 System.out.print("ISBN: ");
								 isbn = scanner.nextLine().strip();
								 if (isbn.isEmpty()) {
									System.out.println("Informe um isbn válido!");
								 }
							  } while (isbn.isEmpty());


							  Cancelar.removerLivro(livros, isbn);
							  break;
						   case 12:
							  System.out.println("Ver lista de emprestimos realizados.");
							  Exibicao.mostrarEmprestimos(emprestimos);
							  break;
						   case 13:
							  System.out.println("1 - Aluno");
							  System.out.println("2 - Professor");
							  System.out.println("3 - Bibliotecario");
							  System.out.print("Digite uma opção: ");
							  opcao = scanner.nextByte();
							  scanner.nextLine();
							  if (opcao == 1) {
								 Exibicao.mostrarAlunos(alunos);
							  } else if (opcao == 2) {
								 Exibicao.mostrarProfessores(professores);
							  } else if (opcao == 3) {
								 Exibicao.mostrarBibliotecarios(bibliotecarios);
							  } else {
								 System.out.println("Desculpa, não entendi, digite uma das opções\n");
							  }
							  break;
						   case 14:
							  tipo = 3;
							  Exibicao.dadosUsuario(alunos, professores, bibliotecarios, email, tipo);
							  break;
						   case 15:
							  System.out.println("Logout realizado com sucesso.");
							  break;
						   case 16:
							  System.out.print("Digite o título do livro que deseja alterar a quantidade: ");
							  String tituloAltera = scanner.nextLine();
							  Livro livroAltera = null;

							  for (Livro l : livros) {
								 if (l.getTitulo().equalsIgnoreCase(tituloAltera)) {
									livroAltera = l;
									break;
								 }
							  }

							  if (livroAltera == null) {
								 System.out.println("Livro não encontrado no acervo!");
								 break;
							  }

							  System.out.println("\nLivro encontrado: " + livroAltera.getTitulo());
							  System.out.println("Quantidade atual: " + livroAltera.getQtdDisponivel());
							  System.out.println("1 - Aumentar quantidade");
							  System.out.println("2 - Diminuir quantidade");
							  System.out.print("Escolha uma opção: ");
							  byte opcaoQtd = scanner.nextByte();
							  scanner.nextLine();

							  if (opcaoQtd == 1) {
								 System.out.print("Quantos exemplares deseja adicionar? ");
								 int qtdAdd = scanner.nextInt();
								 scanner.nextLine();

								 if (qtdAdd > 0) {
									livroAltera.setQtdDisponivel(livroAltera.getQtdDisponivel() + qtdAdd);
									System.out.println("Quantidade aumentada com sucesso!\n Nova quantidade: " + livroAltera.getQtdDisponivel());
								 } else {
									System.out.println("Valor inválido. Informe um número positivo.");
								 }

							  } else if (opcaoQtd == 2) {
								 System.out.print("Quantos exemplares deseja remover? ");
								 int qtdRemove = scanner.nextInt();
								 scanner.nextLine();


								 if (qtdRemove <= 0) {
									System.out.println("Valor inválido. Informe um número positivo.");
								 } else if (qtdRemove > livroAltera.getQtdDisponivel()) {
									System.out.println("Erro: não é possível remover mais exemplares do que há disponíveis!");
								 } else {
									livroAltera.setQtdDisponivel(livroAltera.getQtdDisponivel() - qtdRemove);
									System.out.println("Quantidade reduzida com sucesso!\n Nova quantidade: " + livroAltera.getQtdDisponivel());
								 }

							  } else {
								 System.out.println("Opção inválida!");
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
					 } while (escolha != 0 && escolhaLogin != 15);
				  }
			   }
		 }
	  } while (escolha != 0);
	  scanner.close();
   }
}