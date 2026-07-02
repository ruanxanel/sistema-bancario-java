package br.com.banco;
import br.com.banco.model.Cliente;
import java.util.Scanner;
import br.com.banco.exception.ValorInvalidoException;
import br.com.banco.exception.SaldoInsuficienteException;
import br.com.banco.exception.ContaNaoEncontradaException;
import br.com.banco.model.Conta;
import br.com.banco.model.ContaCorrente;
import br.com.banco.model.ContaPoupanca;
import br.com.banco.service.Banco;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void menuCadastro(Banco banco) {
        String nome, cpf, tel, email, endereco;
        int numero;
        Cliente titular;

        while (true) {
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Abrir conta corrente");
            System.out.println("3 - Abrir conta poupança");
            System.out.println("0 - Voltar");
            System.out.print("Escolha operação: ");
            int operacao = in.nextInt();
            in.nextLine();

            switch (operacao) {
                case 1:
                    System.out.print("Nome: ");
                    nome = in.nextLine();

                    System.out.print("Cpf: ");
                    cpf = in.nextLine();

                    System.out.print("Telefone: ");
                    tel = in.nextLine();

                    System.out.print("Email: ");
                    email = in.nextLine();

                    System.out.print("Endereço: ");
                    endereco = in.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, tel, email, endereco);
                    banco.cadastrarCliente(cliente);
                    System.out.println("Cliente " + nome + " cadastrado");

                    break;
                case 2:
                    System.out.print("Cpf: ");
                    cpf = in.nextLine();

                    System.out.print("Numero: ");
                    numero = in.nextInt();
                    in.nextLine();

                    titular = banco.buscarCliente(cpf);

                    if (titular == null) {
                        System.out.println("Conta não encontrada");
                    } else {
                        ContaCorrente contaCorrente = new ContaCorrente(numero, titular, 0, 500);
                        banco.cadastrarConta(contaCorrente);
                        titular.adicionarConta(contaCorrente);
                        System.out.println("Conta corrente disponível com sucesso");
                    }
                    break;

                case 3:
                    System.out.print("Cpf: ");
                    cpf = in.nextLine();

                    System.out.print("Numero: ");
                    numero = in.nextInt();
                    in.nextLine();

                    titular = banco.buscarCliente(cpf);

                    if (titular == null) {
                        System.out.println("Conta não encontrada");
                    } else {
                        ContaPoupanca contaPoupanca = new ContaPoupanca(numero, titular, 0, 0.05);
                        banco.cadastrarConta(contaPoupanca);
                        titular.adicionarConta(contaPoupanca);
                        System.out.println("Conta poupança disponível com sucesso");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void menuOperacoes(Banco banco) {
        int numero, partida, chegada;
        double valor;
        Conta conta;

        while (true) {
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Extrato");
            System.out.println("5 - Aplicar rendimento");
            System.out.println("0 - Voltar");
            System.out.print("Escolha operação: ");
            int op = in.nextInt();
            in.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Numero da conta: ");
                    numero = in.nextInt();
                    in.nextLine();

                    conta = banco.buscarConta(numero);

                    if (conta == null) {
                        System.out.println("Conta não encontrada");
                    } else {
                        System.out.print("Valor: ");
                        valor = in.nextDouble();
                        in.nextLine();
                        try {
                            conta.depositar(valor);
                            System.out.println("Deposito realizado");
                        } catch (ValorInvalidoException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Numero da conta: ");
                    numero = in.nextInt();
                    in.nextLine();

                    conta = banco.buscarConta(numero);

                    if (conta == null) {
                        System.out.println("Conta não encontrada");
                    } else {
                        System.out.print("Valor: ");
                        valor = in.nextDouble();
                        in.nextLine();
                        try {
                            conta.sacar(valor);
                            System.out.println("Saque realizado");
                        } catch (ValorInvalidoException | SaldoInsuficienteException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Numero da conta de envio: ");
                    partida = in.nextInt();
                    in.nextLine();

                    System.out.print("Numero da conta de destino: ");
                    chegada = in.nextInt();
                    in.nextLine();

                    System.out.print("Valor do deposito: ");
                    valor = in.nextDouble();
                    in.nextLine();

                    try {
                        banco.transferir(partida, chegada, valor);
                    } catch (SaldoInsuficienteException | ValorInvalidoException | ContaNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Numero da conta: ");
                    numero = in.nextInt();
                    in.nextLine();

                    conta = banco.buscarConta(numero);
                    if (conta == null) {
                        System.out.println("Conta não encontrada");
                    } else {
                        conta.imprimirExtrato();
                    }
                    break;
                case 5:
                    System.out.print("Numero da conta: ");
                    numero = in.nextInt();
                    in.nextLine();

                    conta = banco.buscarConta(numero);
                    if (conta instanceof ContaPoupanca poupanca) {
                        poupanca.aplicarRendimento();
                    } else {
                        System.out.println("Conta não é poupança");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    static void main(String[] args) {
        Banco banco = new Banco();
        while (true) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastros");
            System.out.println("2 - Operações");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");
            int opcao = in.nextInt();
            in.nextLine();

            switch (opcao) {
                case 1:
                    menuCadastro(banco);
                    break;
                case 2:
                    menuOperacoes(banco);
                    break;
                case 0:
                    return;
            }
        }
    }
}