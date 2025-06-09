package trabalhoa3;
//import
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class funcao {

    Scanner entrada = new Scanner(System.in);

    //planejamento financeiro
    public void planejamentoFinanceiro(double salario) {
        
        //variaveis.
        String Continuar;
        double Salario, DespesasEs, Investimentos, GastosL;
        Salario = salario;
        
        //iniciando painel de planejamento.
        System.out.println(" ");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(" ");
        System.out.println("PLANEJAMENTO FINANCEIRO");
        System.out.println("Salário informado: R$ " + String.format("%.2f", salario));
        
        // cálculo.
        DespesasEs = (salario * 0.5);
        Investimentos = (salario * 0.3);
        GastosL = (salario * 0.2);

        // resultado.
        System.out.println(" ");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(" ");
        System.out.println("Distribuição sugerida:");
        System.out.println("Despesas Essenciais (50%):        R$ " + String.format("%.2f", DespesasEs));
        System.out.println("Investimentos/Poupança (30%):     R$ " + String.format("%.2f", Investimentos));
        System.out.println("Gastos Livres (20%):              R$ " + String.format("%.2f", GastosL));

        //Pausa dramatica
        System.out.println(" ");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(" ");
        System.out.print("Aperte enter para continuar.");
        Continuar = entrada.nextLine();
        System.out.println(" ");
    }

    //banco de dados em txt.
    public void salvarTransacaoEmArquivo(String descricao, double valor, boolean isGanho, int mes, int ano) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter("transacoes.txt", true); // true = modo append
            java.io.PrintWriter pw = new java.io.PrintWriter(fw);
            pw.println(ano + ";" + mes + ";" + isGanho + ";" + descricao + ";" + valor);
            pw.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar a transação: " + e.getMessage());
        }
    }

    //função de registro de movimentações.
    public void RegistrodeMovimentações() {

        // Variáveis
        int escolha = 0;
        double valorGasto = 0.0;
        double totalGanhos = 0.0;
        double totalGastos = 0.0;

        //iniciando painel de registro de movimentção.
        System.out.println(" ");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(" ");
        System.out.println("REGISTRO DE MOVIMENTAÇÕES FINANCEIRAS");
        
        //menu de opções.
        do {
            System.out.println(" ");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(" ");
            System.out.println("MENU DE OPÇÕES:");
            System.out.println(" ");
            System.out.println("1 - Adicionar Ganhos Extras.");
            System.out.println("2 - Adicionar Gastos.");
            System.out.println("0 - Voltar.");
            System.out.println(" ");
            System.out.print("Digite sua escolha: ");
            
            //entrada da escolha.
            if (entrada.hasNextInt()) {
                escolha = entrada.nextInt();
                entrada.nextLine();
                
                //tratamento de exceções.
                if (escolha < 0 || escolha > 2) {
                    System.out.println(" ");
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println("Opção inválida! Digite 0, 1 ou 2.");
                    continue;
                }
            } else {
                System.out.println(" ");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("Entrada inválida! Digite apenas números.");
                entrada.nextLine();
                continue;
            }
            
            //resultado das escolhas.
            switch (escolha) {
                
                // voltar.
               case 0: 
                    System.out.println("");
                    System.out.println("voltando para o menu inicial...");
                   break;

               //registro do ganho.
               case 1:
                    System.out.println(" ");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println(" ");     
                    System.out.println("Opção 1 selecionada — GANHOS EXTRAS");
                    double valorGanho = 0.0;
                    
                    //entrada do ganho.
                    while (true) {
                        System.out.println(" ");
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println(" ");
                        System.out.print("Digite o valor do ganho: ");
                        if (entrada.hasNextDouble()) {
                            valorGanho = entrada.nextDouble();
                            entrada.nextLine();
                            
                            //tratamento de exceção.
                            if (valorGanho > 0) break;
                            else
                            System.out.println("O valor deve ser maior que zero!");
                        } else {
                            System.out.println("Entrada inválida! Digite um número válido.");
                            entrada.nextLine();
                        }
                    }
                    
                    //descrição do ganho.
                    System.out.println(" ");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println(" ");
                    System.out.print("Descrição do ganho: ");
                    String descricaoGanho = entrada.nextLine();
                    
                    //entrada da data de ganho.
                    System.out.println(" ");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println(" ");
                    System.out.print("Informe o mês e o ano da transação (MM/AA): ");
                    String dataGanho = entrada.nextLine();
                    String[] partesGanho = dataGanho.split("/");
                    int mesG = Integer.parseInt(partesGanho[0]);
                    int anoG = 2000 + Integer.parseInt(partesGanho[1]);
                    
                    //salvando resposta em txt.
                    salvarTransacaoEmArquivo(descricaoGanho, valorGanho, true, mesG, anoG);
                    
                    //mostrando como as infomações foram salvas.
                    System.out.println(" ");
                    System.out.println("Ganho de R$ " + String.format("%.2f", valorGanho) +
                            " adicionado com descrição: \"" + descricaoGanho + "\"");
                    break;

                case 2:
                
                //registro de gasto.
                    System.out.println("");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println(" ");
                    System.out.println("Opção 2 selecionada — GASTOS");
                    
                    //entrada do gasto.
                    while (true) {
                        System.out.println(" ");
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println(" ");
                        System.out.print("Digite o valor do gasto: ");
                        if (entrada.hasNextDouble()) {
                            valorGasto = entrada.nextDouble();
                            entrada.nextLine();
                            
                            //tratamento de exceção.
                            if (valorGasto > 0) break;
                            else System.out.println("O valor deve ser maior que zero!");
                        } else {
                            System.out.println("Entrada inválida! Digite um número válido.");
                            entrada.nextLine();
                        }
                    }
                    //entrada da descrição do gasto.
                    System.out.println(" ");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println(" ");
                    System.out.print("Descrição do gasto: ");
                    String descricaoGasto = entrada.nextLine();
                    
                    //enrtrada da data do gasto.
                    System.out.println(" ");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println(" ");
                    System.out.print("Informe o mês e o ano da transação (MM/AA): ");
                    String dataGasto = entrada.nextLine();
                    String[] partesGasto = dataGasto.split("/");
                    int mes = Integer.parseInt(partesGasto[0]);
                    int ano = 2000 + Integer.parseInt(partesGasto[1]);
                    
                    //salvando em txt
                    salvarTransacaoEmArquivo(descricaoGasto, valorGasto, false, mes, ano);
                    
                    //mostrando como as informações foram salvas.
                    System.out.println(" ");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println(" ");
                    System.out.println("Gasto de R$ " + String.format("%.2f", valorGasto) +
                            " adicionado com descrição: \"" + descricaoGasto + "\"");
                    break;
                
            }

        } while (escolha != 0);
        System.out.println(" ");
    }

    //função para menu do extrato financeiro.
