package application;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import service.CadastroLivro;
import service.CadastroUsuario;
import controller.Login;
import java.time.LocalDate;


public class AplicacaoBiblioteca {
    public static void main(String[] args) {
	   int escolha, escolhaCadastro, escolhaLogin, qtdDisponivel, opcao, tipo, matriculaIgual, telefoneIgual, cpfIgual, isbnIgual;
	   String nome="desconhecido" , cpf="desconhecido", email, telefone="desconhecido", matricula="desconhecido", senha;
	   String titulo, autor, editora, isbn, anoPublicacao, categoria, localizacao;
	   LocalDate dataEmprestimo,dataLimiteDevolucao;
	   //   LocalDate dataDevolucao;

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

				   if(escolhaCadastro == 1 || escolhaCadastro == 2 || escolhaCadastro == 3){

					  System.out.println("\nInsira suas informações:\n");
					  System.out.print("NOME: ");
					  nome = scanner.nextLine();

					  do {
						 if (nome.isEmpty()) {
							System.out.println("\nVocê precisa inserir um nome válido!\n");
							System.out.print("NOME: ");
							nome = scanner.nextLine();
						 }
					  } while (nome.isEmpty());
				   }
				   switch (escolhaCadastro) {
					  case 1:
						 System.out.print("CPF: ");
						 cpf = scanner.nextLine();

						 do {
							if (cpf.isEmpty()) {
							   System.out.println("Você precisa inserir um cpf válido!\n");
							   System.out.print("CPF: ");
							   cpf = scanner.nextLine();
							}
						 } while (cpf.isEmpty());

						 tipo = 1;
						 cpfIgual = Login.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);

						 if (cpfIgual == 1) {
							do {
							   System.out.println("\nEsse cpf já foi cadastrado!");
							   System.out.println("Insira um cpf válida!\n");
							   System.out.print("CPF: ");
							   cpf = scanner.nextLine();

							   do {
								  if (cpf.isEmpty()) {
									 System.out.println("Você precisa inserir um cpf válido!\n");
									 System.out.print("CPF: ");
									 cpf = scanner.nextLine();
								  }
							   } while (cpf.isEmpty());

							   cpfIgual = Login.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);
							} while (cpfIgual == 1);
						 }

						 System.out.print("TELEFONE: ");
						 telefone = scanner.nextLine();

						 do {
							if (telefone.isEmpty()) {
							   System.out.println("Você precisa inserir um telefone válido!\n");
							   System.out.print("TELEFONE: ");
							   telefone = scanner.nextLine();
							}
						 } while (telefone.isEmpty());

						 tipo = 1;
						 telefoneIgual = Login.telefoneDuplicado(alunos, professores, bibliotecarios, telefone, tipo);

						 if (telefoneIgual == 1) {
							do {
							   System.out.println("\nEsse telefone já foi cadastrado!");
							   System.out.println("Insira um telefone válida!\n");
							   System.out.print("TELEFONE: ");
							   telefone = scanner.nextLine();

							   do {
								  if (telefone.isEmpty()) {
									 System.out.println("Você precisa inserir um telefone válido!\n");
									 System.out.print("TELEFONE: ");
									 telefone = scanner.nextLine();
								  }
							   } while (telefone.isEmpty());

							   telefoneIgual = Login.matriculaDuplicada(alunos, professores, bibliotecarios, telefone, tipo);
							} while (telefoneIgual == 1);
						 }

						 System.out.print("MATRICULA: ");
						 matricula = scanner.nextLine();

						 do {
							if (matricula.isEmpty()) {
							   System.out.println("Você precisa inserir uma matricula válido!\n");
							   System.out.print("MATRICULA: ");
							   matricula = scanner.nextLine();
							}
						 } while (matricula.isEmpty());

