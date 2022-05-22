/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author Roberval
 */
public class EFilaPaciente {

    EPaciente primeiro;
    EPaciente ultimo;

    public EFilaPaciente() {
        primeiro = null;
        ultimo = null;
        
    }

    public EPaciente getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(EPaciente primeiro) {
        this.primeiro = primeiro;
    }

    public EPaciente getUltimo() {
        return ultimo;
    }

    public void setUltimo(EPaciente ultimo) {
        this.ultimo = ultimo;
    }

    public void enfileirar(EPaciente paciente) {
        if (primeiro == null) {
            primeiro = paciente;
        } else {
            ultimo.setProx(paciente);
        }
        ultimo = paciente;
    }

    public void mostrarFila() {

        EPaciente aux;
        if (primeiro == null) {
            System.out.println("Lista vazia!");
            return;
        }
        aux = primeiro;
        System.out.println("Elementos da fila");
        while (aux != null) {
            System.out.printf("%3d\t", aux.getNome());
            aux = aux.getProx();
        }
        System.out.println("");
    }

    public EPaciente desenfileirar() {
        if (primeiro == null) {
            return null;
        }
        EPaciente aux = primeiro;
        if (primeiro == ultimo) {
            primeiro = ultimo = null;
        } else {
            primeiro = primeiro.getProx();
        }
        return aux;
    }

    public EPaciente consultatopo() {
        return primeiro;
    }

    public EPaciente consultaultimo() {
        return ultimo;
    }
}


