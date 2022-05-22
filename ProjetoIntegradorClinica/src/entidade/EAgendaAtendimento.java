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
public class EAgendaAtendimento {
    
    EMedico medico;
    EPaciente paciente;
    String dataHoraAgendamento;
    int id;

    public EAgendaAtendimento() {
        medico = new EMedico();
        paciente = new EPaciente();
    }

    public String getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(String dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public EMedico getMedico() {
        return medico;
    }

    public void setMedico(EMedico medico) {
        this.medico = medico;
    }

    public EPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(EPaciente paciente) {
        this.paciente = paciente;
    }

    
    
    
}
