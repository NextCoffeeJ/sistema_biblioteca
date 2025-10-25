package controller;
import java.util.ArrayList;
import java.util.Scanner;
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

   public static int emailDuplicadoAluno (ArrayList<Aluno> listaAlunos, String email){
	  for (Aluno aluno : listaAlunos) {
		 if (aluno.getEmail().equalsIgnoreCase(email)) {
			return 1;
		 }
	  }
	  return 0;
   }

   public static int emailDuplicadoProfessor (ArrayList<Professor> listaProfessor, String email){
	  for (Professor professor : listaProfessor) {
		 if (professor.getEmail().equalsIgnoreCase(email)) {
			return 1;
		 }
	  }
	  return 0;
   }


   public static int emailDuplicadoBibliotecario (ArrayList<Bibliotecario> listaBibliotecario, String email){
	  for (Bibliotecario bibliotecario : listaBibliotecario) {
		 if (bibliotecario.getEmail().equalsIgnoreCase(email)) {
			return 1;
		 }
	  }
	  return 0;
   }

   public static Livro buscarLivroPorTitulo(ArrayList<Livro> listaLivros, String titulo) {
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


   public static Aluno mostrarAlunos (ArrayList<Aluno> listaAlunos){
	  if (listaAlunos != null) {
		 for (Aluno aluno : listaAlunos) {
			System.out.println("Aluno: " + aluno.getNome());
		 }
	  }
	  return null;
   }

   public static Professor mostrarProfessores (ArrayList<Professor> listaProfessor){
	  if (listaProfessor != null) {
		 for (Professor professor : listaProfessor) {
			System.out.println("Professor: " + professor.getNome());
		 }
	  }
	  return null;
   }

   public static Bibliotecario mostrarBibliotecarios (ArrayList<Bibliotecario> listaBibliotecario){
	  if (listaBibliotecario != null) {
		 for (Bibliotecario bibliotecario : listaBibliotecario) {
			System.out.println("Bibliotecario: " + bibliotecario.getNome());
		 }
	  }
	  return null;
   }

   public static void cancelarCadastroAluno (ArrayList<Aluno> listaAluno, String matricula) {
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

   public static void redefinirSenhaAluno (ArrayList<Aluno> listaAlunos, String matricula) {
	  Aluno novaSenha = null;
	  Scanner scanner = new Scanner(System.in);

	  for (Aluno aluno : listaAlunos) {
		 if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = aluno;
			break;
		 }
	  }

	  if (novaSenha != null) {
		 System.out.print("Digite uma nova nova: ");
		 String senha = scanner.nextLine();
		 novaSenha.setSenha(senha);
		 System.out.println("Senha redefinida com sucesso!");
	  } else {
		 int op;
		 System.out.println("Usuario não encontrado");
		 do {
			System.out.println("Deseja tentar novamente?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();

			scanner.nextLine();
			if (op == 1) {
			   System.out.print("MATRICULA: ");
			   matricula = scanner.nextLine();
			   Login.redefinirSenhaAluno(listaAlunos, matricula);
			   break;
			} else if (op == 2) {
			   System.out.println("Até mais");
			} else {
			   System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			}

		 } while (op != 2);
	  }
   }

   public static void redefinirSenhaProfessor (ArrayList<Professor> listaProfessores, String matricula) {
	  Professor novaSenha = null;
	  Scanner scanner = new Scanner(System.in);

	  for (Professor professor : listaProfessores) {
		 if (professor.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = professor;
		 }
	  }

	  if (novaSenha != null) {
		 System.out.print("Digite uma nova nova: ");
		 String senha = scanner.nextLine();
		 novaSenha.setSenha(senha);
		 System.out.println("Senha redefinida com sucesso!");
	  } else {
		 int op;
		 System.out.println("Usuario não encontrado");
		 do {
			System.out.println("Deseja tentar novamente?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();

			scanner.nextLine();
			if (op == 1) {
			   System.out.print("MATRICULA: ");
			   matricula = scanner.nextLine();
			   Login.redefinirSenhaProfessor(listaProfessores, matricula);
			   break;
			} else if (op == 2) {
			   System.out.println("Até mais");
			} else {
			   System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			}
		 } while (op != 2);
	  }
   }

   public static void redefinirSenhaBibliotecario (ArrayList<Bibliotecario> listaBibliotecarios, String matricula) {
	  Bibliotecario novaSenha = null;
	  Scanner scanner = new Scanner(System.in);

	  for (Bibliotecario bibliotecario : listaBibliotecarios) {
		 if (bibliotecario.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = bibliotecario;
		 }
	  }

	  if (novaSenha != null) {
		 System.out.print("Digite uma nova nova: ");
		 String senha = scanner.nextLine();
		 novaSenha.setSenha(senha);
		 System.out.println("Senha redefinida com sucesso!");
	  } else {
		 int op;
		 System.out.println("Usuario não encontrado");
		 do {
			System.out.println("Deseja tentar novamente?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();

			scanner.nextLine();
			if (op == 1) {
			   System.out.print("MATRICULA: ");
			   matricula = scanner.nextLine();
			   Login.redefinirSenhaBibliotecario(listaBibliotecarios, matricula);
			   break;
			} else if (op == 2) {
			   System.out.println("Até mais");
			} else {
			   System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			}
		 } while (op != 2);
	  }
   }
}