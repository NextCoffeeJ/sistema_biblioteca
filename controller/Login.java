package controller;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import application.AplicacaoBiblioteca;
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

   public static int matriculaDuplicada (ArrayList<Aluno> listaAlunos, ArrayList<Professor> listaProfessores, ArrayList<Bibliotecario> listaBibliotecarios, String matricula, int tipo) {
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

   public static int telefoneDuplicado(ArrayList<Aluno> listaAlunos, ArrayList<Professor> listaProfessores, ArrayList<Bibliotecario> listaBibliotecarios, String telefone, int tipo) {
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

   public static int cpfDuplicado(ArrayList<Aluno> listaAlunos, ArrayList<Professor> listaProfessores, ArrayList<Bibliotecario> listaBibliotecarios, String cpf, int tipo) {
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

   public static int isbnDuplicado(ArrayList<Livro> listaLivros, String isbn) {
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

    public static void devolverLivroAluno(ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAluno, ArrayList<Emprestimo> listaEmprestimo) {

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

        Emprestimo emprestimoEncontrado = null;
        for (Emprestimo emprestimo : listaEmprestimo) {
            if (emprestimo.getUsuario() != null &&
                    emprestimo.getUsuario().equals(aluno) &&
                    emprestimo.getLivro().getTitulo().equalsIgnoreCase(titulo)) {
                emprestimoEncontrado = emprestimo;
                break;
            }
        }

        if(emprestimoEncontrado == null){
            System.out.println("Desculpe, esse livro não está registrado como emprestado! ");
            return;
        }

        if (emprestimoEncontrado.isAtrasado()) {
            aluno.setMulta(aluno.getMulta() + 5);
            System.out.println("Livro devolvido com atraso! Multa de R$5 adicionada ao seu cadastro.");
        }

        for (Livro livro : listaLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.setQtdDisponivel(livro.getQtdDisponivel() + 1);
                break;
            }
        }

        listaEmprestimo.remove(emprestimoEncontrado);

        System.out.println("Livro devolvido com sucesso por " + aluno.getNome() + "!");
    }

    public static void devolverLivroProfessor(ArrayList<Livro> listaLivros, ArrayList<Professor> listaProfessor, ArrayList<Emprestimo> listaEmprestimo) {

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

        Emprestimo emprestimoEncontrado = null;
        for (Emprestimo emprestimo : listaEmprestimo) {
            if (emprestimo.getUsuario() != null &&
                    emprestimo.getUsuario().equals(professor) &&
                    emprestimo.getLivro().getTitulo().equalsIgnoreCase(titulo)) {
                emprestimoEncontrado = emprestimo;
                break;
            }
        }

        if (emprestimoEncontrado == null) {
            System.out.println("Desculpe, esse livro não está registrado como emprestado!");
            return;
        }

        if (emprestimoEncontrado.isAtrasado()) {
            professor.setMulta(professor.getMulta() + 5);
            System.out.println("Livro devolvido com atraso! Multa de R$5 adicionada ao seu cadastro.");
        }

        for (Livro livro : listaLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.setQtdDisponivel(livro.getQtdDisponivel() + 1);
                break;
            }
        }

        listaEmprestimo.remove(emprestimoEncontrado);

        System.out.println("Livro devolvido com sucesso por " + professor.getNome() + "!");
    }

    public static void devolverLivroBibliotecario(ArrayList<Livro> listaLivros, ArrayList<Bibliotecario> listaBibliotecario, ArrayList<Emprestimo> listaEmprestimo) {

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

        Emprestimo emprestimoEncontrado = null;
        for (Emprestimo emprestimo : listaEmprestimo) {
            if (emprestimo.getUsuario() != null &&
                    emprestimo.getUsuario().equals(bibliotecario) &&
                    emprestimo.getLivro().getTitulo().equalsIgnoreCase(titulo)) {
                emprestimoEncontrado = emprestimo;
                break;
            }
        }

        if (emprestimoEncontrado == null) {
            System.out.println("Desculpe, esse livro não está registrado como emprestado!");
            return;
        }

        if (emprestimoEncontrado.isAtrasado()) {
            bibliotecario.setMulta(bibliotecario.getMulta() + 5);
            System.out.println("Livro devolvido com atraso! Multa de R$5 adicionada ao seu cadastro.");
        }

        for (Livro livro : listaLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.setQtdDisponivel(livro.getQtdDisponivel() + 1);
                break;
            }
        }

        listaEmprestimo.remove(emprestimoEncontrado);

        System.out.println("Livro devolvido com sucesso por " + bibliotecario.getNome() + "!");

    }


        public static void renovarLivroAluno (ArrayList<Livro> listaLivros, ArrayList<Aluno> listaAlunos, ArrayList<Emprestimo> listaEmprestimos) {

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

        Aluno aluno = Login.buscarAlunoPorEmail(listaAlunos, email);

        if (aluno == null) {
            System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
        }
        while (aluno == null) {
            int op;
            System.out.println("1 - Inserir novamente.");
            System.out.println("2 - Retornar ao menu anterior.");
            System.out.print("Digite aqui: ");
            op = scanner.nextInt();
            scanner.nextLine();

            if (op == 1) {
                System.out.print("\nConfirme seu EMAIL: ");
                email = scanner.nextLine();
                aluno = Login.buscarAlunoPorEmail(listaAlunos, email);
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
        }

        System.out.print("\nDigite o título do livro que deseja renovar: ");
        titulo = scanner.nextLine();

        Livro livro = Login.buscarLivroPorNome(listaLivros, titulo);
        if (livro == null) {
            System.out.println("Livro não disponível no acervo!");
            return;
        }

        Emprestimo emprestimo = Login.buscarEmprestimoPorAlunoETitulo(aluno, livro, listaEmprestimos);
        if (emprestimo == null) {
            System.out.println("Você não possui este livro emprestado!");
            return;
        }

        emprestimo.setDataLimiteDevolucao(emprestimo.getDataLimiteDevolucao().plusDays(10));
        System.out.println("Livro renovado com sucesso! Novo prazo de entrega: " + emprestimo.getDataLimiteDevolucao() + "dias.");
    }

    public static void renovarLivroProfessor (ArrayList<Livro> listaLivros, ArrayList<Professor> listaProfessores, ArrayList<Emprestimo> listaEmprestimos) {

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

        Professor professor = Login.buscarProfessorPorEmail(listaProfessores, email);

        if (professor == null) {
            System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
        }
        while (professor == null) {
            int op;
            System.out.println("1 - Inserir novamente.");
            System.out.println("2 - Retornar ao menu anterior.");
            System.out.print("Digite aqui: ");
            op = scanner.nextInt();
            scanner.nextLine();

            if (op == 1) {
                System.out.print("\nConfirme seu EMAIL: ");
                email = scanner.nextLine();
                professor = Login.buscarProfessorPorEmail(listaProfessores, email);
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
        }

        System.out.print("\nDigite o título do livro que deseja renovar");
        titulo = scanner.nextLine();

        Livro livro = Login.buscarLivroPorNome(listaLivros, titulo);
        if (livro == null) {
            System.out.println("Livro não disponível no acervo!");
            return;
        }

        Emprestimo emprestimo = Login.buscarEmprestimoPorProfessorETitulo(professor, livro, listaEmprestimos);
        if (emprestimo == null) {
            System.out.println("Você não possui este livro emprestado!");
            return;
        }

        emprestimo.setDataLimiteDevolucao(emprestimo.getDataLimiteDevolucao().plusDays(10));
        System.out.println("Livro renovado com sucesso! Novo prazo de entrega: " + emprestimo.getDataLimiteDevolucao() + "dias.");
    }

    public static void renovarLivroBibliotecario (ArrayList<Livro> listaLivros, ArrayList<Bibliotecario> listaBibliotecarios, ArrayList<Emprestimo> listaEmprestimos) {

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

        Bibliotecario bibliotecario = Login.buscarBibliotecarioPorEmail(listaBibliotecarios, email);

        if (bibliotecario == null) {
            System.out.println("\nEmail incorreto! Ou não cadastrado!\n");
        }
        while (bibliotecario == null) {
            int op;
            System.out.println("1 - Inserir novamente.");
            System.out.println("2 - Retornar ao menu anterior.");
            System.out.print("Digite aqui: ");
            op = scanner.nextInt();
            scanner.nextLine();

            if (op == 1) {
                System.out.print("\nConfirme seu EMAIL: ");
                email = scanner.nextLine();
                bibliotecario = Login.buscarBibliotecarioPorEmail(listaBibliotecarios, email);
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
        }

        System.out.print("\nDigite o título do livro que deseja renovar");
        titulo = scanner.nextLine();

        Livro livro = Login.buscarLivroPorNome(listaLivros, titulo);
        if (livro == null) {
            System.out.println("Livro não disponível no acervo!");
            return;
        }

        Emprestimo emprestimo = Login.buscarEmprestimoPorBibliotecarioETitulo(bibliotecario, livro, listaEmprestimos);
        if (emprestimo == null) {
            System.out.println("Você não possui este livro emprestado!");
            return;
        }

        emprestimo.setDataLimiteDevolucao(emprestimo.getDataLimiteDevolucao().plusDays(10));
        System.out.println("Livro renovado com sucesso! Novo prazo de entrega: " + emprestimo.getDataLimiteDevolucao() + "dias.");
    }

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

    public static void dadosLivrosUsuario(ArrayList<Emprestimo> listaEmprestimos, String email) {
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