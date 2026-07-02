package br.com.banco.exception;

public class ContaNaoEncontradaException extends Exception {

    public ContaNaoEncontradaException(){
        super();
    }
    
    public ContaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public ContaNaoEncontradaException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
