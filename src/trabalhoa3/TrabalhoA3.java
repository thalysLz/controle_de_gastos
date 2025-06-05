package trabalhoa3;
import java.util.Scanner;

// @author Thalys
public class TrabalhoA3 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        funcao fuct = new funcao();

        String nome;
        int escolha = -1;
        double salario = -1;

        // Entrada do Nome    
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.print("Digite seu nome: ");
        nome = entrada.nextLine();

        // Entrada do salário (com validação robusta)
        do {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"); 
            System.out.print("Digite seu salário: ");

            if (entrada.hasNextDouble()) {
                salario = entrada.nextDouble();
                if (salario <= 0) {
                    System.out.println("Valor inválido. O salário deve ser maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida! Digite um valor numérico.");
                entrada.nextLine(); // limpar buffer
                salario = -1;
            }
        } while (salario <= 0);

        // Boas-Vindas    
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Olá, " + nome + "! Seja bem-vindo(a) ao seu Gerenciador Financeiro.");
        System.out.println("Escolha uma opção abaixo para continuar:");

        do {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("MENU PRINCIPAL");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("1 - Planejamento Financeiro");
            System.out.println("2 - Registro de Movimentações");
            System.out.println("3 - Extrato Financeiro");
            System.out.println("0 - Sair");
            System.out.print("Digite sua escolha: ");

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
                    case 0:
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println("\nEncerrando... Até a próxima, " + nome + "!");
                        break;
                    default:
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println("Opção inválida. Digite um número entre as opções do menu.");
                }
            } else {
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("Entrada inválida! Digite apenas números.");
                entrada.nextLine(); // limpa o buffer
                continue;
            }

        } while (escolha != 0);

        entrada.close(); // Boa prática: fechar o scanner
    }
}