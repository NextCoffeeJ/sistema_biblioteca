package controller;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Devolucao extends Login {
   private static final Scanner scanner = new Scanner(System.in);

   public static void devolverLivroAluno(ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAluno, ArrayList<Emprestimo> listaEmprestimo) {

	  String email, titulo;

	  do {
		 System.out.print("Confirme seu EMAIL: ");
		 email = scanner.nextLine();
		 if (email.isEmpty()) {
			System.out.println("Você precisa inserir um email válido!\n");
		 }
	  } while (email.isEmpty());

	  Aluno aluno = Busca.buscarAlunoPorEmail(listaAluno, email);

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
			   do {
				  System.out.print("Confirme seu EMAIL: ");
				  email = scanner.nextLine();
				  if (email.isEmpty()) {
					 System.out.println("Você precisa inserir um email válido!\n");
				  }
			   } while (email.isEmpty());
			   aluno = Busca.buscarAlunoPorEmail(listaAluno, email);
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
		 } while (true);
	  }

	  System.out.print("\nDigite o título do livro que deseja devolver: ");
	  titulo = scanner.nextLine();

	  Emprestimo emprestimoEncontrado = null;
	  for (Emprestimo emprestimo : listaEmprestimo) {
		 if (emprestimo.getUsuario() != null &&
				 emprestimo.getUsuario().equals(aluno) &&
				 emprestimo.getLivro().getTitulo().equalsIgnoreCase(titulo)) {
			emprestimoEncontrado = emprestimo;
			break;
		 }
	  }

	  if(emprestimoEncontrado == null){
		 System.out.println("Desculpe, esse livro não está registrado como emprestado! ");
		 return;
	  }

	  if (emprestimoEncontrado.isAtrasado()) {
		 aluno.setMulta(aluno.getMulta() + 5);
		 System.out.println("Livro devolvido com atraso! Multa de R$5 adicionada ao seu cadastro.");
	  }

	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			livro.setQtdDisponivel(livro.getQtdDisponivel() + 1);
			break;
		 }
	  }

	  listaEmprestimo.remove(emprestimoEncontrado);

	  System.out.println("Livro devolvido com sucesso por " + aluno.getNome() + "!");
   }

   public static void devolverLivroProfessor(ArrayList<Livro> listaLivros, ArrayList<Professor> listaProfessor, ArrayList<Emprestimo> listaEmprestimo) {

	  String email, titulo;

	  do {
		 System.out.print("Confirme seu EMAIL: ");
		 email = scanner.nextLine();
		 if (email.isEmpty()) {
			System.out.println("Você precisa inserir um email válido!\n");
		 }
	  } while (email.isEmpty());

	  Professor professor = Busca.buscarProfessorPorEmail(listaProfessor, email);

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
			   do {
				  System.out.print("Confirme seu EMAIL: ");
				  email = scanner.nextLine();
				  if (email.isEmpty()) {
					 System.out.println("Você precisa inserir um email válido!\n");
				  }
			   } while (email.isEmpty());
			   professor = Busca.buscarProfessorPorEmail(listaProfessor, email);
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
		 } while (true);
	  }

	  System.out.print("\nDigite o título do livro que deseja devolver: ");
	  titulo = scanner.nextLine();

	  Emprestimo emprestimoEncontrado = null;
	  for (Emprestimo emprestimo : listaEmprestimo) {
		 if (emprestimo.getUsuario() != null &&
				 emprestimo.getUsuario().equals(professor) &&
				 emprestimo.getLivro().getTitulo().equalsIgnoreCase(titulo)) {
			emprestimoEncontrado = emprestimo;
			break;
		 }
	  }

	  if (emprestimoEncontrado == null) {
		 System.out.println("Desculpe, esse livro não está registrado como emprestado!");
		 return;
	  }

	  if (emprestimoEncontrado.isAtrasado()) {
		 professor.setMulta(professor.getMulta() + 5);
		 System.out.println("Livro devolvido com atraso! Multa de R$5 adicionada ao seu cadastro.");
	  }

	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			livro.setQtdDisponivel(livro.getQtdDisponivel() + 1);
			break;
		 }
	  }

	  listaEmprestimo.remove(emprestimoEncontrado);

	  System.out.println("Livro devolvido com sucesso por " + professor.getNome() + "!");
   }

   public static void devolverLivroBibliotecario(ArrayList<Livro> listaLivros, ArrayList<Bibliotecario> listaBibliotecario, ArrayList<Emprestimo> listaEmprestimo) {

	  String email, titulo;

	  do {
		 System.out.print("Confirme seu EMAIL: ");
		 email = scanner.nextLine();
		 if (email.isEmpty()) {
			System.out.println("Você precisa inserir um email válido!\n");
		 }
	  } while (email.isEmpty());

	  Bibliotecario bibliotecario = Busca.buscarBibliotecarioPorEmail(listaBibliotecario, email);

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
			   do {
				  System.out.print("Confirme seu EMAIL: ");
				  email = scanner.nextLine();
				  if (email.isEmpty()) {
					 System.out.println("Você precisa inserir um email válido!\n");
				  }
			   } while (email.isEmpty());
			   bibliotecario = Busca.buscarBibliotecarioPorEmail(listaBibliotecario, email);
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
		 } while (true);
	  }

	  System.out.print("\nDigite o título do livro que deseja devolver: ");
	  titulo = scanner.nextLine();

	  Emprestimo emprestimoEncontrado = null;
	  for (Emprestimo emprestimo : listaEmprestimo) {
		 if (emprestimo.getUsuario() != null &&
				 emprestimo.getUsuario().equals(bibliotecario) &&
				 emprestimo.getLivro().getTitulo().equalsIgnoreCase(titulo)) {
			emprestimoEncontrado = emprestimo;
			break;
		 }
	  }

	  if (emprestimoEncontrado == null) {
		 System.out.println("Desculpe, esse livro não está registrado como emprestado!");
		 return;
	  }

	  if (emprestimoEncontrado.isAtrasado()) {
		 bibliotecario.setMulta(bibliotecario.getMulta() + 5);
		 System.out.println("Livro devolvido com atraso! Multa de R$5 adicionada ao seu cadastro.");
	  }

	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			livro.setQtdDisponivel(livro.getQtdDisponivel() + 1);
			break;
		 }
	  }

	  listaEmprestimo.remove(emprestimoEncontrado);

	  System.out.println("Livro devolvido com sucesso por " + bibliotecario.getNome() + "!");

   }
}
