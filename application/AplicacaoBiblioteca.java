package application;
import java.util.ArrayList;
import java.util.Scanner;
import model.Usuario;
import service.Cadastro;
import model.Aluno;
import model.Professor;
import model.Bibliotecario;

public class AplicacaoBiblioteca {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Cadastro cadastro = new Cadastro();
		ArrayList<Aluno> alunos = new ArrayList<>();
		ArrayList<Professor> professores = new ArrayList<>();
		ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();
		

		int escolha;

	do {
			System.out.println("\n--- MENU ---");
			System.out.println("1 - Cadastrar usuário");
			System.out.println("2 - Ver todos os usuários");
			System.out.println("0 - Encerrar");
			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();
			scanner.nextLine();

		
		switch (escolha) {
			case 1: System.out.print("Nome: ");
					String nome = scanner.nextLine();
					System.out.print("CPF: ");
					String cpf = scanner.nextLine();
					System.out.print("Email: ");
					String email = scanner.nextLine();
					System.out.print("Telefone: ");
					String telefone = scanner.nextLine();
					System.out.print("Matrícula: ");
					String matricula = scanner.nextLine();
					System.out.print("Senha: ");
					String senha = scanner.nextLine();
					System.out.println("Tipo de usuário: ");
					System.out.println("1 - Aluno");
					System.out.println("2 - Professor");
					System.out.println("3 - Bibliotecário");
					System.out.print("Escolha uma opção: ");
					int tipoUsuario = scanner.nextInt();
					if(tipoUsuario == 1){
						System.out.println("Curso: ");
						String curso = scanner.nextLine();
						Usuario aluno = new Aluno(nome, cpf, email, telefone, matricula, senha, curso);
						cadastro.adicionarUsuario(aluno);
					} 
					else if(tipoUsuario == 2){
						System.out.println("Departamento: ");
						String departamento = scanner.nextLine();
						Usuario professor = new Professor(nome, cpf, email, telefone, matricula, senha, departamento);
						cadastro.adicionarUsuario(professor);
					}
					else if (tipoUsuario == 3){
						Usuario bibliotecario = new Bibliotecario(nome, cpf, email, telefone, matricula, senha);
						cadastro.adicionarUsuario(bibliotecario);

					}
					else{
						System.out.println("Tipo de usuário inválido!");
					}
				break;
			case 2: System.out.println("\n--- Usuários Cadastrados ---");
				for (Usuario u : cadastro.getUsuarios()) {
					u.exibirDados();
				}
				break;
			case 0: System.out.println("Encerrando programa...");
					break;
			default: System.out.println("Opção inválida!");
		}
	} while (escolha != 0);
		scanner.close();
	}
}