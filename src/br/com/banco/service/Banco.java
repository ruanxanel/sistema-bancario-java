package br.com.banco.service;

import br.com.banco.exception.ContaNaoEncontradaException;
import br.com.banco.exception.SaldoInsuficienteException;
import br.com.banco.exception.ValorInvalidoException;
import br.com.banco.model.Cliente;
import br.com.banco.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String cpf){
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public void cadastrarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor)
    throws SaldoInsuficienteException, ValorInvalidoException, ContaNaoEncontradaException {
        Conta origem = buscarConta(numeroOrigem);
        Conta destino = buscarConta(numeroDestino);

        if (origem == null || destino == null) {
            throw new ContaNaoEncontradaException("Conta não encontrada");
        } else {
            origem.sacar(valor);
            destino.depositar(valor);
        }
    }
}