						 tipo = 1;
						 matriculaIgual = Login.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);

						 if (matriculaIgual == 1) {
							do {
							   System.out.println("\nEssa matricula já pertence a um aluno!");
							   System.out.println("Insira uma matricula válida!\n");
							   System.out.print("MATRICULA: ");
							   matricula = scanner.nextLine();

							   do {
								  if (matricula.isEmpty()) {
									 System.out.println("Você precisa inserir uma matricula válido!\n");
									 System.out.print("MATRICULA: ");
									 matricula = scanner.nextLine();
								  }
							   } while (matricula.isEmpty());

							   matriculaIgual = Login.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);
							} while (matriculaIgual == 1);
						 }

						 do {
							System.out.print("EMAIL: ");
							email = scanner.nextLine();

							do {
							   if (email.isEmpty()) {
								  System.out.println("Você precisa inserir um email válido!\n");
								  System.out.print("EMAIL: ");
								  email = scanner.nextLine();
							   }
							} while (email.isEmpty());

							Aluno verificacaoEmail = Login.buscarAlunoPorEmail(alunos, email);

							if (verificacaoEmail == null) {
							   System.out.print("SENHA: ");
							   senha = scanner.nextLine();

							   do {
								  if (senha.isEmpty()) {
									 System.out.println("Você precisa inserir uma senha válido!\n");
									 System.out.print("SENHA: ");
									 senha = scanner.nextLine();
								  }
							   } while (senha.isEmpty());

							   System.out.print("CURSO: ");
							   String curso = scanner.nextLine();

							   do {
								  if (curso.isEmpty()) {
									 System.out.println("Você precisa inserir um curso válido!\n");
									 System.out.print("CURSO: ");
									 curso = scanner.nextLine();
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
						 System.out.print("CPF: ");
						 cpf = scanner.nextLine();

						 do {
							if (cpf.isEmpty()) {
							   System.out.println("Você precisa inserir um cpf válido!\n");
							   System.out.print("CPF: ");
							   cpf = scanner.nextLine();
							}
						 } while (cpf.isEmpty());

						 tipo = 2;
						 cpfIgual = Login.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);

						 if (cpfIgual == 1) {
							do {
							   System.out.println("\nEsse cpf já foi cadastrado!");
							   System.out.println("Insira um cpf válida!\n");
							   System.out.print("CPF: ");
							   cpf = scanner.nextLine();

							   do {
								  if (cpf.isEmpty()) {
									 System.out.println("Você precisa inserir um cpf válido!\n");
									 System.out.print("CPF: ");
									 cpf = scanner.nextLine();
								  }
							   } while (cpf.isEmpty());

							   cpfIgual = Login.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);
							} while (cpfIgual == 1);
						 }

						 System.out.print("TELEFONE: ");
						 telefone = scanner.nextLine();

						 do {
							if (telefone.isEmpty()) {
							   System.out.println("Você precisa inserir um telefone válido!\n");
							   System.out.print("TELEFONE: ");
							   telefone = scanner.nextLine();
							}
						 } while (telefone.isEmpty());

						 tipo = 2;
						 telefoneIgual = Login.telefoneDuplicado(alunos, professores, bibliotecarios, telefone, tipo);

						 if (telefoneIgual == 1) {
							do {
							   System.out.println("\nEsse telefone já foi cadastrado!");
							   System.out.println("Insira um telefone válida!\n");
							   System.out.print("TELEFONE: ");
							   telefone = scanner.nextLine();

							   do {
								  if (telefone.isEmpty()) {
									 System.out.println("Você precisa inserir um telefone válido!\n");
									 System.out.print("TELEFONE: ");
									 telefone = scanner.nextLine();
								  }
							   } while (telefone.isEmpty());

							   telefoneIgual = Login.matriculaDuplicada(alunos, professores, bibliotecarios, telefone, tipo);
							} while (telefoneIgual == 1);
						 }

						 System.out.print("MATRICULA: ");
						 matricula = scanner.nextLine();

						 do {
							if (matricula.isEmpty()) {
							   System.out.println("Você precisa inserir uma matricula válido!\n");
							   System.out.print("MATRICULA: ");
							   matricula = scanner.nextLine();
							}
						 } while (matricula.isEmpty());

						 tipo = 2;
						 matriculaIgual = Login.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);

						 if (matriculaIgual == 1) {
							do {
							   System.out.println("\nEssa matricula já pertence a um professor!");
							   System.out.println("Insira uma matricula válida!\n");
							   System.out.print("MATRICULA: ");
							   matricula = scanner.nextLine();

							   do {
								  if (matricula.isEmpty()) {
									 System.out.println("Você precisa inserir uma matricula válido!\n");
									 System.out.print("MATRICULA: ");
									 matricula = scanner.nextLine();
								  }
							   } while (matricula.isEmpty());

							   matriculaIgual = Login.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);
							} while (matriculaIgual == 1);
						 }

						 do {
							System.out.print("EMAIL: ");
							email = scanner.nextLine();

							do {
							   if (email.isEmpty()) {
								  System.out.println("Você precisa inserir um email válido!\n");
								  System.out.print("EMAIL: ");
								  email = scanner.nextLine();
							   }
							} while (email.isEmpty());

							Professor verificacaoEmail = Login.buscarProfessorPorEmail(professores, email);

							if (verificacaoEmail == null) {
							   System.out.print("SENHA: ");
							   senha = scanner.nextLine();

							   do {
								  if (senha.isEmpty()) {
									 System.out.println("Você precisa inserir uma senha válido!\n");
									 System.out.print("SENHA: ");
									 senha = scanner.nextLine();
								  }
							   } while (senha.isEmpty());

							   System.out.print("DEPARTAMENTO: ");
							   String departamento = scanner.nextLine();

							   do {
								  if (departamento.isEmpty()) {
									 System.out.println("Você precisa inserir um departamento válido!\n");
									 System.out.print("DEPARTAMENTO: ");
									 departamento = scanner.nextLine();
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
						 System.out.print("CPF: ");
						 cpf = scanner.nextLine();

						 do {
							if (cpf.isEmpty()) {
							   System.out.println("Você precisa inserir um cpf válido!\n");
							   System.out.print("CPF: ");
							   cpf = scanner.nextLine();
							}
						 } while (cpf.isEmpty());

						 tipo = 3;
						 cpfIgual = Login.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);

						 if (cpfIgual == 1) {
							do {
							   System.out.println("\nEsse cpf já foi cadastrado!");
							   System.out.println("Insira um cpf válida!\n");
							   System.out.print("CPF: ");
							   cpf = scanner.nextLine();

							   do {
								  if (cpf.isEmpty()) {
									 System.out.println("Você precisa inserir um cpf válido!\n");
									 System.out.print("CPF: ");
									 cpf = scanner.nextLine();
								  }
							   } while (cpf.isEmpty());

							   cpfIgual = Login.cpfDuplicado(alunos, professores, bibliotecarios, cpf, tipo);
							} while (cpfIgual == 1);
						 }

						 System.out.print("TELEFONE: ");
						 telefone = scanner.nextLine();

						 do {
							if (telefone.isEmpty()) {
							   System.out.println("Você precisa inserir um telefone válido!\n");
							   System.out.print("TELEFONE: ");
							   telefone = scanner.nextLine();
							}
						 } while (telefone.isEmpty());

						 tipo = 3;
						 telefoneIgual = Login.telefoneDuplicado(alunos, professores, bibliotecarios, telefone, tipo);

						 if (telefoneIgual == 1) {
							do {
							   System.out.println("\nEsse telefone já foi cadastrado!");
							   System.out.println("Insira um telefone válida!\n");
							   System.out.print("TELEFONE: ");
							   telefone = scanner.nextLine();

							   do {
								  if (telefone.isEmpty()) {
									 System.out.println("Você precisa inserir um telefone válido!\n");
									 System.out.print("TELEFONE: ");
									 telefone = scanner.nextLine();
								  }
							   } while (telefone.isEmpty());

							   telefoneIgual = Login.matriculaDuplicada(alunos, professores, bibliotecarios, telefone, tipo);
							} while (telefoneIgual == 1);
						 }

						 System.out.print("MATRICULA: ");
						 matricula = scanner.nextLine();

						 do {
							if (matricula.isEmpty()) {
							   System.out.println("Você precisa inserir uma matricula válido!\n");
							   System.out.print("MATRICULA: ");
							   matricula = scanner.nextLine();
							}
						 } while (matricula.isEmpty());

						 tipo = 3;
						 matriculaIgual = Login.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);

						 if (matriculaIgual == 1) {
							do {
							   System.out.println("\nEssa matricula já pertence a um bibliotecario!");
							   System.out.println("Insira uma matricula válida!\n");
							   System.out.print("MATRICULA: ");
							   matricula = scanner.nextLine();

							   do {
								  if (matricula.isEmpty()) {
									 System.out.println("Você precisa inserir uma matricula válido!\n");
									 System.out.print("MATRICULA: ");
									 matricula = scanner.nextLine();
								  }
							   } while (matricula.isEmpty());

							   matriculaIgual = Login.matriculaDuplicada(alunos, professores, bibliotecarios, matricula, tipo);
							} while (matriculaIgual == 1);
						 }

						 do {
							System.out.print("EMAIL: ");
							email = scanner.nextLine();

							do {
							   if (email.isEmpty()) {
								  System.out.println("Você precisa inserir um email válido!\n");
								  System.out.print("EMAIL: ");
								  email = scanner.nextLine();
							   }
							} while (email.isEmpty());

							Bibliotecario verificacaoEmail = Login.buscarBibliotecarioPorEmail(bibliotecarios, email);

							if (verificacaoEmail == null) {
							   System.out.print("SENHA: ");
							   senha = scanner.nextLine();

							   do {
								  if (senha.isEmpty()) {
									 System.out.println("Você precisa inserir uma senha válido!\n");
									 System.out.print("SENHA: ");
									 senha = scanner.nextLine();
								  }
							   } while (senha.isEmpty());

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

                    do {
                        if (email.isEmpty()) {
                            System.out.println("Você precisa inserir um email válido!\n");
                            System.out.print("EMAIL: ");
                            email = scanner.nextLine();
                        }
                    } while (email.isEmpty());

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

                            do {
                                if (senha.isEmpty()) {
                                    System.out.println("Informe uma senha válida!");
                                    System.out.print("SENHA: ");
                                    senha = scanner.nextLine();
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
                                resposta= scanner.nextInt();
                                scanner.nextLine();
                                if (resposta == 1) {
                                    System.out.print("MATRICULA: ");
                                    matricula = scanner.nextLine();

                                    do {
                                        if (matricula.isEmpty()) {
                                            System.out.println("Informe uma matricula válida!");
                                            System.out.print("MATRICULA: ");
                                            matricula = scanner.nextLine();
                                        }
                                    } while (matricula.isEmpty());

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
								System.out.println("7 - Redefinir senha.");
							    System.out.println("8 - Ver meus dados.");
								System.out.println("9 - Logout.");
								System.out.println("0 - Fechar app.");
								System.out.print("Qual opcao deseja realizar: ");
                                escolhaLogin = scanner.nextInt();

                                scanner.nextLine();
                                switch(escolhaLogin){
                                    case 1:
                                        do {
                                            int escolhaLivro;

                                            if(aluno.getLimiteLivros() == 0){
                                                System.out.println("Voce não pode fazer mais emprestimos.");
                                                System.out.println("Voce so pode pegar 2 livros emprestados ao mesmo tempo.");
                                                System.out.println("Voce atingiu o limite de livros maximo.");
                                                System.out.println("Devolva algum livro para  poder fazer pedir outros livros emprestados.");
                                                break;
                                            }
                                            if(aluno.getMulta()!=0){
                                                System.out.println("Voce esta com uma multa pendente no valor de "+ aluno.getMulta());
                                                System.out.println("Pague a multa antes de fazer outro emprestimo.");
                                                break;
                                            }
                                            System.out.print("TITULO: ");
                                            titulo = scanner.nextLine();
                                            Livro livro= Login.buscarLivroPorNome(livros, titulo);
                                            if (titulo.isEmpty()) {
                                                System.out.println("Titulo inválido!");
                                                System.out.println("Deseja continuar? ");
                                                System.out.println("1 - sim");
                                                System.out.println("2 - nao");
                                                escolhaLivro= scanner.nextInt();
                                                scanner.nextLine();

                                                if (escolhaLivro == 2){
                                                    break;
                                                }

                                            }

                                            else if (livro == null){

                                                System.out.println("O Livro nao presente no acervo.");
                                                System.out.println("Deseja continuar? ");
                                                System.out.println("1 - Sim.");
                                                System.out.println("2 - Não.");
											   	System.out.print("Digite aqui: ");
                                                escolhaLivro= scanner.nextInt();
                                                scanner.nextLine();

                                                if(escolhaLivro==2){
                                                    break;
                                                }
                                            }
                                            else{

                                                if(livro.getQtdDisponivel()==0){
                                                    System.out.println("Nao foi possivel fazer o emprestimo desse livro.");
                                                    System.out.println("Nao ha nenhum livro disponivel.");

                                                    System.out.println("Deseja continuar? ");
												    System.out.println("1 - Sim.");
												    System.out.println("2 - Não.");
												    System.out.print("Digite aqui: ");
                                                    escolhaLivro = scanner.nextInt();
                                                    scanner.nextLine();

                                                    if(escolhaLivro == 2){
                                                        break;
                                                    }
                                                }
                                                else if(Login.buscarEmprestimoPorAlunoETitulo(aluno,livro,emprestimos)!=null){
                                                    System.out.println("Voce ja fez  o emprestimo desse livro.");
                                                    System.out.println("Deseja continuar? ");
												    System.out.println("1 - Sim.");
												    System.out.println("2 - Não.");
												    System.out.print("Digite aqui: ");
                                                    escolhaLivro = scanner.nextInt();
                                                    scanner.nextLine();

                                                    if(escolhaLivro == 2){
                                                        break;
                                                    }

                                                }
                                                else{
                                                    dataEmprestimo=LocalDate.now();
                                                    dataLimiteDevolucao=LocalDate.now().plusDays(10);
                                                    Emprestimo emprestimo = new Emprestimo(aluno,livro,dataEmprestimo,dataLimiteDevolucao);
                                                    emprestimos.add(emprestimo);
                                                    livro.setQtdDisponivel(livro.getQtdDisponivel()-1);
                                                    aluno.setLimiteLivros(aluno.getLimiteLivros()-1);
                                                    System.out.println("Emprestimo realizado com sucesso.\n");
                                                    break;
                                                }
                                            }

                                        }while (true);
                                        break;
                                    case 2:
                                        System.out.println("Vendo livros disponiveis: ");
                                        Login.mostrarLivrosDisponiveis(livros);
                                        break;
                                    case 3:
                                        System.out.println("Devolvendo Livro.");
                                        Login.devolverLivroAluno(livros, alunos, emprestimos);
                                        break;
                                    case 4:
                                        System.out.println("Renovando Livro.");
                                        Login.renovarLivroAluno(livros, alunos, emprestimos);
                                        break;
                                    case 5:
                                        System.out.println("Vendo multas (Aluno): ");
                                        Login.verMultasAluno(livros, alunos, emprestimos);
                                        break;
								   case 6:
									  Login.dadosLivrosUsuario(emprestimos, email);
									  break;
                                    case 7:
									   System.out.println("MATRICULA: ");
									   matricula = scanner.nextLine();

									   do {
										  if (matricula.isEmpty()) {
											 System.out.println("Insira uma matricula válida");
											 System.out.println("MATRICULA: ");
											 matricula = scanner.nextLine();
										  }
									   } while (matricula.isEmpty());

									   Login.redefinirSenhaAluno(alunos, matricula);
									   break;
								   case 8:
									  tipo = 1;
									  Login.dadosUsuario(alunos, professores, bibliotecarios, email, tipo);
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
                            System.out.print("SENHA: ");
                            senha = scanner.nextLine();

                            do {
                                if (senha.isEmpty()) {
                                    System.out.println("Informe uma senha válida!");
                                    System.out.print("SENHA: ");
                                    senha = scanner.nextLine();
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
                                resposta= scanner.nextInt();
                                scanner.nextLine();
                                if (resposta == 1) {
                                    System.out.print("MATRICULA: ");
                                    matricula = scanner.nextLine();

                                    do {
                                        if (matricula.isEmpty()) {
                                            System.out.println("Informe uma matricula válida!");
                                            System.out.print("MATRICULA: ");
                                            matricula = scanner.nextLine();
                                        }
                                    } while (matricula.isEmpty());

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
							   System.out.println("7 - Redefinir senha.");
							   System.out.println("8 - Ver meus dados.");
							   System.out.println("9 - Logout.");
							   System.out.println("0 - Fechar app.");
							   System.out.print("Qual opcao deseja realizar: ");
							   escolhaLogin = scanner.nextInt();

                                scanner.nextLine();
                                switch (escolhaLogin){
                                    case 1:
                                        do {
                                            int escolhaLivro;
                                            if(professor.getLimiteLivros()==0){
                                                System.out.println("Voce não pode fazer mais emprestimos.");
                                                System.out.println("Voce so pode pegar 4 livros emprestados ao mesmo tempo.");
                                                System.out.println("Voce atingiu o limite de livros maximo.");
                                                System.out.println("Devolva algum livro para  poder fazer pedir outros livros emprestados.");
                                                break;
                                            }
                                            if(professor.getMulta()!=0){
                                                System.out.println("Voce esta com uma multa pendente no valor de "+ professor.getMulta());
                                                System.out.println("Pague a multa antes de fazer outro emprestimo.");
                                                break;
                                            }
                                            System.out.print("TITULO: ");
                                            titulo = scanner.nextLine();
                                            Livro livro= Login.buscarLivroPorNome(livros, titulo);
                                            if (titulo.isEmpty()) {
                                                System.out.println("Titulo inválido!");
                                                System.out.println("Deseja continuar? ");
                                                System.out.println("1- sim");
                                                System.out.println("2- nao");
                                                escolhaLivro= scanner.nextInt();
                                                scanner.nextLine();

                                                if(escolhaLivro==2){
                                                    break;
                                                }

                                            }

                                            else if(livro==null){

                                                System.out.println("O Livro nao presente no acervo.");
                                                System.out.println("Deseja continuar? ");
                                                System.out.println("1- sim");
                                                System.out.println("2- nao");
                                                escolhaLivro= scanner.nextInt();
                                                scanner.nextLine();

                                                if(escolhaLivro==2){
                                                    break;
                                                }

                                            }
                                            else{

                                                if(livro.getQtdDisponivel()==0){
                                                    System.out.println("Nao foi possivel fazer o emprestimo desse livro.");
                                                    System.out.println("Nao ha nenhum livro disponivel.");

                                                    System.out.println("Deseja continuar? ");
                                                    System.out.println("1- sim");
                                                    System.out.println("2- nao");
                                                    escolhaLivro= scanner.nextInt();
                                                    scanner.nextLine();

                                                    if(escolhaLivro==2){
                                                        break;
                                                    }
                                                }
                                                else if(Login.buscarEmprestimoPorProfessorETitulo(professor,livro,emprestimos)!=null){
                                                    System.out.println("Voce ja fez o emprestimo desse livro.");
                                                    System.out.println("Deseja continuar? ");
                                                    System.out.println("1- sim");
                                                    System.out.println("2- nao");
                                                    escolhaLivro= scanner.nextInt();
                                                    scanner.nextLine();

                                                    if(escolhaLivro==2){
                                                        break;
                                                    }

                                                }
                                                else{
                                                    dataEmprestimo=LocalDate.now();
                                                    dataLimiteDevolucao=LocalDate.now().plusDays(10);
                                                    Emprestimo emprestimo = new Emprestimo(professor,livro,dataEmprestimo,dataLimiteDevolucao);
                                                    emprestimos.add(emprestimo);
                                                    livro.setQtdDisponivel(livro.getQtdDisponivel()-1);
                                                    professor.setLimiteLivros(professor.getLimiteLivros()-1);
                                                    System.out.println("Emprestimo realizado com sucesso.\n");
                                                    break;
                                                }
                                            }

                                        } while (true);


                                        break;
                                    case 2:
                                        System.out.println("Vendo livros disponiveis: ");
                                        Login.mostrarLivrosDisponiveis(livros);
                                        break;
                                    case 3:
                                        System.out.println("Devolvendo Livro.");
                                        Login.devolverLivroProfessor(livros, professores, emprestimos);
                                        break;
                                    case 4:
                                        System.out.println("Renovando Livro.");
                                        Login.renovarLivroProfessor(livros, professores, emprestimos);
                                        break;
                                    case 5:
                                        System.out.println("Vendo multas (Professor): ");
                                        Login.verMultasProfessor(livros, professores, emprestimos);
                                        break;
                                    case 6:
									    Login.dadosLivrosUsuario(emprestimos, email);
                                        break;
                                    case 7:
									   System.out.println("MATRICULA: ");
									   matricula = scanner.nextLine();

									   do {
										  if (matricula.isEmpty()) {
											 System.out.println("Insira uma matricula válida");
											 System.out.println("MATRICULA: ");
											 matricula = scanner.nextLine();
										  }
									   } while (matricula.isEmpty());

									   Login.redefinirSenhaProfessor(professores, matricula);
									   break;
								   case 8:
									  tipo = 2;
									  Login.dadosUsuario(alunos, professores, bibliotecarios, email, tipo);
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
                            } while (escolha != 0  && escolhaLogin != 9);
                        }

                    } else if (bibliotecario != null) {
                        do {
                            System.out.print("SENHA: ");
                            senha = scanner.nextLine();

                            do {
                                if (senha.isEmpty()) {
                                    System.out.println("Informe uma senha válida!");
                                    System.out.print("SENHA: ");
                                    senha = scanner.nextLine();
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
                                resposta= scanner.nextInt();
                                scanner.nextLine();
                                if (resposta == 1) {
                                    System.out.print("MATRICULA: ");
                                    matricula = scanner.nextLine();

                                    do {
                                        if (matricula.isEmpty()) {
                                            System.out.println("Informe uma matricula válida!");
                                            System.out.print("MATRICULA: ");
                                            matricula = scanner.nextLine();
                                        }
                                    } while (matricula.isEmpty());

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
                                System.out.println("7 - Redefinir senha.");
                                System.out.println("8 - Cancelar Cadastro de Usuario.");
                                System.out.println("9 - Ver livros cadastrados.");
                                System.out.println("10 - Cadastrar livro.");
                                System.out.println("11 - Remover livro de acervo.");
                                System.out.println("12 - Ver lista de emprestimos realizados.");
                                System.out.println("13 - Ver Usuarios Cadastrados.");
							    System.out.println("14 - Ver meus dados.");
							    System.out.println("15 - Logout.");
                                System.out.println("0 - Fechar app.");
                                System.out.print("Qual opcao deseja realizar: ");
                                escolhaLogin = scanner.nextInt();

                                scanner.nextLine();
                                switch(escolhaLogin){
                                    case 1:
                                        do {
                                            int escolhaLivro;
                                            if(bibliotecario.getLimiteLivros() == 0){
                                                System.out.println("Voce não pode fazer mais emprestimos.");
                                                System.out.println("Voce so pode pegar 2 livros emprestados ao mesmo tempo.");
                                                System.out.println("Voce atingiu o limite de livros maximo.");
                                                System.out.println("Devolva algum livro para  poder fazer pedir outros livros emprestados.");
                                                break;
                                            }
                                            if(bibliotecario.getMulta()!=0){
                                                System.out.println("Voce esta com uma multa pendente no valor de "+ bibliotecario.getMulta());
                                                System.out.println("Pague a multa antes de fazer outro emprestimo.");
                                                break;
                                            }
                                            System.out.print("TITULO: ");
                                            titulo = scanner.nextLine();
                                            Livro livro= Login.buscarLivroPorNome(livros, titulo);
                                            if (titulo.isEmpty()) {
                                                System.out.println("Titulo inválido!");
                                                System.out.println("Deseja continuar? ");
                                                System.out.println("1- sim");
                                                System.out.println("2- nao");
                                                escolhaLivro= scanner.nextInt();
                                                scanner.nextLine();

                                                if(escolhaLivro==2){
                                                    break;
                                                }

                                            }

                                            else if(livro==null){

                                                System.out.println("O Livro nao presente no acervo.");
                                                System.out.println("Deseja continuar? ");
                                                System.out.println("1- sim");
                                                System.out.println("2- nao");
                                                escolhaLivro= scanner.nextInt();
                                                scanner.nextLine();

                                                if(escolhaLivro==2){
                                                    break;
                                                }
                                            }
                                            else{

                                                if(livro.getQtdDisponivel()==0){
                                                    System.out.println("Nao foi possivel fazer o emprestimo desse livro.");
                                                    System.out.println("Nao ha nenhum livro disponivel.");

                                                    System.out.println("Deseja continuar? ");
                                                    System.out.println("1- sim");
                                                    System.out.println("2- nao");
                                                    escolhaLivro= scanner.nextInt();
                                                    scanner.nextLine();

                                                    if(escolhaLivro==2){
                                                        break;
                                                    }
                                                }
                                                else if(Login.buscarEmprestimoPorBibliotecarioETitulo(bibliotecario,livro,emprestimos)!=null){
                                                    System.out.println("Voce ja o fez o emprestimo desse livro.");
                                                    System.out.println("Deseja continuar? ");
                                                    System.out.println("1- sim");
                                                    System.out.println("2- nao");
                                                    escolhaLivro= scanner.nextInt();
                                                    scanner.nextLine();

                                                    if(escolhaLivro==2){
                                                        break;
                                                    }

                                                }
                                                else{
                                                    dataEmprestimo=LocalDate.now();
                                                    dataLimiteDevolucao=LocalDate.now().plusDays(10);
                                                    Emprestimo emprestimo = new Emprestimo(bibliotecario,livro,dataEmprestimo,dataLimiteDevolucao);
                                                    emprestimos.add(emprestimo);
                                                    livro.setQtdDisponivel(livro.getQtdDisponivel()-1);
                                                    bibliotecario.setLimiteLivros(bibliotecario.getLimiteLivros()-1);
                                                    System.out.println("Emprestimo realizado com sucesso.\n");
                                                    break;
                                                }
                                            }

                                        } while (true);

                                        break;
                                    case 2:
                                        System.out.println("Vendo livros disponiveis: ");
                                        Login.mostrarLivrosDisponiveis(livros);
                                        break;
                                    case 3:
                                        System.out.println("Devolvendo Livro.");
                                        Login.devolverLivroBibliotecario(livros, bibliotecarios, emprestimos);
                                        break;
                                    case 4:
                                        System.out.println("Renovando Livro.");
                                        Login.renovarLivroBibliotecario(livros, bibliotecarios, emprestimos);
                                        break;
                                    case 5:
                                        System.out.println("Vendo multas (Bibliotecário): ");
                                        Login.verMultasBibliotecario(livros, bibliotecarios, emprestimos);
                                        break;
                                    case 6:
 									    Login.dadosLivrosUsuario(emprestimos, email);
                                        break;
                                    case 7:
									   System.out.println("MATRICULA: ");
									   matricula = scanner.nextLine();

									   do {
										  if (matricula.isEmpty()) {
											 System.out.println("Insira uma matricula válida");
											 System.out.println("MATRICULA: ");
											 matricula = scanner.nextLine();
										  }
									   } while (matricula.isEmpty());

									   Login.redefinirSenhaBibliotecario(bibliotecarios, matricula);
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

                                            do {
                                                if (matricula.isEmpty()) {
                                                    System.out.println("Informe uma matricula válida!");
                                                    System.out.print("MATRICULA: ");
                                                    matricula = scanner.nextLine();
                                                }
                                            } while (matricula.isEmpty());

                                            Login.cancelarCadastroAluno(alunos, matricula);
                                        } else if (opcao == 2) {
                                            System.out.print("MATRICULA: ");
                                            matricula = scanner.nextLine();

                                            do {
                                                if (matricula.isEmpty()) {
                                                    System.out.println("Informe uma matricula válida!");
                                                    System.out.print("MATRICULA: ");
                                                    matricula = scanner.nextLine();
                                                }
                                            } while (matricula.isEmpty());

                                            Login.cancelarCadastroProfessor(professores, matricula);
                                        } else if (opcao == 3) {
                                            System.out.print("MATRICULA: ");
                                            matricula = scanner.nextLine();

                                            do {
                                                if (matricula.isEmpty()) {
                                                    System.out.println("Informe uma matricula válida!");
                                                    System.out.print("MATRICULA: ");
                                                    matricula = scanner.nextLine();
                                                }
                                            } while (matricula.isEmpty());

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

                                        do {
                                            if (titulo.isEmpty()) {
                                                System.out.println("Informe um titulo válido!");
                                                System.out.print("TITULO: ");
                                                titulo = scanner.nextLine();
                                            }
                                        } while (titulo.isEmpty());

										Livro tituloIgual = Login.buscarLivroPorNome(livros, titulo);

										if (tituloIgual != null) {
										   do {
											  System.out.println("\nEsse titulo já foi cadastrado!");
											  System.out.println("Insira um titulo válida!\n");
											  System.out.print("TITULO: ");
											  titulo = scanner.nextLine();

											  do {
												 if (titulo.isEmpty()) {
													System.out.println("Informe um titulo válido!");
													System.out.print("TITULO: ");
													titulo = scanner.nextLine();
												 }
											  } while (titulo.isEmpty());

											  tituloIgual = Login.buscarLivroPorNome(livros, titulo);
										   } while (tituloIgual != null);
										}

                                        System.out.print("AUTOR: ");
                                        autor = scanner.nextLine();

                                        do {
                                            if (autor.isEmpty()) {
                                                System.out.println("Informe um autor válido!");
                                                System.out.print("AUTOR: ");
                                                autor = scanner.nextLine();
                                            }
                                        } while (autor.isEmpty());

                                        System.out.print("EDITORA: ");
                                        editora = scanner.nextLine();

                                        do {
                                            if (editora.isEmpty()) {
                                                System.out.println("Informe uma editora válido!");
                                                System.out.print("EDITORA: ");
                                                editora = scanner.nextLine();
                                            }
                                        } while (editora.isEmpty());

                                        System.out.print("ISBN: ");
                                        isbn = scanner.nextLine();

                                        do {
                                            if (isbn.isEmpty()) {
                                                System.out.println("Informe um isbn válido!");
                                                System.out.print("ISBN: ");
                                                isbn = scanner.nextLine();
                                            }
                                        } while (isbn.isEmpty());

										isbnIgual = Login.isbnDuplicado(livros, isbn);

									   if (isbnIgual == 1) {
										  do {
											 System.out.println("\nEsse isbn já foi cadastrado!");
											 System.out.println("Insira um isbn válida!\n");
											 System.out.print("ISBN: ");
											 isbn = scanner.nextLine();

											 do {
												if (isbn.isEmpty()) {
												   System.out.println("Informe um isbn válido!");
												   System.out.print("ISBN: ");
												   isbn = scanner.nextLine();
												}
											 } while (isbn.isEmpty());

											 isbnIgual = Login.isbnDuplicado(livros, isbn);
										  } while (isbnIgual == 1);
									   }

                                        System.out.print("ANO PUBLICAÇÃO: ");
                                        anoPublicacao = scanner.nextLine();

                                        do {
                                            if (anoPublicacao.isEmpty()) {
                                                System.out.println("Informe um ano de publicação válido!");
                                                System.out.print("ANO PUBLICAÇÃO: ");
                                                anoPublicacao = scanner.nextLine();
                                            }
                                        } while (anoPublicacao.isEmpty());

                                        System.out.print("QUANTIDADE DISPONIVEL: ");
                                        qtdDisponivel = scanner.nextInt();

                                        do {
                                            if (qtdDisponivel < 1) {
                                                System.out.println("Informe uma quantidade válida válido!");
                                                System.out.print("QUANTIDADE DISPONIVEL: ");
                                                qtdDisponivel = scanner.nextInt();
                                            }
                                        } while (qtdDisponivel < 1);

                                        scanner.nextLine();
                                        System.out.print("CATEGORIA: ");
                                        categoria = scanner.nextLine();

                                        do {
                                            if (categoria.isEmpty()) {
                                                System.out.println("Informe uma categoria válido!");
                                                System.out.print("CATEGORIA: ");
                                                categoria = scanner.nextLine();
                                            }
                                        } while (categoria.isEmpty());

                                        System.out.print("LOCALIZACAO: ");
                                        localizacao = scanner.nextLine();

                                        do {
                                            if (localizacao.isEmpty()) {
                                                System.out.println("Informe uma localização válido!");
                                                System.out.print("LOCALIZAÇÃO: ");
                                                localizacao = scanner.nextLine();
                                            }
                                        } while (localizacao.isEmpty());

                                        Livro livro = new Livro(titulo, autor, editora, isbn, anoPublicacao, qtdDisponivel, categoria, localizacao);
                                        CadastroLivro.adicionarLivro(livros, livro);
                                        System.out.println("Livro cadastrado com sucesso.");
                                        break;
                                    case 11:
                                        System.out.print("ISBN: ");
                                        isbn = scanner.nextLine();

                                        do {
                                            if (isbn.isEmpty()) {
                                                System.out.println("Informe um isbn válido!");
                                                System.out.print("ISBN: ");
                                                isbn = scanner.nextLine();
                                            }
                                        } while (isbn.isEmpty());

                                        Login.removerLivro(livros, isbn);
                                        break;
                                    case 12:
                                        System.out.println("Ver lista de emprestimos realizados.");
										Login.mostrarEmprestimos(emprestimos);
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
								   case 14:
									  tipo = 3;
									  Login.dadosUsuario(alunos, professores, bibliotecarios, email, tipo);
									  break;
								   case 15:
									  System.out.println("Logout realizado com sucesso.");
									  break;
                                    default:
                                        System.out.println("Opcao invalida.");
                                        break;
                                }
                            } while (escolha != 0 && escolhaLogin != 15);
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
