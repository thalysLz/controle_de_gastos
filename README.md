# 💸 Gerenciador Financeiro — Java

Este é um sistema simples de **controle de gastos pessoais**, desenvolvido em Java, com funcionalidades como:
- Planejamento financeiro
- Registro de ganhos e despesas
- Geração de extrato financeiro via arquivo `.txt`

---

## 📁 Estrutura do Projeto

```
controle_de_gastos/
├── trabalhoa3/
│   ├── TrabalhoA3.java
│   └── funcao.java
├── transacoes.txt (gerado automaticamente)
```

---

## 🚀 Como Compilar e Executar

### Pré-requisitos:
- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) instalado (versão 8 ou superior)
- Terminal (Linux, Mac ou Windows CMD/Powershell)

### Passos:

1. **Abra o terminal na raiz do projeto**, onde está a pasta `trabalhoa3`.

2. **Compile os arquivos `.java`:**

```bash
javac trabalhoa3/*.java
```

3. **Execute o programa principal:**

```bash
java trabalhoa3.TrabalhoA3
```

---

## 📌 Funcionalidades

- **Planejamento Financeiro:** Sugestão de divisão do salário (50% despesas, 30% investimentos, 20% lazer).
- **Registro de Movimentações:** Adicione ganhos ou gastos, que são salvos no arquivo `transacoes.txt`.
- **Extrato Financeiro:** (opção disponível no menu, assumindo que o método `menuTransacoes()` implementa a leitura do extrato).

---

## 📝 Observações

- As transações são salvas em `transacoes.txt` no mesmo diretório de execução.
- O sistema funciona totalmente via **linha de comando** (terminal).
- O código está organizado no **pacote `trabalhoa3`**.

---

## 👨‍💻 Autor

Desenvolvido por **Thalys Lz** — [GitHub](https://github.com/thalysLz)
