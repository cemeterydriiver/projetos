package br.unisal.aula.helpers;

import br.unisal.aula.model.Pessoa;
import br.unisal.aula.exception.IMCNumeroNegativoException;
import br.unisal.aula.exception.IMCCampoVazioException;
import br.unisal.aula.exception.IMCFormatoInvalidoException;


public final class PessoaHelper {

    public static Pessoa criarPessoa(String nome, String pesoStr, String alturaStr) {

        if (nome.isEmpty() || pesoStr.isEmpty() || alturaStr.isEmpty()) {
            throw new IMCCampoVazioException();
        }

        try {
            double peso = Double.parseDouble(pesoStr.replace(",", "."));
            double altura = Double.parseDouble(alturaStr.replace(",", "."));
            return criarPessoa(nome, peso, altura);
        } catch (NumberFormatException ex) {
            throw new IMCFormatoInvalidoException();
        }
    }

    public static Pessoa criarPessoa(String nome, double peso, double altura) {
        if (peso <= 0.0f || altura <= 0.0f) {
            throw new IMCNumeroNegativoException();
        }

        Pessoa pessoa = new Pessoa(nome, peso, altura);
        return pessoa;
    }
}
