package br.com.banco.model;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone(){
        return telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEndereco() {
        return endereco;
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}
