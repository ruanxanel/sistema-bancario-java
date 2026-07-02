package br.com.banco.model;
import br.com.banco.exception.ValorInvalidoException;
import br.com.banco.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(int numero, Cliente titular, double saldo, double limiteChequeEspecial){
        super(numero, titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        double total = saldo + limiteChequeEspecial;
        if (valor <= 0) {
            throw new ValorInvalidoException("Saque invalido");
        } else if (valor > total) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        } else {
            saldo -= valor;
            registrarNoExtrato("Saque: - " + valor);
        }
    }
}
