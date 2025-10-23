package service;

import java.util.ArrayList;

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

   public static Livro buscarLivroPorIsbn (ArrayList<Livro> listaLivros, String titulo) {
	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			return livro;
		 }
	  }
	  return null;
   }

   public static Livro mostrarLivros (ArrayList<Livro> listaLivros) {
	  if (listaLivros != null) {
		 for (Livro livro : listaLivros) {
			System.out.println(livro.getTitulo());
		 }
	  }
	  return null;
   }


   public static Usuario mostrarUsuarios (ArrayList<Usuario> listaUsuarios){
	  if (listaUsuarios != null) {
		 for (Usuario usuario : listaUsuarios) {
			System.out.println(usuario.getNome());
		 }
	  }
	  return null;
   }


   public static void cancelarCadastro (ArrayList<Usuario> listaUsuario, String matricula) {
	  Usuario removerUsuario = null;

	  for (Usuario user : listaUsuario) {
		 if (user.getMatricula().equalsIgnoreCase(matricula)) {
			removerUsuario = user;
			break;
		 }
	  }

	  if (removerUsuario != null) {
		 listaUsuario.remove(removerUsuario);
		 System.out.println("Usuario, " + removerUsuario.getNome() + ", removido com sucesso!");
	  } else {
		 System.out.println("Usuario não encontrado!");
	  }
   }

   public static void removerLivro (ArrayList<Livro> listaLivro, String isbn) {
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