package service;

import model.Aluno;
import model.Professor;
import model.Bibliotecario;
import model.Usuario;

import java.util.ArrayList;

public final class CadastroUsuario {

   private CadastroUsuario() {
   }

   public static void adicionarAluno (ArrayList<Aluno> listaAlunos, Aluno aluno) {
	  listaAlunos.add(aluno);
   }

   public static void adicionarProfessor (ArrayList<Professor> listaProfessores, Professor professor) {
	  listaProfessores.add(professor);
   }

   public static void adicionarBibliotecario (ArrayList<Bibliotecario> listaBibliotecarios, Bibliotecario bibliotecario) {
	  listaBibliotecarios.add(bibliotecario);
   }
}