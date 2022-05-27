package br.unisal.aula.exception;


public class IMCNumeroNegativoException extends RuntimeException {

    public IMCNumeroNegativoException() {
        super("Peso ou altura negativos");
    }
}
