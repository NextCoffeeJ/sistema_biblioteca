package model;

import java.time.LocalDate;

public class Emprestimo {
   private Usuario usuario;
   private Livro livro;
   private LocalDate dataEmprestimo;
   private LocalDate dataLimiteDevolucao;
   private LocalDate dataDevolucao;
   private double multa; //talvez remover isso daqui e colocar em Usuario. Explicação no main.

   public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataLimiteDevolucao, LocalDate dataDevolucao, double multa) {
	  this.usuario = usuario;
	  this.livro = livro;
	  this.dataEmprestimo = dataEmprestimo;
	  this.dataLimiteDevolucao = dataLimiteDevolucao;
	  this.dataDevolucao = dataDevolucao;
	  this.multa = multa;
   }

   public Usuario getUsuario() {
	  return usuario;
   }

   public Livro getLivro() {
	  return livro;
   }

   public LocalDate getDataEmprestimo() {
	  return dataEmprestimo;
   }

   public LocalDate getDataLimiteDevolucao() {
	  return dataLimiteDevolucao;
   }

   public LocalDate getDataDevolucao() {
	  return dataDevolucao;
   }

   public double getMulta() {
	  return multa;
   }

   public Emprestimo setUsuario(Usuario usuario) {
	  this.usuario = usuario;
	  return this;
   }

   public Emprestimo setLivro(Livro livro) {
	  this.livro = livro;
	  return this;
   }

   public void setDataEmprestimo(LocalDate dataEmprestimo) {
	  this.dataEmprestimo = dataEmprestimo;
   }

   public void setDataLimiteDevolucao(LocalDate dataLimiteDevolucao) {
	  this.dataLimiteDevolucao = dataLimiteDevolucao;
   }

   public void setDataDevolucao(LocalDate dataDevolucao) {
	  this.dataDevolucao = dataDevolucao;
   }

   public void setMulta(double multa) {
	  this.multa = multa;
   }
}
