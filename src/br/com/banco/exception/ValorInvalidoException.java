package br.com.banco.exception;

public class ValorInvalidoException extends Exception{
    public ValorInvalidoException() {
        super();
    }
    public ValorInvalidoException(String mensagem) {
        super(mensagem);
    }
    public ValorInvalidoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
