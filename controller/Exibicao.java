package controller;
import model.*;
import java.util.ArrayList;

public abstract class Exibicao extends Login {
   public static void verMultasAluno(ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAlunos, ArrayList<Emprestimo> listaEmprestimos) {
	  for (Aluno aluno : listaAlunos) {
		 double totalMulta = 0;

		 for (Emprestimo emprestimo : listaEmprestimos) {
			if (emprestimo.getUsuario() != null && emprestimo.getUsuario().equals(aluno) && emprestimo.isAtrasado()) {
			   totalMulta += 5;
			}
		 }

		 if (totalMulta > 0) {
			System.out.println("Aluno: " + aluno.getNome() + " | Total de multa: R$" + totalMulta);
		 } else {
			System.out.println("Aluno: " + aluno.getNome() + " | Sem multas.");
		 }
	  }
   }

   public static void verMultasProfessor(ArrayList<Livro> listaLivros, ArrayList<Professor> listaProfessores, ArrayList<Emprestimo> listaEmprestimos){
	  for(Professor professor : listaProfessores){
		 double totalMulta = 0;

		 for(Emprestimo emprestimo : listaEmprestimos){
			if(emprestimo.getUsuario() != null && emprestimo.getUsuario().equals(professor) && emprestimo.isAtrasado()) {
			   totalMulta += 5;
			}
		 }

		 if(totalMulta > 0){
			System.out.println("Professor: " + professor.getNome() + " | Total de multa: R$" + totalMulta);
		 } else {
			System.out.println("Professor: " + professor.getNome() + " | Sem multas.");
		 }
	  }
   }

   public static void verMultasBibliotecario(ArrayList<Livro> listaLivros, ArrayList<Bibliotecario> listaBibliotecarios, ArrayList<Emprestimo> listaEmprestimos){
	  for(Bibliotecario bibliotecario : listaBibliotecarios){
		 double totalMulta = 0;

		 for(Emprestimo emprestimo : listaEmprestimos){
			if(emprestimo.getUsuario() != null && emprestimo.getUsuario().equals(bibliotecario) && emprestimo.isAtrasado()) {
			   totalMulta += 5;
			}
		 }

		 if(totalMulta > 0){
			System.out.println("Bibliotecário: " + bibliotecario.getNome() + " | Total de multa: R$" + totalMulta);
		 } else {
			System.out.println("Bibliotecário: " + bibliotecario.getNome() + " | Sem multas.");
		 }
	  }
   }

   public static void dadosLivrosUsuario (ArrayList<Emprestimo> listaEmprestimos, String email) {
	  for (Emprestimo emprestimo : listaEmprestimos) {
		 if (emprestimo.getUsuario().getEmail().equalsIgnoreCase(email)) {
			System.out.println("\nDados do Livro Emprestado:");
			Livro livro = emprestimo.getLivro();
			do {
			   System.out.println("TITULO: " + livro.getTitulo());
			   System.out.println("AUTOR: " + livro.getAutor());
			   System.out.println("EDITORA: " + livro.getEditora());
			   System.out.println("ISBN: " + livro.getIsbn());
			   System.out.println("ANO DE PUBLICAÇÃO: " + livro.getAnoPublicacao());
			   System.out.println("DATA DE EMPRESTIMO: " + emprestimo.getDataEmprestimo());
			   System.out.println("DATA LIMITE DE DEVOLUÇÃO: " + emprestimo.getDataLimiteDevolucao());
			} while (emprestimo.getLivro() == null);
		 }
	  }
   }

   public static void mostrarLivros (ArrayList<Livro> listaLivros) {
	  if (listaLivros.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }
	  for (Livro livro : listaLivros) {
		 System.out.println("TITULO: " + livro.getTitulo());
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

   public static void mostrarEmprestimos (ArrayList<Emprestimo> listaEmprestimos) {
	  if (listaEmprestimos.isEmpty()) {
		 System.out.println("Lista vazia");
		 return;
	  }

	  for (Emprestimo emprestimo : listaEmprestimos) {
		 System.out.println("Titulo: " + emprestimo.getLivro().getTitulo());
		 System.out.println("Em posse de: " + emprestimo.getUsuario().getNome());
		 System.out.println("Matricula: " + emprestimo.getUsuario().getMatricula());
	  }
   }

   public static void mostrarLivrosDisponiveis(ArrayList<Livro> listaLivros) {
	  if (listaLivros.isEmpty()) {
		 System.out.println("Nenhum livro cadastrado.");
		 return;
	  }

	  for (Livro livro : listaLivros) {
		 if (livro.getQtdDisponivel() > 0) {
			System.out.println("TITULO: " + livro.getTitulo());
		 }
	  }
   }

   public static void dadosUsuario (ArrayList<Aluno> listaAlunos, ArrayList<Professor> listaProfessores, ArrayList<Bibliotecario> listaBibliotecarios, String email, int tipo){
	  if (tipo == 1) {
		 for (Aluno aluno : listaAlunos) {
			if (aluno.getEmail().equalsIgnoreCase(email)) {
			   System.out.println("\nSuas informações:\n");
			   System.out.println("NOME: " + aluno.getNome());
			   System.out.println("EMAIL: " + aluno.getEmail());
			   System.out.println("CURSO: " + aluno.getCurso());
			   System.out.println("MATRICULA: " + aluno.getMatricula());
			   System.out.println("CPF: " + aluno.getCpf());
			   System.out.println("TELEFONE: " + aluno.getTelefone());
			}
		 }
	  } else if (tipo == 2) {
		 for (Professor professor : listaProfessores) {
			if (professor.getEmail().equalsIgnoreCase(email)) {
			   System.out.println("\nSuas informações:\n");
			   System.out.println("NOME: " + professor.getNome());
			   System.out.println("EMAIL: " + professor.getEmail());
			   System.out.println("DEPARTAMENTO: " + professor.getDepartamento());
			   System.out.println("MATRICULA: " + professor.getMatricula());
			   System.out.println("CPF: " + professor.getCpf());
			   System.out.println("TELEFONE: " + professor.getTelefone());
			}
		 }
	  } else {
		 for (Bibliotecario bibliotecario : listaBibliotecarios) {
			if (bibliotecario.getEmail().equalsIgnoreCase(email)) {
			   System.out.println("\nSuas informações:\n");
			   System.out.println("NOME: " + bibliotecario.getNome());
			   System.out.println("EMAIL: " + bibliotecario.getEmail());
			   System.out.println("MATRICULA: " + bibliotecario.getMatricula());
			   System.out.println("CPF: " + bibliotecario.getCpf());
			   System.out.println("TELEFONE: " + bibliotecario.getTelefone());
			}
		 }
	  }
   }
}

