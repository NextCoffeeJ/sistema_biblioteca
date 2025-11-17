package controller;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class RedefinirSenha {
   private static final Scanner scanner = new Scanner(System.in);

   public static void redefinirSenhaAluno (ArrayList<Aluno> listaAlunos, String matricula) {
	  Aluno novaSenha = null;


	  for (Aluno aluno : listaAlunos) {
		 if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = aluno;
			break;
		 }
	  }
	  String senha;
	  byte qtdCaracter;

	  if (novaSenha != null) {
		 do {
			do {
			   System.out.print("SENHA: ");
			   senha = scanner.nextLine().strip();
			   if (senha.isEmpty()) {
				  System.out.println("Você precisa inserir uma senha válido!\n");
			   }
			} while (senha.isEmpty());
			qtdCaracter = (byte) senha.length();
			if (qtdCaracter < 8) {
			   System.out.println("A senha tem que ter pelo menos 8 digitos!\n");
			}
		 } while (qtdCaracter < 8);

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
			   do {
				  System.out.print("MATRICULA: ");
				  matricula = scanner.nextLine().strip();
				  if (matricula.isEmpty()) {
					 System.out.println("Informe uma matricula válida!");
				  }
			   } while (matricula.isEmpty());

			   redefinirSenhaAluno(listaAlunos, matricula);
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


	  for (Professor professor : listaProfessores) {
		 if (professor.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = professor;
		 }
	  }

	  String senha;
	  byte qtdCaracter;

	  if (novaSenha != null) {
		 do {
			do {
			   System.out.print("SENHA: ");
			   senha = scanner.nextLine().strip();
			   if (senha.isEmpty()) {
				  System.out.println("Você precisa inserir uma senha válido!\n");
			   }
			} while (senha.isEmpty());
			qtdCaracter = (byte) senha.length();
			if (qtdCaracter < 8) {
			   System.out.println("A senha tem que ter pelo menos 8 digitos!\n");
			}
		 } while (qtdCaracter < 8);
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

			   do {
				  System.out.print("MATRICULA: ");
				  matricula = scanner.nextLine().strip();
				  if (matricula.isEmpty()) {
					 System.out.println("Informe uma matricula válida!");
				  }
			   } while (matricula.isEmpty());

			   redefinirSenhaProfessor(listaProfessores, matricula);
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


	  for (Bibliotecario bibliotecario : listaBibliotecarios) {
		 if (bibliotecario.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = bibliotecario;
		 }
	  }

	  String senha;
	  byte qtdCaracter;

	  if (novaSenha != null) {
		 do {
			do {
			   System.out.print("SENHA: ");
			   senha = scanner.nextLine().strip();
			   if (senha.isEmpty()) {
				  System.out.println("Você precisa inserir uma senha válido!\n");
			   }
			} while (senha.isEmpty());
			qtdCaracter = (byte) senha.length();
			if (qtdCaracter < 8) {
			   System.out.println("A senha tem que ter pelo menos 8 digitos!\n");
			}
		 } while (qtdCaracter < 8);

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

			   do {
				  System.out.print("MATRICULA: ");
				  matricula = scanner.nextLine().strip();
				  if (matricula.isEmpty()) {
					 System.out.println("Informe uma matricula válida!");
				  }
			   } while (matricula.isEmpty());

			   redefinirSenhaBibliotecario(listaBibliotecarios, matricula);
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