public void menuTransacoes() {
    
    Scanner scanner = new Scanner(System.in);
    
    ExtratoFinanceiro extrato = new ExtratoFinanceiro();
    int opcao;
    int mes, ano;
    
    do {
        System.out.println(" ");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(" ");
        System.out.println("MENU TRANSAÇÕES");
        System.out.println(" ");
        System.out.println("1 - Ver transações por mês");
        System.out.println("2 - Ver resumo por mês");
        System.out.println("0 - Voltar");
        System.out.println(" ");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();
        
        //resultado da escolha.
        switch (opcao) {
            
            //voltar.
            case 0: 
                System.out.println("");
                System.out.println("voltando para o menu inicial...");
                break;
                
            //recebe a data da consulta.    
            case 1:
                System.out.println(" ");
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println(" ");
                System.out.print("Informe o mês e o ano para consulta (MM/AA): ");
                String dataInput = scanner.nextLine();
                String[] partes = dataInput.split("/");
                mes = Integer.parseInt(partes[0]);
                ano = 2000 + Integer.parseInt(partes[1]);
                System.out.println(" ");
                System.out.println("\nTransações do mês " + mes + "/" + ano + ":");
                System.out.println(" ");
                extrato.listarTransacoes(mes, ano);
                break;
            
            //recebe a data para resumo.
            case 2:
                System.out.println(" ");
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println(" ");
                System.out.print("Informe o mês e o ano para resumo (MM/AA): ");
                String dataResumo = scanner.nextLine();
                String[] partesResumo = dataResumo.split("/");
                mes = Integer.parseInt(partesResumo[0]);
                ano = 2000 + Integer.parseInt(partesResumo[1]);
                System.out.println();
                extrato.mostrarResumoMensal(mes, ano);
                break;
                
            //tratamento de exceções.
            default:
                System.out.println(" ");
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
    } while (opcao != 0);
}

    // Classes internas
    class Transacao {
        private String descricao;
        private double valor;
        private boolean isGanho;
        private int mes;
        private int ano;

        public Transacao(String descricao, double valor, boolean isGanho, int mes, int ano) {
            this.descricao = descricao;
            this.valor = valor;
            this.isGanho = isGanho;
            this.mes = mes;
            this.ano = ano;
        }

        public double getValor() { return valor; }
        public boolean isGanho() { return isGanho; }
        public String getDescricao() { return descricao; }
        public int getMes() { return mes; }
        public int getAno() { return ano; }
    }

    //extratofinanceiro
    class ExtratoFinanceiro {
        private List<Transacao> transacoes = new ArrayList<>();

        public ExtratoFinanceiro() {
            carregarTransacoesDoArquivo();
        }

        public void adicionarTransacao(String descricao, double valor, boolean isGanho, int mes, int ano) {
            transacoes.add(new Transacao(descricao, valor, isGanho, mes, ano));
        }

        public List<Transacao> getTransacoesPorMesAno(int mes, int ano) {
            List<Transacao> resultado = new ArrayList<>();
            for (Transacao t : transacoes) {
                if (t.getMes() == mes && t.getAno() == ano) {
                    resultado.add(t);
                }
            }
            return resultado;
        }

        public double calcularTotalGanhos(int mes, int ano) {
            double total = 0;
            for (Transacao t : getTransacoesPorMesAno(mes, ano)) {
                if (t.isGanho()) total += t.getValor();
            }
            return total;
        }

        public double calcularTotalGastos(int mes, int ano) {
            double total = 0;
            for (Transacao t : getTransacoesPorMesAno(mes, ano)) {
                if (!t.isGanho()) total += t.getValor();
            }
            return total;
        }

        public void mostrarResumoMensal(int mes, int ano) {
            double ganhos = calcularTotalGanhos(mes, ano);
            double gastos = calcularTotalGastos(mes, ano);
            System.out.printf("Resumo %02d/%d - Ganhos: R$ %.2f | Gastos: R$ %.2f | Saldo: R$ %.2f%n",
                mes, ano, ganhos, gastos, ganhos - gastos);
        }

        public void listarTransacoes(int mes, int ano) {
            List<Transacao> lista = getTransacoesPorMesAno(mes, ano);
            if (lista.isEmpty()) {
                System.out.println("Nenhuma transação encontrada para este mês.");
                return;
            }
            for (Transacao t : lista) {
                System.out.printf("[%s] %s: R$ %.2f%n",
                        t.isGanho() ? "Ganho" : "Gasto",
                        t.getDescricao(),
                        t.getValor());
            }
        }

        public void carregarTransacoesDoArquivo() {
            transacoes.clear();
            try {
                java.io.File arquivo = new java.io.File("transacoes.txt");
                if (!arquivo.exists()) return;

                java.util.Scanner leitor = new java.util.Scanner(arquivo);

                while (leitor.hasNextLine()) {
                    String linha = leitor.nextLine();
                    String[] partes = linha.split(";");
                    if (partes.length == 5) {
                        int ano = Integer.parseInt(partes[0]);
                        int mes = Integer.parseInt(partes[1]);
                        boolean isGanho = Boolean.parseBoolean(partes[2]);
                        String descricao = partes[3];
                        double valor = Double.parseDouble(partes[4]);

                        transacoes.add(new Transacao(descricao, valor, isGanho, mes, ano));
                    }
                }

                leitor.close();
            } catch (Exception e) {
                System.out.println("Erro ao carregar as transações: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
