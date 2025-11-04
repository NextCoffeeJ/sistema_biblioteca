package service;

import java.util.ArrayList;
import model.Livro;

public final class CadastroLivro {

    private CadastroLivro(){}

    public static void adicionarLivro (ArrayList<Livro> listaLivros, Livro livro){
        listaLivros.add(livro);
    }
}