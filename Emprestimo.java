import java.time.LocalDate;

public class Emprestimo {
   private Usuario usuario;
   private Livro livro;
   private LocalDate dataEmprestimo;
   private LocalDate dataLimiteDevolucao;
   private LocalDate dataDevolucao;
   private double multa;

   public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataLimiteDevolucao, LocalDate dataDevolucao, double multa) {
	  this.usuario = usuario;
	  this.livro = livro;
	  this.dataEmprestimo = dataEmprestimo;
	  this.dataLimiteDevolucao = dataLimiteDevolucao;
	  this.dataDevolucao = dataDevolucao;
	  this.multa = multa;
   }
}