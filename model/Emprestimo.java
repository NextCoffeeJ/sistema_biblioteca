package model;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataLimiteDevolucao;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataLimiteDevolucao) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataLimiteDevolucao = dataLimiteDevolucao;
        this.dataDevolucao = null;
    }


    public Usuario getUsuario() { return usuario; }
    public Livro getLivro() { return livro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataLimiteDevolucao() { return dataLimiteDevolucao; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setLivro(Livro livro) { this.livro = livro; }
    public void setDataEmprestimo(LocalDate dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }
    public void setDataLimiteDevolucao(LocalDate dataLimiteDevolucao) { this.dataLimiteDevolucao = dataLimiteDevolucao; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }


    public boolean isAtrasado() {
        if (dataDevolucao == null) {
            return LocalDate.now().isAfter(dataLimiteDevolucao);
        }
        return dataDevolucao.isAfter(dataLimiteDevolucao);
    }

}