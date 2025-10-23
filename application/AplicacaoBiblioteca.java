// Tenho explicações no Main, no Usuario, Repositório(nas duas classes) e no Emprestimo.


// Verifique todas as classes e verifiquem os getters e setters para ver o que está sendo o usando e o que não está.Cuidado pq tem classes que estão herdando de Usuario que estão usando alguns deles verifiquem isso direito. Recomendo usar o sistema de busca aqui do vscode para agilizar a busca.


package application;
import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;
import model.Bibliotecario;
import model.Professor;
import service.Cadastro;
import service.Login;

public class AplicacaoBiblioteca {
   public static void main(String[] args){
      int escolha,escolhaCadastro;
      String nome,cpf,email,telefone,matricula,senha;

      ArrayList<Aluno> alunos= new ArrayList<>();
      ArrayList<Professor> professores= new ArrayList<>();
      ArrayList<Bibliotecario> bibliotecarios= new ArrayList<>();

      Scanner entrada= new Scanner(System.in);
      
      do{
         System.out.println("---OPCOES---\n");
         System.out.println("1- Cadastrar.");
         System.out.println("2- Login");
         System.out.println("0- Encerrar");
         System.out.printf("Qual opcao deseja: ");
         escolha=entrada.nextInt();

         switch(escolha){
         case 1:
            System.out.println("Cadastrando.\n");
            
            do{
               System.out.println("Escolha o tipo de Cadastro:");
               System.out.println("1- Aluno");
               System.out.println("2- Professor");
               System.out.println("3- Bibliotecario");
               escolhaCadastro=entrada.nextInt();

               System.out.println("Passe suas Informações\n");

               System.out.printf("NOME: ");
               nome= entrada.next();

               System.out.printf("CPF: ");
               cpf= entrada.next();

               System.out.printf("EMAIL: ");
               email= entrada.next();

               System.out.printf("TELEFONE: ");
               telefone= entrada.next();

               System.out.printf("MATRICULA: ");
               matricula= entrada.next();

               System.out.printf("SENHA: ");
               senha= entrada.next();
            
               switch(escolhaCadastro){

                  case 1:
                     String curso;
                     System.out.printf("CURSO: ");
                     curso= entrada.next();
                     Aluno aluno=new Aluno(nome,cpf,email,telefone, matricula,senha, curso);
                     Cadastro.adicionarAluno(alunos, aluno);
                     break;

                  case 2:
                     String departamento;
                     System.out.printf("DEPARTAMENTO: ");
                     departamento = entrada.next();
                     Professor professor =new Professor(nome,cpf,email,telefone,matricula,senha,departamento);
                     Cadastro.adicionarProfessor(professores, professor);
                     break;

                  case 3:
                     Bibliotecario bibliotecario = new Bibliotecario(nome,cpf,email,telefone,matricula,senha);
                     Cadastro.adicionarBibliotecario(bibliotecarios, bibliotecario);
                     break;

                  default:
                     System.out.println("Opcao Invalida.");
                     System.out.println("Tente Novamente.\n");
                     break;
                     
               }

            }while(escolhaCadastro!=1 && escolhaCadastro!=2 && escolhaCadastro!= 3);
            break;

         case 2:
            
            System.out.println("Fazendo Login.\n");
            System.out.printf("EMAIL: ");
            email= entrada.next();
            Aluno testeA= Login.buscarAlunoPorEmail(alunos, email);
            Professor testeP = Login.buscarProfessorPorEmail(professores, email);
            Bibliotecario testeB = Login.buscarBibliotecarioPorEmail(bibliotecarios, email);

            int qtd=3;

            if(testeA== null && testeB== null && testeP == null){
               System.out.println("O email nao esta presente na lista.");
               System.out.println("faca o Cadastro");
               break;
            }
            // seria bom no cadastro adicionar algo que verifique se ja está na lista se não daqui para frente vair tudo dar BO.
            //mas isso pode ser feito mais para frente.
            //MAS BASICAMENTE E APARTIR DAQUI QUE COMEÇA REALMENTE A TER O ACESSO AO SISTEMA E PODER FAZER AS OPERAÇÕES
            //daqui para frente de varios else if onde cada um deles até o else vão ser a entrada para um sistema diferente ou seja um abiste diferente onde o testeA é o ambiente Aluno e testeB o ambiente bibliotecario e o testeP o do professor.
            else if(testeA!=null){
               
               do{

                  // Nessa parte é igual em todos só mudando a variavel teste(a/b/p). e essa parte vai basicamte só veerificar se a senha esta correta se estiver errada o cara tem 3 tentativas e acabar ele volta para a parte de cadastro/login e se estiver certo ele segue para em fim poder fazer as operações. 
                  System.out.printf("SENHA: ");
                  senha= entrada.next();

                  if(testeA.getSenha()!=senha){
                     System.out.printf("Senha errada.\n tente novamente.\n");
                     qtd--;
                     System.out.println("Quantidade de tentativas: " + qtd);
                  }

               }while(testeA.getSenha()==senha || qtd ==0);

               if(qtd==0){
                  System.out.println("Quantidade de tentativas superada.");
                  System.out.println("Tente novamente");
                  break;
               }
               else{
                  do{

                     System.out.println("Login realizado com sucesso.\n");
                     System.out.println("Operacoes:");
                     System.out.printf("1- Pedir livro emprestado.");

                     //Como eu acho que deveria ser feito isso:
                     // Eu acho que ao realizar um emprestimo seria criado um objeto do tipo emprestivo e seria adicionado a uma array de emprestimos realizados e reduziria a quantidade de emprestimos do ususario em 1 (ele só poderia fazer o emprestimo se a quantidade fosse maior que 0). Ai deveria funcionar da seguinte forma quando o usuario for devolver vai verificar a data de devolução se ela ta no prazo se estiver ai beleza devolver e remove esse emprestimo da lista e almenta o numero de livros que o cara pode pedir em 1.Porém se o prazo fosse além da data estipulada (que pode ser um prazo padronizado de uma semana apartir da data de emprestimo, por exemplo) Ia ser feito o calculo da multa e removeria da lista o Emprestimo. Ai nesse ponto tem uma questão se fizermos a multa ficar na classe emprestimo teriamos que impedir que ele devolvesse o livro sem pagar ,ou seja , se ele atrassace ele só poderia devolver o livro pagando, pois se não for feito assim vc vai remover o emprestimo da lista o dado vai se perder e não vai ter multa. Porém eu proponho que mudemos a parte de multa de Emprestimo para Usuario. daí dentro de emprestimo poderia ter só um método para calcular a multa e retornar para o atributo multa de usuario(Aluno/Professor/Bibliotecario), sendo assim poderiamos remover o emprestimmo da lista sem problemas e poderiamos usar a multa que está dentro do usuario para impedir que seja reservados livros sem ter as multas pagas.

                     System.out.printf("2- Ver Livros disponiveis.");
                     System.out.printf("3- Devolver livro.");
                     System.out.printf("4- Renovar livro");
                     System.out.printf("5- Ver multas.");
                     System.out.printf("6- Ver dados dos livros pegos");
                     System.out.println("0- Encerrar execucao.");
                     System.out.printf("Qual opcao deseja realizar: ");
                     escolhaCadastro=entrada.nextInt();

                     switch(escolhaCadastro){
                        //Eu utilizei a mesma variavel escolhaCadastro para caso o usuario escolha a opcao zero ele ja encerra o program por completo sem ter que ir para  a tela de Cadastro/Login/Encerrar.

                        //Aqui vão ficar os case para realizar as operações.

                        //case 1:
                        //...
                     }


                  }while(escolhaCadastro!=0);
                  

               }
               

            }
            else if(testeB!=null){
               
               do{
                  System.out.printf("SENHA: ");
                  senha= entrada.next();

                  if(testeB.getSenha()!=senha){
                     System.out.printf("Senha errada.\n tente novamente.\n");
                     qtd--;
                     System.out.println("Quantidade de tentativas: " + qtd);
                  }

               }while(testeB.getSenha()==senha || qtd ==0);

               if(qtd==0){
                  System.out.println("Quantidade de tentativas superada.");
                  System.out.println("Tente novamente");
                  break;
               }
               else{
                  do{

                     System.out.println("Login realizado com sucesso.\n");
                     System.out.println("Operacoes:");
                     System.out.printf("1- Pedir livro emprestado.");
                     System.out.printf("2- Ver Livros disponiveis.");
                     System.out.printf("3- Devolver livro.");
                     System.out.printf("4- Renovar livro");
                     System.out.printf("5- Ver multas.");
                     System.out.printf("6- Ver dados dos livros pegos");
                     System.out.printf("7- Ver Usuarios Cadastrados.");
                     System.out.printf("8- Cancelar Cadastro de Usuario.");
                     System.out.printf("9- Ver livros cadastrados.");
                     System.out.printf("10- Cadastrar livros.");
                     System.out.printf("11- Remover livro de acervo");
                     System.out.printf("12- Ver lista de emprestimos realizados");
                     System.out.println("0- Encerrar execucao.");
                     System.out.printf("Qual opcao deseja realizar: ");
                     escolhaCadastro=entrada.nextInt();

                     switch(escolhaCadastro){
                        
                        // aqui no caso o bibliotecario tem bem mais operações inicialmente como estamos tratando de um prototipo podemo adicionar apenar a operação de adicionar livros / remover livros do acervo e ver usuarios cadastrados.

                        //Aqui vão ficar os case para realizar as operações.

                        //case 1:
                        //...
                     }


                  }while(escolhaCadastro!=0);

               }

            }
            else{
                do{
                  System.out.printf("SENHA: ");
                  senha= entrada.next();

                  if(testeP.getSenha()!=senha){
                     System.out.printf("Senha errada.\n tente novamente.\n");
                     qtd--;
                     System.out.println("Quantidade de tentativas: " + qtd);
                  }

               }while(testeP.getSenha()==senha || qtd ==0);

               if(qtd==0){
                  System.out.println("Quantidade de tentativas superada.");
                  System.out.println("Tente novamente");
                  break;
               }
               else{
                  do{

                     System.out.println("Login realizado com sucesso.\n");
                     System.out.println("Operacoes:");
                     System.out.printf("1- Pedir livro emprestado.");
                     System.out.printf("2- Ver Livros disponiveis.");
                     System.out.printf("3- Devolver livro.");
                     System.out.printf("4- Renovar livro");
                     System.out.printf("5- Ver multas.");
                     System.out.printf("6- Ver dados dos livros pegos");
                     System.out.println("0- Encerrar execucao.");
                     System.out.printf("Qual opcao deseja realizar: ");
                     escolhaCadastro=entrada.nextInt();

                     switch(escolhaCadastro){
                        // O professor tem as mesmas operações que os alunos. So vai mudar mesmo quando for pegar livros emprestados que ele vai ter um limite maior.

                        //Aqui vão ficar os case para realizar as operações.

                        //case 1:
                        //...
                     }


                  }while(escolhaCadastro!=0);
                  
               }

            }
            

            System.out.printf("SENHA: ");
            senha= entrada.next();

            
            break;

         case 0:
            System.out.println("Encerrando programa.\n");
            entrada.close();
            break;

         default:
            System.out.println("Opção invalida.\n");
            break;
         }
      }while(escolha!=0);

      entrada.close();

   }
   
}
