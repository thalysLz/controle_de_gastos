package trabalhoa3;
import java.util.Scanner;

// @author Thalys
public class TrabalhoA3 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        funcao fuct = new funcao();
        
        //variaveis.
        String nome;
        int escolha = -1;
        double salario = -1;
        
        //entrada do nome de usuario.
        while(true){  
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(" ");
        System.out.print("Digite seu nome: ");
        nome = entrada.nextLine();
        
            //tratamento de exceções.
            if (nome.isEmpty()) {
                System.out.println("O nome não pode estar vazio.");
            } else if (nome.matches("\\d+")) {
                System.out.println("O nome não pode conter apenas números.");
            } else{
                break;
        }
    }   
       

        // Entrada do salário.
        do {
            System.out.println(" ");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"); 
            System.out.println(" ");
            System.out.print("Digite seu salário: ");

            //tratamento de exceções.
            if (entrada.hasNextDouble()) {
                salario = entrada.nextDouble();
                if (salario <= 0) {
                    System.out.println(" ");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println(" ");
                    System.out.println("Valor inválido. O salário deve ser maior que zero.");
                }
            } else {
                System.out.println(" ");
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println(" ");
                System.out.println("Entrada inválida! Digite um valor numérico.");
                entrada.nextLine();
            }
        } while (salario <= 0);

        // Bem vindo.
        System.out.println(" ");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(" ");
        System.out.println("Olá, " + nome + "! Seja bem-vindo(a) ao seu Gerenciador Financeiro.");
        System.out.println(" ");
        
        
        //painel de controle.
        do {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(" ");
            System.out.println("MENU PRINCIPAL");
            System.out.println(" ");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(" ");
            System.out.println("Escolha uma opção abaixo para continuar:");
            System.out.println(" ");
            System.out.println("1 - Planejamento Financeiro");
            System.out.println("2 - Registro de Movimentações");
            System.out.println("3 - Extrato Financeiro");
            System.out.println("0 - Sair");
            System.out.println(" ");
            System.out.print("Digite sua escolha: ");
            
            //resultado das escolhas.
            if (entrada.hasNextInt()) {
                escolha = entrada.nextInt();

                switch (escolha) {
                    case 1:
                        fuct.planejamentoFinanceiro(salario);
                        break;
                    case 2:
                        fuct.RegistrodeMovimentações();
                        break;
                    case 3:
                        fuct.menuTransacoes();
                        break;
                        
                    //saida do loop (sistema).
                    case 0:
                        System.out.println(" ");
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println(" ");
                        System.out.println("\nEncerrando... Até a próxima, " + nome + "!");
                        break;
                        
                    //tratamento de exceções.
                    default:
                        System.out.println(" ");
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println(" ");
                        System.out.println("Opção inválida. Digite um número entre as opções do menu.");
                        System.out.println(" ");
                }
            //tratamento de exceções.
            } else {
                System.out.println(" ");
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println(" ");
                System.out.println("Entrada inválida! Digite apenas números.");
                System.out.println(" ");
                entrada.nextLine();
                continue;
            }

        } while (escolha != 0);

    }
}