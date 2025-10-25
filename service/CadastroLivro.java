package service;

import java.util.ArrayList;
import model.Livro;

public final class CadastroLivro {

   private CadastroLivro(){}

   public static void adicionarLivro (ArrayList<Livro> listaLivros, Livro livro){
	  listaLivros.add(livro);
   }

   public static void mostrarLivrosDisponiveis(ArrayList<Livro> listaLivros){
       if(listaLivros.isEmpty()){
           System.out.println("Nenhum livro cadastrado. ");
           return;
       }
       for(Livro livro : listaLivros){
           System.out.println("- " +livro.getTitulo());
       }
   }

