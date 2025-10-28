package controller;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public final class Login {
	private static final Scanner scanner = new Scanner(System.in);
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

   	public static Livro  buscarLivroPorNome(ArrayList<Livro> listaLivros,String titulo){
		for(Livro livro : listaLivros){
			if(livro.getTitulo().equalsIgnoreCase(titulo)){
				return livro;
			}
		}
		return null;
   	}

	public static Emprestimo buscarEmprestimoPorAlunoETitulo(Aluno aluno, Livro livro, ArrayList<Emprestimo> listaEmprestimos){
		for(Emprestimo emprestimo:listaEmprestimos){
			if(emprestimo.getLivro().getTitulo().equalsIgnoreCase(livro.getTitulo()) && aluno.getNome().equalsIgnoreCase(emprestimo.getAluno().getNome())){
				return emprestimo;
			}
		}
		return null;
	}

	public static Emprestimo buscarEmprestimoPorProfessorETitulo(Professor professor, Livro livro, ArrayList<Emprestimo> listaEmprestimos){
		for(Emprestimo emprestimo:listaEmprestimos){
			if(emprestimo.getLivro().getTitulo().equalsIgnoreCase(livro.getTitulo()) && professor.getNome().equalsIgnoreCase(emprestimo.getProfessor().getNome())){
				return emprestimo;
			}
		}
	return null;
	}

	public static Emprestimo buscarEmprestimoPorBibliotecarioETitulo(Bibliotecario bibliotecario, Livro livro, ArrayList<Emprestimo> listaEmprestimos){
		for(Emprestimo emprestimo:listaEmprestimos){
			if(emprestimo.getLivro().getTitulo().equalsIgnoreCase(livro.getTitulo()) && bibliotecario.getNome().equalsIgnoreCase(emprestimo.getBibliotecario().getNome())){
				return emprestimo;
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



   public static void devolverLivroAluno(ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAluno) {
	  
	  String email, titulo;

	  System.out.print("Confirme seu EMAIL: ");
	  email = scanner.nextLine();

	  do {
		 if (email.isEmpty()) {
			System.out.println("Você precisa inserir um email válido!\n");
			System.out.print("EMAIL: ");
			email = scanner.nextLine();
		 }
	  } while (email.isEmpty());

	  Aluno aluno = Login.buscarAlunoPorEmail(listaAluno, email);

	  if (aluno == null) {
		 System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
		 do {
			int op;
			System.out.println("1 - Inserir novamente.");
			System.out.println("2 - Retornar ao menu anterior.");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();
			scanner.nextLine();

			if (op == 1) {
			   System.out.print("\nConfirme seu EMAIL: ");
			   email = scanner.nextLine();
			   aluno = Login.buscarAlunoPorEmail(listaAluno, email);
			   if (aluno == null) {
				  System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			   } else {
				  break;
			   }
			} else if (op == 2) {
			   return;
			} else {
			   System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
			}
		 } while (true);
	  }

	  System.out.print("\nDigite o título do livro que deseja devolver: ");
	  titulo = scanner.nextLine();

	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			livro.setQtdDisponivel(livro.getQtdDisponivel() + 1);
			System.out.println("Livro devolvido com sucesso por " + aluno.getNome() + "!");
			return;
		 }
	  }

	  System.out.println("Não encontramos este livro disponível!");
   }

   public static void devolverLivroProfessor(ArrayList<Livro> listaLivros, ArrayList<Professor> listaProfessor) {
	  
	  String email, titulo;

	  System.out.print("Confirme seu EMAIL: ");
	  email = scanner.nextLine();

	  do {
		 if (email.isEmpty()) {
			System.out.println("Você precisa inserir um email válido!\n");
			System.out.print("EMAIL: ");
			email = scanner.nextLine();
		 }
	  } while (email.isEmpty());

	  Professor professor = Login.buscarProfessorPorEmail(listaProfessor, email);

	  if (professor == null) {
		 System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
		 do {
			int op;
			System.out.println("1 - Inserir novamente.");
			System.out.println("2 - Retornar ao menu anterior.");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();
			scanner.nextLine();

			if (op == 1) {
			   System.out.print("\nConfirme seu EMAIL: ");
			   email = scanner.nextLine();
			   professor = Login.buscarProfessorPorEmail(listaProfessor, email);
			   if (professor == null) {
				  System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			   } else {
				  break;
			   }
			} else if (op == 2) {
			   return;
			} else {
			   System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
			}
		 } while (true);
	  }

	  System.out.print("\nDigite o título do livro que deseja devolver: ");
	  titulo = scanner.nextLine();

	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			livro.setQtdDisponivel(livro.getQtdDisponivel() + 1);
			System.out.println("Livro devolvido com sucesso por " + professor.getNome() + "!");
			return;
		 }
	  }

	  System.out.println("Não encontramos este livro disponível!");
   }

   public static void devolverLivroBibliotecario(ArrayList<Livro> listaLivros, ArrayList<Bibliotecario> listaBibliotecario) {
	  
	  String email, titulo;

	  System.out.print("Confirme seu EMAIL: ");
	  email = scanner.nextLine();

	  do {
		 if (email.isEmpty()) {
			System.out.println("Você precisa inserir um email válido!\n");
			System.out.print("EMAIL: ");
			email = scanner.nextLine();
		 }
	  } while (email.isEmpty());

	  Bibliotecario bibliotecario = Login.buscarBibliotecarioPorEmail(listaBibliotecario, email);

	  if (bibliotecario == null) {
		 System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
		 do {
			int op;
			System.out.println("1 - Inserir novamente.");
			System.out.println("2 - Retornar ao menu anterior.");
			System.out.print("Digite aqui: ");
			op = scanner.nextInt();
			scanner.nextLine();

			if (op == 1) {
			   System.out.print("\nConfirme seu EMAIL: ");
			   email = scanner.nextLine();
			   bibliotecario = Login.buscarBibliotecarioPorEmail(listaBibliotecario, email);
			   if (bibliotecario == null) {
				  System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			   } else {
				  break;
			   }
			} else if (op == 2) {
			   return;
			} else {
			   System.out.println("\nDesculpa, não entendi, digite uma das opções:\n");
			}
		 } while (true);
	  }

	  System.out.print("\nDigite o título do livro que deseja devolver: ");
	  titulo = scanner.nextLine();

	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			livro.setQtdDisponivel(livro.getQtdDisponivel() + 1);
			System.out.println("Livro devolvido com sucesso por " + bibliotecario.getNome() + "!");
			return;
		 }
	  }

	  System.out.println("Não encontramos este livro disponível!");
   }

   public static void dadosLivrosAluno(ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAluno, String titulo) {
	  

	  Aluno aluno = null;
	  while (aluno == null) {
		 System.out.print("Confirme seu EMAIL: ");
		 String email = scanner.nextLine();

		 do {
			if (email.isEmpty()) {
			   System.out.println("Você precisa inserir um email válido!\n");
			   System.out.print("EMAIL: ");
			   email = scanner.nextLine();
			}
		 } while (email.isEmpty());

		 aluno = Login.buscarAlunoPorEmail(listaAluno, email);

		 if (aluno == null) {
			System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			System.out.println("1 - Inserir novamente.");
			System.out.println("2 - Retornar ao menu anterior.");
			System.out.print("Digite aqui: ");
			int op = scanner.nextInt();
			scanner.nextLine();

			if (op == 2) {
			   return;
			} else {
			   System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			}
		 }
	  }

	  Livro livroEncontrado = null;
	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			livroEncontrado = livro;
			break;
		 }
	  }

	  if (livroEncontrado == null) {
		 System.out.println("Livro não encontrado!");
		 return;
	  }

	  if (aluno.getLimiteLivros() == 3) {
		 System.out.println("Você ainda não pegou nenhum livro!");
	  } else {
		 System.out.println("\nTÍTULO: " + livroEncontrado.getTitulo());
		 System.out.println("AUTOR: " + livroEncontrado.getAutor());
		 System.out.println("EDITORA: " + livroEncontrado.getEditora());
		 System.out.println("ISBN: " + livroEncontrado.getIsbn());
		 System.out.println("ANO PUBLICAÇÃO: " + livroEncontrado.getAnoPublicacao());
		 System.out.println("CATEGORIA: " + livroEncontrado.getCategoria());
		 System.out.println("LOCALIZAÇÃO: " + livroEncontrado.getLocalizacao());
	  }
   }

   public static void dadosLivrosProfessor(ArrayList<Livro> listaLivros, ArrayList<Professor> listaProfessor, String titulo) {
	  

	  Professor professor = null;
	  while (professor == null) {
		 System.out.print("Confirme seu EMAIL: ");
		 String email = scanner.nextLine();

		 do {
			if (email.isEmpty()) {
			   System.out.println("Você precisa inserir um email válido!\n");
			   System.out.print("EMAIL: ");
			   email = scanner.nextLine();
			}
		 } while (email.isEmpty());

		 professor = Login.buscarProfessorPorEmail(listaProfessor, email);

		 if (professor == null) {
			System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			System.out.println("1 - Inserir novamente.");
			System.out.println("2 - Retornar ao menu anterior.");
			System.out.print("Digite aqui: ");
			int op = scanner.nextInt();
			scanner.nextLine();

			if (op == 2) {
			   return;
			} else {
			   System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			}
		 }
	  }

	  Livro livroEncontrado = null;
	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			livroEncontrado = livro;
			break;
		 }
	  }

	  if (livroEncontrado == null) {
		 System.out.println("Livro não encontrado!");
		 return;
	  }

	  if (professor.getLimiteLivros() == 10) {
		 System.out.println("Você ainda não pegou nenhum livro!");
	  } else {
		 System.out.println("\nTÍTULO: " + livroEncontrado.getTitulo());
		 System.out.println("AUTOR: " + livroEncontrado.getAutor());
		 System.out.println("EDITORA: " + livroEncontrado.getEditora());
		 System.out.println("ISBN: " + livroEncontrado.getIsbn());
		 System.out.println("ANO PUBLICAÇÃO: " + livroEncontrado.getAnoPublicacao());
		 System.out.println("CATEGORIA: " + livroEncontrado.getCategoria());
		 System.out.println("LOCALIZAÇÃO: " + livroEncontrado.getLocalizacao());
	  }
   }

   public static void dadosLivrosBibliotecario(ArrayList<Livro> listaLivros, ArrayList<Bibliotecario> listaBibliotecario, String titulo) {
	  

	  Bibliotecario bibliotecario = null;
	  while (bibliotecario == null) {
		 System.out.print("Confirme seu EMAIL: ");
		 String email = scanner.nextLine();

		 do {
			if (email.isEmpty()) {
			   System.out.println("Você precisa inserir um email válido!\n");
			   System.out.print("EMAIL: ");
			   email = scanner.nextLine();
			}
		 } while (email.isEmpty());

		 bibliotecario = Login.buscarBibliotecarioPorEmail(listaBibliotecario, email);

		 if (bibliotecario == null) {
			System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
			System.out.println("1 - Inserir novamente.");
			System.out.println("2 - Retornar ao menu anterior.");
			System.out.print("Digite aqui: ");
			int op = scanner.nextInt();
			scanner.nextLine();

			if (op == 2) {
			   return;
			} else {
			   System.out.println("Desculpa, não entendi, digite uma das opções:\n");
			}
		 }
	  }

	  Livro livroEncontrado = null;
	  for (Livro livro : listaLivros) {
		 if (livro.getTitulo().equalsIgnoreCase(titulo)) {
			livroEncontrado = livro;
			break;
		 }
	  }

	  if (livroEncontrado == null) {
		 System.out.println("Livro não encontrado!");
		 return;
	  }

	  if (bibliotecario.getLimiteLivros() == 10) {
		 System.out.println("Você ainda não pegou nenhum livro!");
	  } else {
		 System.out.println("\nTÍTULO: " + livroEncontrado.getTitulo());
		 System.out.println("AUTOR: " + livroEncontrado.getAutor());
		 System.out.println("EDITORA: " + livroEncontrado.getEditora());
		 System.out.println("ISBN: " + livroEncontrado.getIsbn());
		 System.out.println("ANO PUBLICAÇÃO: " + livroEncontrado.getAnoPublicacao());
		 System.out.println("CATEGORIA: " + livroEncontrado.getCategoria());
		 System.out.println("LOCALIZAÇÃO: " + livroEncontrado.getLocalizacao());
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


   public static void redefinirSenhaAluno (ArrayList<Aluno> listaAlunos, String matricula) {
	  Aluno novaSenha = null;
	  

	  for (Aluno aluno : listaAlunos) {
		 if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
			novaSenha = aluno;
			break;
		 }
	  }

	  if (novaSenha != null) {
		 System.out.print("Digite uma nova nova: ");
		 String senha = scanner.nextLine();

		 do {
			if (senha.isEmpty()) {
			   System.out.println("Informe uma senha válida!");
			   System.out.print("SENHA: ");
			   senha = scanner.nextLine();
			}
		 } while (senha.isEmpty());

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

			   do {
				  if (matricula.isEmpty()) {
					 System.out.println("Informe uma matricula válida!");
					 System.out.print("MATRICULA: ");
					 matricula = scanner.nextLine();
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

	  if (novaSenha != null) {
		 System.out.print("Digite uma nova nova: ");
		 String senha = scanner.nextLine();

		 do {
			if (matricula.isEmpty()) {
			   System.out.println("Informe uma senha válida!");
			   System.out.print("SENHA: ");
			   senha = scanner.nextLine();
			}
		 } while (senha.isEmpty());

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

			   do {
				  if (matricula.isEmpty()) {
					 System.out.println("Informe uma matricula válida!");
					 System.out.print("MATRICULA: ");
					 matricula = scanner.nextLine();
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

	  if (novaSenha != null) {
		 System.out.print("Digite uma nova nova: ");
		 String senha = scanner.nextLine();

		 do {
			if (senha.isEmpty()) {
			   System.out.println("Informe uma senha válida!");
			   System.out.print("SENHA: ");
			   senha = scanner.nextLine();
			}
		 } while (senha.isEmpty());

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

			   do {
				  if (matricula.isEmpty()) {
					 System.out.println("Informe uma matricula válida!");
					 System.out.print("MATRICULA: ");
					 matricula = scanner.nextLine();
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
