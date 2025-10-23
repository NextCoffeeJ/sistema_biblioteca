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
      int escolha,escolhaCadastro,escolhaLogin;
      String nome,cpf,email,telefone,matricula,senha;


      ArrayList<Aluno> alunos= new ArrayList<>();
      ArrayList<Professor> professores= new ArrayList<>();
      ArrayList<Bibliotecario> bibliotecarios= new ArrayList<>();

      Scanner entrada= new Scanner(System.in);
      
      do{
         System.out.println("---OPCOES---\n");
         System.out.print("1- Cadastrar.");
         System.out.print("2- Login");
         System.out.println("0- Encerrar");
         System.out.print("Qual opcao deseja: ");
         escolha=entrada.nextInt();

         switch(escolha){
         case 1:
            System.out.println("Cadastrando.\n");
            
            do{
               System.out.println("Opcoes de Cadastro.\n");
               System.out.print("1- Aluno");
               System.out.print("2- Professor");
               System.out.println("3- Bibliotecario");
               System.out.print("Escolha o tipo de Cadastro: ");
               escolhaCadastro=entrada.nextInt();

               System.out.println("Passe suas Informações\n");

               System.out.print("NOME: ");
               nome= entrada.nextLine();

               System.out.print("CPF: ");
               cpf= entrada.nextLine();

               System.out.print("EMAIL: ");
               email= entrada.nextLine();

               System.out.print("TELEFONE: ");
               telefone= entrada.nextLine();

               System.out.print("MATRICULA: ");
               matricula= entrada.nextLine();

               System.out.print("SENHA: ");
               senha= entrada.nextLine();
            
               switch(escolhaCadastro){

                  case 1:
                     String curso;
                     System.out.print("CURSO: ");
                     curso= entrada.nextLine();
                     Aluno aluno=new Aluno(nome,cpf,email,telefone, matricula,senha, curso);
                     Cadastro.adicionarAluno(alunos, aluno);
                     break;

                  case 2:
                     String departamento;
                     System.out.print("DEPARTAMENTO: ");
                     departamento = entrada.nextLine();
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
            System.out.print("EMAIL: ");
            email= entrada.nextLine();
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
                  System.out.print("SENHA: ");
                  senha= entrada.nextLine();

                  if(!testeA.getSenha().equals(senha)){
                     System.out.print("Senha errada.\n tente novamente.\n");
                     qtd--;
                     System.out.println("Quantidade de tentativas: " + qtd);
                  }

               }while(testeA.getSenha().equals(senha) || qtd ==0);

               if(qtd==0){
                  System.out.println("Quantidade de tentativas superada.");
                  System.out.println("Tente novamente");
                  break;
               }
               else{
                  do{

                     System.out.println("Login realizado com sucesso.\n");
                     System.out.println("Operacoes:");
                     System.out.print("1- Pedir livro emprestado.");

                     //Como eu acho que deveria ser feito isso:
                     // Eu acho que ao realizar um emprestimo seria criado um objeto do tipo emprestivo e seria adicionado a uma array de emprestimos realizados e reduziria a quantidade de emprestimos do ususario em 1 (ele só poderia fazer o emprestimo se a quantidade fosse maior que 0). Ai deveria funcionar da seguinte forma quando o usuario for devolver vai verificar a data de devolução se ela ta no prazo se estiver ai beleza devolver e remove esse emprestimo da lista e almenta o numero de livros que o cara pode pedir em 1.Porém se o prazo fosse além da data estipulada (que pode ser um prazo padronizado de uma semana apartir da data de emprestimo, por exemplo) Ia ser feito o calculo da multa e removeria da lista o Emprestimo. Ai nesse ponto tem uma questão se fizermos a multa ficar na classe emprestimo teriamos que impedir que ele devolvesse o livro sem pagar ,ou seja , se ele atrassace ele só poderia devolver o livro pagando, pois se não for feito assim vc vai remover o emprestimo da lista o dado vai se perder e não vai ter multa. Porém eu proponho que mudemos a parte de multa de Emprestimo para Usuario. daí dentro de emprestimo poderia ter só um método para calcular a multa e retornar para o atributo multa de usuario(Aluno/Professor/Bibliotecario), sendo assim poderiamos remover o emprestimmo da lista sem problemas e poderiamos usar a multa que está dentro do usuario para impedir que seja reservados livros sem ter as multas pagas.

                     System.out.print("2- Ver Livros disponiveis.");
                     System.out.print("3- Devolver livro.");
                     System.out.print("4- Renovar livro");
                     System.out.print("5- Ver multas.");
                     System.out.print("6- Ver dados dos livros pegos");
                     System.out.print("7- Logout");
                     System.out.println("0- Encerrar execucao.");
                     System.out.print("Qual opcao deseja realizar: ");
                     escolhaLogin=entrada.nextInt();

                     switch(escolhaLogin){
                        //Eu utilizei a mesma variavel escolhaCadastro para caso o usuario escolha a opcao zero ele ja encerra o program por completo sem ter que ir para  a tela de Cadastro/Login/Encerrar.

                        //Aqui vão ficar os case para realizar as operações.

                        //case 1:
                        //...

                        case 1:
                           System.out.println("Pedindo livro emprestado.");
                           break;
                        case 2:
                           System.out.println("Vendo livros disponiveis.");
                           break;
                        case 3:
                           System.out.println("Devolvendo Livro.");
                           break;
                        case 4:
                           System.out.println("Renovando Livro.");
                           break;
                        case 5:
                           System.out.println("Vendo multas");
                           break;
                        case 6:
                           System.out.println("Vendo dados dos livros pegos.");
                           break;
                        case 7:
                           System.out.println("Logout realizado com sucesso.");
                           break;
                        case 0:
                           escolha=0;
                           break;
                        default:
                           System.out.println("Opcao invalida.");
                           break;
                     }


                  }while(escolhaLogin!=0 && escolhaLogin!=7);
                  

               }
               

            }
            else if(testeB!=null){
               
               do{
                  System.out.print("SENHA: ");
                  senha= entrada.nextLine();

                  if(!testeB.getSenha().equals(senha)){
                     System.out.print("Senha errada.\n tente novamente.\n");
                     qtd--;
                     System.out.println("Quantidade de tentativas: " + qtd);
                  }

               }while(testeB.getSenha().equals(senha) || qtd ==0);

               if(qtd==0){
                  System.out.println("Quantidade de tentativas superada.");
                  System.out.println("Tente novamente");
                  break;
               }
               else{
                  do{

                     System.out.println("Login realizado com sucesso.\n");
                     System.out.println("Operacoes:");
                     System.out.print("1- Pedir livro emprestado.");
                     System.out.print("2- Ver Livros disponiveis.");
                     System.out.print("3- Devolver livro.");
                     System.out.print("4- Renovar livro");
                     System.out.print("5- Ver multas.");
                     System.out.print("6- Ver dados dos livros pegos");
                     System.out.print("7- Logout");
                     System.out.print("8- Cancelar Cadastro de Usuario.");
                     System.out.print("9- Ver livros cadastrados.");
                     System.out.print("10- Cadastrar livros.");
                     System.out.print("11- Remover livro de acervo");
                     System.out.print("12- Ver lista de emprestimos realizados");
                     System.out.print("13- Ver Usuarios Cadastrados.");
                     System.out.println("0- Encerrar execucao.");
                     System.out.print("Qual opcao deseja realizar: ");
                     escolhaLogin=entrada.nextInt();

                     switch(escolhaLogin){
                        
                        // aqui no caso o bibliotecario tem bem mais operações inicialmente como estamos tratando de um prototipo podemo adicionar apenar a operação de adicionar livros / remover livros do acervo e ver usuarios cadastrados.

                        //Aqui vão ficar os case para realizar as operações.

                        // Para a entrega de amanhã acho que inicialmente só precisamos imprementar o case 8 e 13.
                        case 1:
                           System.out.println("Pedindo livro emprestado.");
                           break;
                        case 2:
                           System.out.println("Vendo livros disponiveis.");
                           break;
                        case 3:
                           System.out.println("Devolvendo Livro.");
                           break;
                        case 4:
                           System.out.println("Renovando Livro.");
                           break;
                        case 5:
                           System.out.println("Vendo multas");
                           break;
                        case 6:
                           System.out.println("Vendo dados dos livros pegos.");
                           break;
                        case 7:
                           System.out.println("Logout realizado com sucesso.");
                           break;
                        case 8:
                           System.out.println("Cancelando Cadastro de Usuario.");
                           break;
                        case 9:
                           System.out.println("Ver livros Cadastrados");
                           break;
                        case 10:
                           System.out.println("Cadastrando livros.");
                           break;
                        case 11:
                           System.out.println("Removendo livro de acervo.");
                           break;
                        case 12:
                           System.out.println("Vendo usuarios Cadastrados.");
                           break;
                        case 0:
                           escolha=0;
                           break;
                        default:
                           System.out.println("Opcao invalida.");
                           break;
                     }


                  }while(escolhaLogin!=0 && escolhaLogin!=7);

               }

            }
            else{
                do{
                  System.out.print("SENHA: ");
                  senha= entrada.nextLine();

                  if(!testeP.getSenha().equals(senha)){
                     System.out.print("Senha errada.\n tente novamente.\n");
                     qtd--;
                     System.out.println("Quantidade de tentativas: " + qtd);
                  }

               }while(testeP.getSenha().equals(senha) || qtd ==0);

               if(qtd==0){
                  System.out.println("Quantidade de tentativas superada.");
                  System.out.println("Tente novamente");
                  break;
               }
               else{
                  do{

                     System.out.println("Login realizado com sucesso.\n");
                     System.out.println("Operacoes:");
                     System.out.print("1- Pedir livro emprestado.");
                     System.out.print("2- Ver Livros disponiveis.");
                     System.out.print("3- Devolver livro.");
                     System.out.print("4- Renovar livro");
                     System.out.print("5- Ver multas.");
                     System.out.print("6- Ver dados dos livros pegos");
                     System.out.print("7- Logout");
                     System.out.println("0- Encerrar execucao.");
                     System.out.print("Qual opcao deseja realizar: ");
                     escolhaLogin=entrada.nextInt();

                     switch(escolhaLogin){
                        // O professor tem as mesmas operações que os alunos. So vai mudar mesmo quando for pegar livros emprestados que ele vai ter um limite maior.

                        //Aqui vão ficar os case para realizar as operações.

                        //case 1:
                        //...
                        case 1:
                           System.out.println("Pedindo livro emprestado.");
                           break;
                        case 2:
                           System.out.println("Vendo livros disponiveis.");
                           break;
                        case 3:
                           System.out.println("Devolvendo Livro.");
                           break;
                        case 4:
                           System.out.println("Renovando Livro.");
                           break;
                        case 5:
                           System.out.println("Vendo multas");
                           break;
                        case 6:
                           System.out.println("Vendo dados dos livros pegos.");
                           break;
                        case 7:
                           System.out.println("Logout realizado com sucesso.");
                           break;
                        case 0:
                           escolha=0;
                           break;
                        default:
                           System.out.println("Opcao invalida.");
                           break;
                     }


                  }while(escolhaLogin!=0 && escolhaLogin!=7);
                  
               }

            }
            
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
