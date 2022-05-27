package br.unisal.aula.helpers;

import br.unisal.aula.model.Pessoa;

/**
 * Indice de massa corporea
 * @author Kleber de Oliveira Andrade
 * @date 20 de Agosto de 2018
 */
public final class IMC {
    
    private IMC(){}

    /**
     * Calcular o Indice de Massa Comporea de uma pessoa
     * @param pessoa objeto pessoa contendo nome, peso e altura
     * @return retorna um valor double indicando o IMC da pessoa
     */
    public static double calcularIMC(Pessoa pessoa) {
        double imc = pessoa.getPeso() / Math.pow(pessoa.getAltura(), 2);
        return imc;
        //return peso / (altura * altura);
    }

    public static String getStatusSaude(Pessoa pessoa) {
        double imc = calcularIMC(pessoa);
        if (imc < 17) {
            return "Muito abaixo do peso";
        } else if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Acima do peso";
        } else if (imc < 35) {
            return "Obesidade 1";
        } else if (imc < 40) {
            return "Obesidade 2 (Severa)";
        } else {
            return "Obesidade 3 (Mórbida)";
        }
    }
}
