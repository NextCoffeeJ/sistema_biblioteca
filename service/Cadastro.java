package service;
import java.util.ArrayList;
import model.*;

public class Cadastro extends Login {

   @Override
   public void adicionarLivro(ArrayList<Livro> listaLivros, Livro livro) {
	  listaLivros.add(livro);
   }

   @Override
   public void adicionarAluno(ArrayList<Aluno> listaAluno, Aluno aluno) {
	  listaAluno.add(aluno);
   }

   @Override
   public void adicionarProfessor(ArrayList<Professor> listaProfessor, Professor professor) {
	  listaProfessor.add(professor);
   }

   @Override
   public void adicionarBibliotecario(ArrayList<Bibliotecario> listaBibliotecario, Bibliotecario bibliotecario) {
	  listaBibliotecario.add(bibliotecario);
   }
}