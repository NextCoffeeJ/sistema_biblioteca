package controller;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Renovar extends Login {
   private static final Scanner scanner = new Scanner(System.in);


   public static void renovarLivroAluno (ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAlunos, ArrayList<Emprestimo> listaEmprestimos) {

	  String email, titulo;

	  do {
		 System.out.print("Confirme seu EMAIL: ");
		 email = scanner.nextLine();
		 if (email.isEmpty()) {
			System.out.println("Você precisa inserir um email válido!\n");
		 }
	  } while (email.isEmpty());

	  Aluno aluno = Busca.buscarAlunoPorEmail(listaAlunos, email);

	  if (aluno == null) {
		 System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
	  }
	  while (aluno == null) {
		 int op;
		 System.out.println("1 - Inserir novamente.");
		 System.out.println("2 - Retornar ao menu anterior.");
		 System.out.print("Digite aqui: ");
		 op = scanner.nextInt();
		 scanner.nextLine();

		 if (op == 1) {
			do {
			   System.out.print("Confirme seu EMAIL: ");
			   email = scanner.nextLine();
			   if (email.isEmpty()) {
				  System.out.println("Você precisa inserir um email válido!\n");
			   }
			} while (email.isEmpty());
			aluno = Busca.buscarAlunoPorEmail(listaAlunos, email);
			if (aluno == null) {
			   System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			} else {
			   break;
			}
		 } else if (op == 2) {
			return;
		 } else {
			System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
		 }
	  }

	  System.out.print("\nDigite o título do livro que deseja renovar: ");
	  titulo = scanner.nextLine();

	  Livro livro = Busca.buscarLivroPorNome(listaLivros, titulo);
	  if (livro == null) {
		 System.out.println("Livro não disponível no acervo!");
		 return;
	  }

	  Emprestimo emprestimo = Busca.buscarEmprestimoPorAlunoETitulo(aluno, livro, listaEmprestimos);
	  if (emprestimo == null) {
		 System.out.println("Você não possui este livro emprestado!");
		 return;
	  }

	  emprestimo.renovar();
	  System.out.println("Livro renovado com sucesso! Novo prazo de entrega: " + emprestimo.getDataLimiteDevolucao() + "dias.");
   }

   public static void renovarLivroProfessor (ArrayList<Livro> listaLivros, ArrayList<Professor> listaProfessores, ArrayList<Emprestimo> listaEmprestimos) {

	  String email, titulo;

	  do {
		 System.out.print("Confirme seu EMAIL: ");
		 email = scanner.nextLine();
		 if (email.isEmpty()) {
			System.out.println("Você precisa inserir um email válido!\n");
		 }
	  } while (email.isEmpty());

	  Professor professor = Busca.buscarProfessorPorEmail(listaProfessores, email);

	  if (professor == null) {
		 System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
	  }
	  while (professor == null) {
		 int op;
		 System.out.println("1 - Inserir novamente.");
		 System.out.println("2 - Retornar ao menu anterior.");
		 System.out.print("Digite aqui: ");
		 op = scanner.nextInt();
		 scanner.nextLine();

		 if (op == 1) {
			do {
			   System.out.print("Confirme seu EMAIL: ");
			   email = scanner.nextLine();
			   if (email.isEmpty()) {
				  System.out.println("Você precisa inserir um email válido!\n");
			   }
			} while (email.isEmpty());
			professor = Busca.buscarProfessorPorEmail(listaProfessores, email);
			if (professor == null) {
			   System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			} else {
			   break;
			}
		 } else if (op == 2) {
			return;
		 } else {
			System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
		 }
	  }

	  System.out.print("\nDigite o título do livro que deseja renovar");
	  titulo = scanner.nextLine();

	  Livro livro = Busca.buscarLivroPorNome(listaLivros, titulo);
	  if (livro == null) {
		 System.out.println("Livro não disponível no acervo!");
		 return;
	  }

	  Emprestimo emprestimo = Busca.buscarEmprestimoPorProfessorETitulo(professor, livro, listaEmprestimos);
	  if (emprestimo == null) {
		 System.out.println("Você não possui este livro emprestado!");
		 return;
	  }

	  emprestimo.renovar();
	  System.out.println("Livro renovado com sucesso! Novo prazo de entrega: " + emprestimo.getDataLimiteDevolucao() + "dias.");
   }

   public static void renovarLivroBibliotecario (ArrayList<Livro> listaLivros, ArrayList<Bibliotecario> listaBibliotecarios, ArrayList<Emprestimo> listaEmprestimos) {

	  String email, titulo;

	  do {
		 System.out.print("Confirme seu EMAIL: ");
		 email = scanner.nextLine();
		 if (email.isEmpty()) {
			System.out.println("Você precisa inserir um email válido!\n");
		 }
	  } while (email.isEmpty());

	  Bibliotecario bibliotecario = Busca.buscarBibliotecarioPorEmail(listaBibliotecarios, email);

	  if (bibliotecario == null) {
		 System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
	  }
	  while (bibliotecario == null) {
		 int op;
		 System.out.println("1 - Inserir novamente.");
		 System.out.println("2 - Retornar ao menu anterior.");
		 System.out.print("Digite aqui: ");
		 op = scanner.nextInt();
		 scanner.nextLine();

		 if (op == 1) {
			do {
			   System.out.print("Confirme seu EMAIL: ");
			   email = scanner.nextLine();
			   if (email.isEmpty()) {
				  System.out.println("Você precisa inserir um email válido!\n");
			   }
			} while (email.isEmpty());
			bibliotecario = Busca.buscarBibliotecarioPorEmail(listaBibliotecarios, email);
			if (bibliotecario == null) {
			   System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			} else {
			   break;
			}
		 } else if (op == 2) {
			return;
		 } else {
			System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
		 }
	  }

	  System.out.print("\nDigite o título do livro que deseja renovar");
	  titulo = scanner.nextLine();

	  Livro livro = Busca.buscarLivroPorNome(listaLivros, titulo);
	  if (livro == null) {
		 System.out.println("Livro não disponível no acervo!");
		 return;
	  }

	  Emprestimo emprestimo = Busca.buscarEmprestimoPorBibliotecarioETitulo(bibliotecario, livro, listaEmprestimos);
	  if (emprestimo == null) {
		 System.out.println("Você não possui este livro emprestado!");
		 return;
	  }

	  emprestimo.renovar();
	  System.out.println("Livro renovado com sucesso! Novo prazo de entrega: " + emprestimo.getDataLimiteDevolucao() + "dias.");
   }
}