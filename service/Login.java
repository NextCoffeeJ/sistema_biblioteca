package service;
import model.*;
import java.util.ArrayList;

public abstract class Login {
   abstract public void adicionarLivro (ArrayList<Livro> listaLivros, Livro livro);
   abstract public void adicionarAluno (ArrayList<Aluno> listaAluno, Aluno aluno);
   abstract public void adicionarProfessor (ArrayList<Professor> listaProfessor, Professor professor);
   abstract public void adicionarBibliotecario (ArrayList<Bibliotecario> listaBibliotecario, Bibliotecario bibliotecario);
}
