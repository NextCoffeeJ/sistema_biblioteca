package controller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public final class Login {

   private Login(){

   }
   public static Aluno buscarAlunoPorEmail (ArrayList<Aluno> listaAlunos, String email) {
	  for (Aluno aluno : listaAlunos) {
		 if (aluno.getEmail().equalsIgnoreCase(email)) {
			return aluno;
		 }
	  }
	  return null;
   }

   public static Professor buscarProfessorPorEmail (ArrayList<Professor> listaProfessores, String email){
	  for(Professor professor : listaProfessores){
		 if(professor.getEmail().equalsIgnoreCase(email)){
			return professor;
		 }
	  }
	  return null;
   }

   public static Bibliotecario buscarBibliotecarioPorEmail (ArrayList<Bibliotecario> listaBibliotecarios, String email) {
	  for (Bibliotecario bibliotecario : listaBibliotecarios) {
		 if (bibliotecario.getEmail().equalsIgnoreCase(email)) {
			return bibliotecario;
		 }
	  }
	  return null;
   }

   public static int emailDuplicadoAluno (ArrayList<Aluno> listaAlunos, String email){
	  for (Aluno aluno : listaAlunos) {
		 if (aluno.getEmail().equalsIgnoreCase(email)) {
			return 1;
		 }
	  }
	  return 0;
   }

   public static int emailDuplicadoProfessor (ArrayList<Professor> listaProfessor, String email){
	  for (Professor professor : listaProfessor) {
		 if (professor.getEmail().equalsIgnoreCase(email)) {
			return 1;
		 }
	  }
	  return 0;
   }


   public static int emailDuplicadoBibliotecario (ArrayList<Bibliotecario> listaBibliotecario, String email){
	  for (Bibliotecario bibliotecario : listaBibliotecario) {
		 if (bibliotecario.getEmail().equalsIgnoreCase(email)) {
			return 1;
		 }
	  }
	  return 0;
   }

   public static void emprestimoLivroAluno(ArrayList<Livro> listaLivros, String titulo, ArrayList<Aluno> listaAluno, String email) {
	  Scanner scanner = new Scanner(System.in);

	  System.out.print("Confirme seu EMAIL: ");
	  email = scanner.nextLine();
	  Aluno aluno = Login.buscarAlunoPorEmail(listaAluno, email);

	   if (aluno == null) {
		  System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
		  do {
			 int op;
			 System.out.println("1 - Inserir novamente.");
			 System.out.println("2 - Retornar ao menu anterior.");
			 System.out.print("Digite aqui: ");
			 op = scanner.nextInt();

			 scanner.nextLine();
			 if (op == 1) {
				System.out.print("\nConfirme seu EMAIL: ");
				email = scanner.nextLine();

				aluno = Login.buscarAlunoPorEmail(listaAluno, email);
				if (aluno == null) {
				   System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
				} else {
				   break;
				}
			 } else  if (op == 2) {
				return;
			 } else {
				System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
			 }
		  } while (true);
	   }

	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			if (livro.getQtdDisponivel() > 0) {
			   aluno.setLimiteLivros(aluno.getLimiteLivros()-1);
			   if (aluno.getLimiteLivros() < 0) {
				  System.out.println("Você atingiu a quantidade limite de livros, que você pode pegar!");
			   } else {
				  livro.setQtdDisponivel(livro.getQtdDisponivel()-1);
				  LocalDate hoje = LocalDate.now();
				  LocalDate dataLimite = hoje.plusDays(10);

				  Emprestimo emprestimo = new Emprestimo(aluno, livro, hoje, dataLimite);
				  System.out.println("\nData de emprestimo: " + emprestimo.getDataEmprestimo());
				  System.out.println("Data de devolução: " + emprestimo.getDataLimiteDevolucao());
				  System.out.println("Aproveite a leitura!");
				  System.out.println("A quantidade de livros que você ainda pode pegar é de: " + aluno.getLimiteLivros());
			   }
			} else {
			   System.out.println("Desculpa. Infelizmente todos exemplares estão emprestados no momento!");
			}
		 } else {
			System.out.println("Livro não encontrado");
			do {
			   System.out.println("Deseja fazer uma nova consulta?");
			   System.out.println("1 - Sim");
			   System.out.println("2 - Não");
			   System.out.print("Digite aqui: ");
			   int op = scanner.nextInt();

			   scanner.nextLine();
			   if (op == 1) {
				  System.out.print("TITULO: ");
				  titulo = scanner.nextLine();
				  Login.emprestimoLivroAluno(listaLivros, titulo, listaAluno, email);
				  break;
			   } else if (op == 2) {
				  break;
			   } else {
				  System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			   }
			} while (true);
		 }
	  }
   }

   public static void emprestimoLivroProfessor(ArrayList<Livro> listaLivros, String titulo, ArrayList<Professor> listaProfessor, String email) {
	  Scanner scanner = new Scanner(System.in);

	  System.out.print("Confirme seu EMAIL: ");
	  email = scanner.nextLine();
	  Professor professor = Login.buscarProfessorPorEmail(listaProfessor, email);

	  if (professor == null) {
		 System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
		 do {
			int op;
			System.out.println("1 - Inserir novamente.");
			System.out.println("2 - Retornar ao menu anterior.");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();

			scanner.nextLine();
			if (op == 1) {
			   System.out.print("\nConfirme seu EMAIL: ");
			   email = scanner.nextLine();

			   professor = Login.buscarProfessorPorEmail(listaProfessor, email);
			   if (professor == null) {
				  System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			   } else {
				  break;
			   }
			} else  if (op == 2) {
			   return;
			} else {
			   System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
			}
		 } while (true);
	  }

	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			if (livro.getQtdDisponivel() > 0) {
			   professor.setLimiteLivros(professor.getLimiteLivros()-1);
			   if (professor.getLimiteLivros() < 0) {
				  System.out.println("Você atingiu a quantidade limite de livros, que você pode pegar!");
			   } else {
				  livro.setQtdDisponivel(livro.getQtdDisponivel()-1);
				  LocalDate hoje = LocalDate.now();
				  LocalDate dataLimite = hoje.plusDays(10);

				  Emprestimo emprestimo = new Emprestimo(professor, livro, hoje, dataLimite);
				  System.out.println("\nData de emprestimo: " + emprestimo.getDataEmprestimo());
				  System.out.println("Data de devolução: " + emprestimo.getDataLimiteDevolucao());
				  System.out.println("Aproveite a leitura!");
				  System.out.println("A quantidade de livros que você ainda pode pegar é de: " + professor.getLimiteLivros());
			   }
			} else {
			   System.out.println("Desculpa. Infelizmente todos exemplares estão emprestados no momento!");
			}
		 } else {
			System.out.println("Livro não encontrado");
			do {
			   System.out.println("Deseja fazer uma nova consulta?");
			   System.out.println("1 - Sim");
			   System.out.println("2 - Não");
			   System.out.print("Digite aqui: ");
			   int op = scanner.nextInt();

			   scanner.nextLine();
			   if (op == 1) {
				  System.out.print("TITULO: ");
				  titulo = scanner.nextLine();
				  Login.emprestimoLivroProfessor(listaLivros, titulo, listaProfessor, email);
				  break;
			   } else if (op == 2) {
				  break;
			   } else {
				  System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			   }
			} while (true);
		 }
	  }
   }

   public static void emprestimoLivroBibliotecario(ArrayList<Livro> listaLivros, String titulo, ArrayList<Bibliotecario> listaBibliotecario, String email) {
	  Scanner scanner = new Scanner(System.in);

	  System.out.print("Confirme seu EMAIL: ");
	  email = scanner.nextLine();
	  Bibliotecario bibliotecario = Login.buscarBibliotecarioPorEmail(listaBibliotecario, email);

	  if (bibliotecario == null) {
		 System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
		 do {
			int op;
			System.out.println("1 - Inserir novamente.");
			System.out.println("2 - Retornar ao menu anterior.");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();

			scanner.nextLine();
			if (op == 1) {
			   System.out.print("\nConfirme seu EMAIL: ");
			   email = scanner.nextLine();

			   bibliotecario = Login.buscarBibliotecarioPorEmail(listaBibliotecario, email);
			   if (bibliotecario == null) {
				  System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			   } else {
				  break;
			   }
			} else  if (op == 2) {
			   return;
			} else {
			   System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
			}
		 } while (true);
	  }

	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			if (livro.getQtdDisponivel() > 0) {
			   bibliotecario.setLimiteLivros(bibliotecario.getLimiteLivros()-1);
			   if (bibliotecario.getLimiteLivros() < 0) {
				  System.out.println("Você atingiu a quantidade limite de livros, que você pode pegar!");
			   } else {
				  livro.setQtdDisponivel(livro.getQtdDisponivel()-1);
				  LocalDate hoje = LocalDate.now();
				  LocalDate dataLimite = hoje.plusDays(10);

				  Emprestimo emprestimo = new Emprestimo(bibliotecario, livro, hoje, dataLimite);
				  System.out.println("\nData de emprestimo: " + emprestimo.getDataEmprestimo());
				  System.out.println("Data de devolução: " + emprestimo.getDataLimiteDevolucao());
				  System.out.println("Aproveite a leitura!");
				  System.out.println("A quantidade de livros que você ainda pode pegar é de: " + bibliotecario.getLimiteLivros());
			   }
			} else {
			   System.out.println("Desculpa. Infelizmente todos exemplares estão emprestados no momento!");
			}
		 } else {
			System.out.println("Livro não encontrado");
			do {
			   System.out.println("Deseja fazer uma nova consulta?");
			   System.out.println("1 - Sim");
			   System.out.println("2 - Não");
			   System.out.print("Digite aqui: ");
			   int op = scanner.nextInt();

			   scanner.nextLine();
			   if (op == 1) {
				  System.out.print("TITULO: ");
				  titulo = scanner.nextLine();
				  Login.emprestimoLivroBibliotecario(listaLivros, titulo, listaBibliotecario, email);
				  break;
			   } else if (op == 2) {
				  break;
			   } else {
				  System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			   }
			} while (true);
		 }
	  }
   }

   public static void mostrarLivros (ArrayList<Livro> listaLivros) {
	  if (listaLivros.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }
	  for (Livro livro : listaLivros) {
		 System.out.println(livro.getTitulo());
	  }
   }


   public static void mostrarAlunos (ArrayList<Aluno> listaAlunos){
	  if (listaAlunos.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }
	  for (Aluno aluno : listaAlunos) {
		 System.out.println("Aluno: " + aluno.getNome());
	  }
   }

   public static void mostrarProfessores (ArrayList<Professor> listaProfessor){
	  if (listaProfessor.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }
	  for (Professor professor : listaProfessor) {
		 System.out.println("Professor: " + professor.getNome());
	  }
   }

   public static void mostrarBibliotecarios (ArrayList<Bibliotecario> listaBibliotecario){
	  if (listaBibliotecario.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }
	  for (Bibliotecario bibliotecario : listaBibliotecario) {
		 System.out.println("Bibliotecario: " + bibliotecario.getNome());
	  }
   }

   public static void cancelarCadastroAluno (ArrayList<Aluno> listaAluno, String matricula) {
	  if (listaAluno.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }
	  Aluno removerAluno = null;

	  for (Aluno aluno : listaAluno) {
		 if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
			removerAluno = aluno;
			break;
		 }
	  }

	  if (removerAluno != null) {
		 listaAluno.remove(removerAluno);
		 System.out.println("Aluno, " + removerAluno.getNome() + ", removido com sucesso!");
	  } else {
		 System.out.println("Aluno não encontrado!");
	  }
   }

   public static void cancelarCadastroProfessor (ArrayList<Professor> listaProfessores, String matricula) {
	  if (listaProfessores.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }
	  Professor removerProfessor = null;

	  for (Professor professor : listaProfessores) {
		 if (professor.getMatricula().equalsIgnoreCase(matricula)) {
			removerProfessor = professor;
		 }
	  }

	  if (removerProfessor != null) {
		 listaProfessores.remove(removerProfessor);
		 System.out.println("Professor, " + removerProfessor.getNome() + ", removido com sucesso!");
	  } else {
		 System.out.println("Professor não encontrado");
	  }
   }

   public static void cancelarCadastroBibliotecario (ArrayList<Bibliotecario> listaBibliotecario, String matricula) {
	  if (listaBibliotecario.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }
	  Bibliotecario removerBibliotecario = null;

	  for (Bibliotecario bibliotecario : listaBibliotecario) {
		 if (bibliotecario.getMatricula().equalsIgnoreCase(matricula)) {
			removerBibliotecario = bibliotecario;
		 }
	  }

	  if (removerBibliotecario != null) {
		 listaBibliotecario.remove(removerBibliotecario);
		 System.out.println("Bibliotecario, " + removerBibliotecario.getNome() + ", removido com sucesso!");
	  } else {
		 System.out.println("Bibliotecario não encontrado");
	  }
   }


   public static void removerLivro (ArrayList<Livro> listaLivro, String isbn) {
	  if (listaLivro.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }
	  Livro removerLivro = null;

	  for (Livro livro : listaLivro) {
		 if (livro.getIsbn().equalsIgnoreCase(isbn)) {
			removerLivro = livro;
			break;
		 }
	  }

	  if (removerLivro != null) {
		 listaLivro.remove(removerLivro);
		 System.out.println("Livro, " + removerLivro.getTitulo() + ", removido com sucesso!");
	  } else {
		 System.out.println("Livro não encontrado!");
	  }
   }

   public static void redefinirSenhaAluno (ArrayList<Aluno> listaAlunos, String matricula) {
	  Aluno novaSenha = null;
	  Scanner scanner = new Scanner(System.in);

	  for (Aluno aluno : listaAlunos) {
		 if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = aluno;
			break;
		 }
	  }

	  if (novaSenha != null) {
		 System.out.print("Digite uma nova nova: ");
		 String senha = scanner.nextLine();
		 novaSenha.setSenha(senha);
		 System.out.println("Senha redefinida com sucesso!");
	  } else {
		 int op;
		 System.out.println("Usuario não encontrado");
		 do {
			System.out.println("Deseja tentar novamente?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();

			scanner.nextLine();
			if (op == 1) {
			   System.out.print("MATRICULA: ");
			   matricula = scanner.nextLine();
			   Login.redefinirSenhaAluno(listaAlunos, matricula);
			   break;
			} else if (op == 2) {
			   System.out.println("Até mais");
			} else {
			   System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			}

		 } while (op != 2);
	  }
   }

   public static void redefinirSenhaProfessor (ArrayList<Professor> listaProfessores, String matricula) {
	  Professor novaSenha = null;
	  Scanner scanner = new Scanner(System.in);

	  for (Professor professor : listaProfessores) {
		 if (professor.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = professor;
		 }
	  }

	  if (novaSenha != null) {
		 System.out.print("Digite uma nova nova: ");
		 String senha = scanner.nextLine();
		 novaSenha.setSenha(senha);
		 System.out.println("Senha redefinida com sucesso!");
	  } else {
		 int op;
		 System.out.println("Usuario não encontrado");
		 do {
			System.out.println("Deseja tentar novamente?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();

			scanner.nextLine();
			if (op == 1) {
			   System.out.print("MATRICULA: ");
			   matricula = scanner.nextLine();
			   Login.redefinirSenhaProfessor(listaProfessores, matricula);
			   break;
			} else if (op == 2) {
			   System.out.println("Até mais");
			} else {
			   System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			}
		 } while (op != 2);
	  }
   }

   public static void redefinirSenhaBibliotecario (ArrayList<Bibliotecario> listaBibliotecarios, String matricula) {
	  Bibliotecario novaSenha = null;
	  Scanner scanner = new Scanner(System.in);

	  for (Bibliotecario bibliotecario : listaBibliotecarios) {
		 if (bibliotecario.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = bibliotecario;
		 }
	  }

	  if (novaSenha != null) {
		 System.out.print("Digite uma nova nova: ");
		 String senha = scanner.nextLine();
		 novaSenha.setSenha(senha);
		 System.out.println("Senha redefinida com sucesso!");
	  } else {
		 int op;
		 System.out.println("Usuario não encontrado");
		 do {
			System.out.println("Deseja tentar novamente?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();

			scanner.nextLine();
			if (op == 1) {
			   System.out.print("MATRICULA: ");
			   matricula = scanner.nextLine();
			   Login.redefinirSenhaBibliotecario(listaBibliotecarios, matricula);
			   break;
			} else if (op == 2) {
			   System.out.println("Até mais");
			} else {
			   System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			}
		 } while (op != 2);
	  }
   }
}