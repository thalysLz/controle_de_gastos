package trabalhoa3;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class funcao {

    Scanner entrada = new Scanner(System.in);
    
    //função de planejamento financeiro
    public void planejamentoFinanceiro(double salario) {
        //variaveis.
        String Continuar;
        double Salario, DespesasEs, Investimentos, GastosL;
        Salario = salario;

        // função está iniciando.
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("PLANEJAMENTO FINANCEIRO");
        System.out.println("Salário informado: R$ " + String.format("%.2f", salario));        

        // cálculo.
        DespesasEs = (salario * 0.5);
        Investimentos = (salario * 0.3);
        GastosL = (salario * 0.2);

        // resultado.
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Distribuição sugerida:");
        System.out.println("Despesas Essenciais (50%):        R$ " + String.format("%.2f", DespesasEs));
        System.out.println("Investimentos/Poupança (30%):     R$ " + String.format("%.2f", Investimentos));
        System.out.println("Gastos Livres (20%):              R$ " + String.format("%.2f", GastosL));
        
        //Pauso dramatica
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.print("Aperte enter para continuar.");
        Continuar = entrada.nextLine();
    }
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
    
    
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    System.out.println("REGISTRO DE MOVIMENTAÇÕES FINANCEIRAS");
    do {
        // Menu de opções
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("MENU DE OPÇÕES:");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("1 - Adicionar Ganhos Extras.");
        System.out.println("2 - Adicionar Gastos.");
        System.out.println("0 - Voltar.");
        System.out.print("Digite sua escolha: ");
        
        // Leitura da escolha
        if (entrada.hasNextInt()) {
            escolha = entrada.nextInt();
            entrada.nextLine();

            if (escolha < 0 || escolha > 2) {
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("Opção inválida! Digite 0, 1 ou 2.");
                continue;
            }
        } else {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Entrada inválida! Digite apenas números.");
            entrada.nextLine();
            continue;
        }
        
        switch (escolha) {

            case 1:
               System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
               System.out.println("Opção 1 selecionada — GANHOS EXTRAS");
                double valorGanho = 0.0;

                while (true) {
                    System.out.print("Digite o valor do ganho (maior que 0): ");
                    if (entrada.hasNextDouble()) {
                        valorGanho = entrada.nextDouble();
                        entrada.nextLine();

                        if (valorGanho > 0) break;
                        else 
                            System.out.println("O valor deve ser maior que zero!");
                    } else {
                        System.out.println("Entrada inválida! Digite um número válido.");
                        entrada.nextLine();
                    }
                }

                System.out.print("Descrição do ganho: ");
                String descricaoGanho = entrada.nextLine();

                System.out.print("Informe o mês da transação: ");
                int mes = entrada.nextInt();

                System.out.print("Informe o ano da transação: ");
                int ano = entrada.nextInt();
                entrada.nextLine(); // limpar buffer

                // Salvar no arquivo
                salvarTransacaoEmArquivo(descricaoGanho, valorGanho, true, mes, ano);

                System.out.println("Ganho de R$ " + String.format("%.2f", valorGanho) +
                        " adicionado com descrição: \"" + descricaoGanho + "\"");
                break;
    
            case 2:
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("Opção 2 selecionada — GASTOS");

                while (true) {
                    System.out.print("Digite o valor do gasto (maior que 0): ");
                    if (entrada.hasNextDouble()) {
                        valorGasto = entrada.nextDouble();
                        entrada.nextLine();

                        if (valorGasto > 0) break;
                        else System.out.println("O valor deve ser maior que zero!");
                    } else {
                        System.out.println("Entrada inválida! Digite um número válido.");
                        entrada.nextLine();
                    }
                }

                System.out.print("Descrição do gasto: ");
                String descricaoGasto = entrada.nextLine();

                System.out.print("Informe o mês da transação: ");
                int Mes = entrada.nextInt();

                System.out.print("Informe o ano da transação: ");
                int Ano = entrada.nextInt();
                entrada.nextLine(); // limpar o buffer

                // Salvar no arquivo
                salvarTransacaoEmArquivo(descricaoGasto, valorGasto, false, Mes, Ano);

                System.out.println("Gasto de R$ " + String.format("%.2f", valorGasto) +
                        " adicionado com descrição: \"" + descricaoGasto + "\"");

        }

    } while (escolha != 0);
}

    // Nova função para menu do extrato financeiro
    public void menuTransacoes() {
        Scanner scanner = new Scanner(System.in);
        ExtratoFinanceiro extrato = new ExtratoFinanceiro();

            int opcao;
    do {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("      MENU TRANSAÇÕES     ");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("1 - Ver transações por mês");
        System.out.println("2 - Ver resumo por mês");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        int mes, ano;
        switch (opcao) {
            case 1:
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.print("Informe o mês para consulta: ");
                mes = scanner.nextInt();
                System.out.print("Informe o ano para consulta: ");
                ano = scanner.nextInt();
                scanner.nextLine(); // Limpa buffer
                System.out.println("\nTransações do mês " + mes + "/" + ano + ":");
                extrato.listarTransacoes(mes, ano);
                break;
            case 2:
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.print("Informe o mês para resumo: ");
                mes = scanner.nextInt();
                System.out.print("Informe o ano para resumo: ");
                ano = scanner.nextInt();
                scanner.nextLine(); // Limpa buffer
                System.out.println();
                extrato.mostrarResumoMensal(mes, ano);
                break;
            default:
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("Opção inválida, tente novamente.");
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

    class ExtratoFinanceiro {
        private List<Transacao> transacoes = new ArrayList<>();

        // Construtor que já carrega as transações do arquivo ao criar o objeto
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
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.printf("Resumo %02d/%d - Ganhos: R$ %.2f | Gastos: R$ %.2f | Saldo: R$ %.2f%n",
                mes, ano, ganhos, gastos, ganhos - gastos);
        }

        public void listarTransacoes(int mes, int ano) {
            List<Transacao> lista = getTransacoesPorMesAno(mes, ano);
            if (lista.isEmpty()) {
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("Nenhuma transação encontrada para este mês.");
                return;
            }
            for (Transacao t : lista) {
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.printf("[%s] %s: R$ %.2f%n",
                        t.isGanho() ? "Ganho" : "Gasto",
                        t.getDescricao(),
                        t.getValor());
            }
        }

        // Método que lê o arquivo transacoes.txt e carrega as transações na lista
        public void carregarTransacoesDoArquivo() {
            transacoes.clear(); // Limpa a lista antes de carregar
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