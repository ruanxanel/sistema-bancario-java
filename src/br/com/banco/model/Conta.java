package br.com.banco.model;
import br.com.banco.exception.SaldoInsuficienteException;
import br.com.banco.exception.ValorInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    protected int numero;
    protected Cliente titular;
    protected double saldo;
    private List<String> extrato = new ArrayList<>();

    public Conta(int numero, Cliente titular, double saldo){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Deposito invalido");
        } else {
            saldo += valor;
            extrato.add("Deposito: + " + valor);
        }
    }

    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Saque invalido");
        } else if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        } else {
            saldo -= valor;
            extrato.add("Saque: - " + valor);
        }
    }

    protected void registrarNoExtrato(String operacao) {
        extrato.add(operacao);
    }
    public void imprimirExtrato() {
        System.out.println(" === Extrato da conta " + numero + " ===");
        for (String operacao : extrato) {
            System.out.println(operacao);
        }
        System.out.println("Saldo atual: " + saldo);
    }
}
