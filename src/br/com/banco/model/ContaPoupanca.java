package br.com.banco.model;
import br.com.banco.exception.SaldoInsuficienteException;
import br.com.banco.exception.ValorInvalidoException;

public class ContaPoupanca extends Conta{
    private double taxaRendimento;

    public ContaPoupanca(int numero, Cliente titular, double saldo, double taxaRendimento) {
        super(numero, titular, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void aplicarRendimento() {
        saldo += saldo * taxaRendimento;
    }

    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        super.sacar(valor);
    }
}
