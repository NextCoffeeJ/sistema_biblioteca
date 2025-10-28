package model;

import java.time.LocalDate;

public class Emprestimo {
   private Aluno aluno;
   private Professor professor;
   private Bibliotecario bibliotecario;
   private Livro livro;
   private LocalDate dataEmprestimo;
   private LocalDate dataLimiteDevolucao;
   private LocalDate dataDevolucao;

   public Emprestimo(Aluno aluno, Livro livro, LocalDate dataEmprestimo, LocalDate dataLimiteDevolucao) {
	  this.aluno = aluno;
	  this.livro = livro;
	  this.dataEmprestimo = dataEmprestimo;
	  this.dataLimiteDevolucao = dataLimiteDevolucao;
	  this.dataDevolucao = null;
   }

   public Emprestimo(Professor professor, Livro livro, LocalDate dataEmprestimo, LocalDate dataLimiteDevolucao) {
	  this.professor = professor;
	  this.livro = livro;
	  this.dataEmprestimo = dataEmprestimo;
	  this.dataLimiteDevolucao = dataLimiteDevolucao;
	  this.dataDevolucao = null;
   }

   public Emprestimo(Bibliotecario bibliotecario, Livro livro, LocalDate dataEmprestimo, LocalDate dataLimiteDevolucao) {
	  this.bibliotecario = bibliotecario;
	  this.livro = livro;
	  this.dataEmprestimo = dataEmprestimo;
	  this.dataLimiteDevolucao = dataLimiteDevolucao;
	  this.dataDevolucao = null;
   }


   public Aluno getAluno() { return aluno; }
   public Professor getProfessor() { return professor;}
   public Bibliotecario getBibliotecario(){return bibliotecario;}
   public Livro getLivro() { return livro; }
   public LocalDate getDataEmprestimo() { return dataEmprestimo; }
   public LocalDate getDataLimiteDevolucao() { return dataLimiteDevolucao; }
   public LocalDate getDataDevolucao() { return dataDevolucao; }

   public void setAluno(Aluno aluno) { this.aluno = aluno; }
   public void setProfessor(Professor professor){this.professor=professor;}
   public void setBibliotecario(Bibliotecario bibliotecario){this.bibliotecario=bibliotecario;}
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
