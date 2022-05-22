/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.Date;

/**
 *
 * @author Roberval
 */
public class EProntuario {
    
    int id;
    EProntuario pilhaproximo;
    EPaciente paciente;
    EMedico medico;
    EFuncionario funcionario;
    java.sql.Date data;
    String queixaPrincipal, hdoenca, antfamiliares, habitos, medicacaouso;
    
    
    public EProntuario(int id){
        this.id=id;
        this.pilhaproximo=null;
        
    }
    public EProntuario(){        
    }

    public EProntuario getPilhaproximo() {
        return pilhaproximo;
    }

    public void setPilhaproximo(EProntuario pilhaproximo) {
        this.pilhaproximo = pilhaproximo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public EPaciente getPaciente() {
        return paciente;
    }
    

    public void setPaciente(EPaciente paciente) {
        this.paciente = paciente;
    }

    public EMedico getMedico() {
        return medico;
    }

    public void setMedico(EMedico medico) {
        this.medico = medico;
    }

    public EFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(EFuncionario funcionario) {
        this.funcionario = funcionario;
    }

   
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    public void setQueixaPrincipal(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    public String getHdoenca() {
        return hdoenca;
    }

    public void setHdoenca(String hdoenca) {
        this.hdoenca = hdoenca;
    }

    public String getAntfamiliares() {
        return antfamiliares;
    }

    public void setAntfamiliares(String antfamiliares) {
        this.antfamiliares = antfamiliares;
    }

    public String getHabitos() {
        return habitos;
    }

    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }

    public String getMedicacaouso() {
        return medicacaouso;
    }

    public void setMedicacaouso(String medicacaouso) {
        this.medicacaouso = medicacaouso;
    }
    
    
    
}
