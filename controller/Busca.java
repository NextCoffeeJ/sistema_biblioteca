package controller;
import java.util.ArrayList;
import model.*;

public abstract class Busca {

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
		 if (professor.getEmail().equalsIgnoreCase(email)){
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

   public static byte matriculaDuplicada (ArrayList<Aluno> listaAlunos, ArrayList<Professor> listaProfessores, ArrayList<Bibliotecario> listaBibliotecarios, String matricula, byte tipo) {
	  if (tipo == 1) {
		 for (Aluno aluno : listaAlunos) {
			if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
			   return 1;
			}
		 }
		 return 0;
	  } else if (tipo == 2) {
		 for(Professor professor : listaProfessores){
			if(professor.getMatricula().equalsIgnoreCase(matricula)){
			   return 1;
			}
		 }
		 return 0;
	  } else {
		 for (Bibliotecario bibliotecario : listaBibliotecarios) {
			if (bibliotecario.getMatricula().equalsIgnoreCase(matricula)) {
			   return 1;
			}
		 }
		 return 0;
	  }
   }

   public static byte telefoneDuplicado(ArrayList<Aluno> listaAlunos, ArrayList<Professor> listaProfessores, ArrayList<Bibliotecario> listaBibliotecarios, String telefone, byte tipo) {
	  if (tipo == 1) {
		 for (Aluno aluno : listaAlunos) {
			if (aluno.getTelefone().equalsIgnoreCase(telefone)) {
			   return 1;
			}
		 }
		 return 0;
	  } else if (tipo == 2) {
		 for(Professor professor : listaProfessores){
			if(professor.getTelefone().equalsIgnoreCase(telefone)){
			   return 1;
			}
		 }
		 return 0;
	  } else {
		 for (Bibliotecario bibliotecario : listaBibliotecarios) {
			if (bibliotecario.getTelefone().equalsIgnoreCase(telefone)) {
			   return 1;
			}
		 }
		 return 0;
	  }
   }

   public static byte cpfDuplicado(ArrayList<Aluno> listaAlunos, ArrayList<Professor> listaProfessores, ArrayList<Bibliotecario> listaBibliotecarios, String cpf, byte tipo) {
	  if (tipo == 1) {
		 for (Aluno aluno : listaAlunos) {
			if (aluno.getCpf().equalsIgnoreCase(cpf)) {
			   return 1;
			}
		 }
		 return 0;
	  } else if (tipo == 2) {
		 for(Professor professor : listaProfessores){
			if(professor.getCpf().equalsIgnoreCase(cpf)){
			   return 1;
			}
		 }
		 return 0;
	  } else {
		 for (Bibliotecario bibliotecario : listaBibliotecarios) {
			if (bibliotecario.getCpf().equalsIgnoreCase(cpf)) {
			   return 1;
			}
		 }
		 return 0;
	  }
   }

   public static byte isbnDuplicado(ArrayList<Livro> listaLivros, String isbn) {
	  for (Livro livro : listaLivros) {
		 if (livro.getIsbn().equalsIgnoreCase(isbn)) {
			return 1;
		 }
	  }
	  return 0;
   }

   public static Livro  buscarLivroPorNome(ArrayList<Livro> listaLivros,String titulo){
	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			return livro;
		 }
	  }
	  return null;
   }

   public static Emprestimo buscarEmprestimoPorAlunoETitulo(Aluno aluno, Livro livro, ArrayList<Emprestimo> listaEmprestimos){
	  for(Emprestimo emprestimo:listaEmprestimos){
		 if(emprestimo.getLivro().getTitulo().equalsIgnoreCase(livro.getTitulo()) && aluno.getNome().equalsIgnoreCase(emprestimo.getUsuario().getNome())){
			return emprestimo;
		 }
	  }
	  return null;
   }

   public static Emprestimo buscarEmprestimoPorProfessorETitulo(Professor professor, Livro livro, ArrayList<Emprestimo> listaEmprestimos){
	  for(Emprestimo emprestimo:listaEmprestimos){
		 if(emprestimo.getLivro().getTitulo().equalsIgnoreCase(livro.getTitulo()) && professor.getNome().equalsIgnoreCase(emprestimo.getUsuario().getNome())){
			return emprestimo;
		 }
	  }
	  return null;
   }

   public static Emprestimo buscarEmprestimoPorBibliotecarioETitulo(Bibliotecario bibliotecario, Livro livro, ArrayList<Emprestimo> listaEmprestimos){
	  for(Emprestimo emprestimo:listaEmprestimos){
		 if(emprestimo.getLivro().getTitulo().equalsIgnoreCase(livro.getTitulo()) && bibliotecario.getNome().equalsIgnoreCase(emprestimo.getUsuario().getNome())){
			return emprestimo;
		 }
	  }
	  return null;
   }
}
