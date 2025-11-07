package controller;

import model.Aluno;
import model.Emprestimo;
import model.Livro;

import java.util.ArrayList;

public abstract class Login {
   public static Aluno buscarAlunoPorEmail (ArrayList<Aluno> listaAlunos, String email){
	  return null;
   }

   public static void devolverLivroAluno(ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAluno, ArrayList<Emprestimo> listaEmprestimo) {};

   public static void cancelarCadastroAluno (ArrayList<Aluno> listaAluno, String matricula) {};

   public static void verMultasAluno(ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAlunos, ArrayList<Emprestimo> listaEmprestimos) {};

   public static void redefinirSenhaAluno (ArrayList<Aluno> listaAlunos, String matricula) {};

   public static void renovarLivroAluno (ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAlunos, ArrayList<Emprestimo> listaEmprestimos) {};
}
