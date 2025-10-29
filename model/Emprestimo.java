package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataLimiteDevolucao;
    private LocalDate dataDevolucao; 
    private int qtdRenovacoes;
    
    private static final int LIMITE_RENOVACOES = 1;
    private static final double MULTA_POR_DIA = 5.0; 

    public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataLimiteDevolucao) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataLimiteDevolucao = dataLimiteDevolucao;
        this.dataDevolucao = null; 
        this.qtdRenovacoes = 0;
    }

    
    public Usuario getUsuario() { return usuario; }
    public Livro getLivro() { return livro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataLimiteDevolucao() { return dataLimiteDevolucao; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public int getQtdRenovacoes() { return qtdRenovacoes; }

    
    public void registrarDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        this.qtdRenovacoes = 0; 
    }

    
    public boolean isAtrasado() {
        if (dataDevolucao == null) { 
            return LocalDate.now().isAfter(dataLimiteDevolucao);
        }
        return dataDevolucao.isAfter(dataLimiteDevolucao); 
    }

    
    public long getDiasAtraso() {
        LocalDate dataReferencia = (dataDevolucao != null) ? dataDevolucao : LocalDate.now();
        if (dataReferencia.isAfter(dataLimiteDevolucao)) {
            return ChronoUnit.DAYS.between(dataLimiteDevolucao, dataReferencia);
        }
        return 0;
    }

    
    public double getMulta() {
        return getDiasAtraso() * MULTA_POR_DIA;
    }

    
    public String getMultaFormatada() {
        return String.format("R$ %.2f", getMulta());
    }

    
    public boolean renovar() {
        if (qtdRenovacoes < LIMITE_RENOVACOES && dataDevolucao == null) {
            dataLimiteDevolucao = dataLimiteDevolucao.plusDays(10);
            qtdRenovacoes++;
            return true;
        }
        return false;
    }

    
    public String getStatus() {
        if (dataDevolucao != null) {
            return "Devolvido";
        } else if (isAtrasado()) {
            return "Atrasado";
        } else {
            return "Em andamento";
        }
    }

    @Override
    public String toString() {
        return "Empréstimo{" +
                "usuario=" + usuario.getNome() +
                ", livro=" + livro.getTitulo() +
                ", limite=" + dataLimiteDevolucao +
                ", devolvido=" + dataDevolucao +
                ", renovacoes=" + qtdRenovacoes +
                ", multa=" + getMultaFormatada() +
                ", status=" + getStatus() +
                '}';
    }
}
