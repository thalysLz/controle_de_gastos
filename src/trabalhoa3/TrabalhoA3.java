package trabalhoa3; a
import java.util.Scanner;
//@author Thalys
public class TrabalhoA3 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        funcao fuct = new funcao();

        String nome;
        int escolha;
        double salario;

        // Entrada do Nome    
        System.out.println("Digite seu nome:");
        nome = entrada.nextLine();

        // Entrada do salário (validação)
        do {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Digite seu salário:");
            salario = entrada.nextDouble();
            if (salario <= 0) {
                System.out.println("Salário inválido. Tente novamente.");
            }
        } while (salario <= 0);

        // Boas-Vindas    
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Olá, " + nome + ", seja bem-vindo!");
        System.out.println("O que deseja fazer hoje?");

        // Menu de opções
        do {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("1. Planejamento Financeiro.");
            System.out.println("2. Registro de Movimentações.");
            System.out.println("3. Extrato Financeiro.");
            System.out.println("-1. Sair.");
            System.out.println("-------------------------------------------------------------------------------");

            escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    fuct.planejamentoFinanceiro(salario);
                    break;
                case 2:
                    //fuct.registroMovimentacoes(); 
                    break;
                case 3:
                    //fuct.extratoFinanceiro();
                    break;
                case -1:
                    System.out.println("Saindo... Até a proxima "+nome+"!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != -1);
    }
}
