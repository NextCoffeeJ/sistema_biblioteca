package controller;
import model.*;
import java.util.ArrayList;

public abstract class Cancelar {

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
}