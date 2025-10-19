package application;
import java.util.Scanner;

public class AplicacaoBiblioteca {
   public static void main(String[] args){
      int escolha;
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
            break;

         case 2:
            System.out.println("Faxendo Login.\n");
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

   }
   
}
