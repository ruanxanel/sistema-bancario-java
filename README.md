# Sistema Bancário - Java

Sistema bancário em **Java** executado no terminal, com cadastro de clientes, abertura de contas, depósitos, saques, transferências e extrato.

O projeto tem como objetivo praticar **Programação Orientada a Objetos**, com herança, polimorfismo, encapsulamento e exceções personalizadas.

---

## Sobre o projeto

O sistema permite cadastrar clientes e abrir contas bancárias de dois tipos:

- **Conta Corrente** - possui limite de cheque especial (R$ 500 ao abrir a conta)
- **Conta Poupança** - possui taxa de rendimento (5% ao abrir a conta)

Todos os dados ficam armazenados em memória durante a execução do programa.

O projeto foi desenvolvido como parte dos meus estudos em **Java e Programação Orientada a Objetos**.

---

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos
- Scanner (entrada de dados pelo terminal)
- Collections (`ArrayList` e `List`)

---

## Estrutura do projeto

```
src/br/com/banco
├── Main.java
├── model
│   ├── Cliente.java
│   ├── Conta.java
│   ├── ContaCorrente.java
│   └── ContaPoupanca.java
├── service
│   └── Banco.java
└── exception
    ├── ContaNaoEncontradaException.java
    ├── SaldoInsuficienteException.java
    └── ValorInvalidoException.java
```

### Model

Contém as classes que representam as entidades do sistema.

- **Cliente**: nome, CPF, telefone, e-mail, endereço e lista de contas
- **Conta**: número, titular, saldo e extrato (classe base)
- **ContaCorrente**: herda de `Conta` e adiciona o limite de cheque especial
- **ContaPoupanca**: herda de `Conta` e adiciona a taxa de rendimento

### Service

A classe **Banco** centraliza as regras de negócio: cadastro e busca de clientes e contas, e transferências entre contas.

### Exception

Exceções personalizadas para tratar situações de negócio.

---

## Funcionalidades

### Menu de cadastros

- Cadastrar cliente
- Abrir conta corrente
- Abrir conta poupança

### Menu de operações

- **Depositar**: adiciona valor ao saldo da conta
- **Sacar**: retira valor do saldo (na conta corrente, considera o cheque especial)
- **Transferir**: transfere valor entre duas contas
- **Extrato**: exibe todas as movimentações e o saldo atual
- **Aplicar rendimento**: aplica a taxa de rendimento na conta poupança

---

## Tratamento de exceções

### Valor inválido

Ocorre quando o valor de um depósito ou saque é menor ou igual a zero.

```
ValorInvalidoException
```

### Saldo insuficiente

Ocorre quando o saque é maior que o saldo disponível (ou que o saldo somado ao limite, na conta corrente).

```
SaldoInsuficienteException
```

### Conta não encontrada

Ocorre quando uma transferência é feita para uma conta de origem ou destino que não existe.

```
ContaNaoEncontradaException
```

---

## Como executar

### Pré-requisitos

- JDK instalado (o `main` sem parâmetros utilizado no projeto exige uma versão recente do Java, como a 25)

### Passos

```bash
# Clonar o repositório
git clone https://github.com/ruanxanel/sistema-bancario-java.git

# Entrar na pasta do projeto
cd sistema-bancario-java

# Compilar
javac -d out $(find src -name "*.java")

# Executar
java -cp out br.com.banco.Main
```

Também é possível abrir o projeto em uma IDE como o IntelliJ IDEA e executar a classe `Main`.

---

## Conceitos praticados

Durante o desenvolvimento deste projeto foram praticados conceitos como:

- Programação Orientada a Objetos
- Classes e objetos
- Encapsulamento
- Herança
- Polimorfismo e sobrescrita de métodos
- Exceções personalizadas
- `try/catch` e `throws`
- Collections (`ArrayList`)
- Organização em pacotes
- Pattern matching com `instanceof`

---

## Objetivo

Este projeto faz parte da minha jornada de aprendizado em **desenvolvimento com Java**.

O objetivo é aplicar na prática os conceitos estudados e construir projetos para meu portfólio.

---

## Próximos passos

- [ ] Persistir os dados em banco de dados
- [ ] Validar CPF
- [ ] Impedir cadastro de clientes e contas duplicados
- [ ] Registrar o rendimento da poupança no extrato
- [ ] Tratar entradas inválidas no menu (letras no lugar de números)
- [ ] Criar testes automatizados
- [ ] Transformar em uma API REST com Spring Boot

---

## Autor

**Ruan Henrique**

Estudante de Ciência da Computação, focado em desenvolvimento Back-End com Java e Spring Boot.