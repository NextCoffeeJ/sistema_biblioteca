	package service;

	import java.io.*;
	import java.util.ArrayList;
	import model.Usuario;
	import model.Aluno;
	import model.Professor;

	public class Cadastro {
	private ArrayList<Usuario> usuarios;
	private String nomeArquivo;

	public Cadastro() {
		usuarios = carregarUsuarios();
	}

	public void adicionarUsuario(Usuario user) {
		if(user.getclass()==Aluno.class){
			nomeArquivo="aluno.dat";
		}
		else if(user.getclass()==Professor.class){
			nomeArquivo="professor.dat";
		}
		else{
			nomeArquivo="bibliotecario.dat";
		}
		usuarios.add(user);
		salvarUsuarios();
		System.out.println("Usuário cadastrado e salvo com sucesso!");
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	private void salvarUsuarios() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
			oos.writeObject(usuarios);
		} catch (IOException e) {
			System.out.println("Erro ao salvar usuários: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private ArrayList<Usuario> carregarUsuarios() {
		File arquivo = new File(nomeArquivo);
		if (!arquivo.exists()) {
			return new ArrayList<>();
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
			return (ArrayList<Usuario>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Erro ao carregar usuários: " + e.getMessage());
			return new ArrayList<>();
		}
	}
	}
