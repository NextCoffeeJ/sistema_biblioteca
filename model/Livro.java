package model;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    private int anoPublicacao;
    private int qtdDisponivel;
    private String categoria;
    private String localizacao;

    public Livro(String titulo, String autor, String editora, String isbn, int anoPublicacao, int qtdDisponivel, String categoria, String localizacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.qtdDisponivel = Math.max(0, qtdDisponivel); 
        this.categoria = categoria;
        this.localizacao = localizacao;
    }

    
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getEditora() { return editora; }
    public String getIsbn() { return isbn; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public int getQtdDisponivel() { return qtdDisponivel; }
    public String getCategoria() { return categoria; }
    public String getLocalizacao() { return localizacao; }

    
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setEditora(String editora) { this.editora = editora; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    
    public boolean emprestar() {
        if (qtdDisponivel > 0) {
            qtdDisponivel--;
            return true;
        }
        return false; 
    }

    public void devolver() {
        qtdDisponivel++;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo + " | Autor: " + autor + 
               " | Ano: " + anoPublicacao + " | Disponíveis: " + qtdDisponivel;
    }
}
