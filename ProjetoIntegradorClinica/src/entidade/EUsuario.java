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
public class EUsuario {
    
    EMedico medico;
    EFuncionario funcionario;
    
    public EUsuario(){        
        
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
    
    
    
}
