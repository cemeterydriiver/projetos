/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EAgendaAtendimento;
import entidade.EPaciente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Roberval
 */
public class NAgendaAtendimento {
    
    public void salvar(EAgendaAtendimento parametro) throws Exception {
        
        new persistencia.PAgendaAtendimento().incluir(parametro);
        
    }
    
    public EPaciente consultarCpfPaciente(String parametro) throws SQLException {
        return new persistencia.PAgendaAtendimento().consultarCpfPaciente(parametro);
    }
    
    public EPaciente ConsultarNomePaciente(String parametro) throws SQLException {
        return new persistencia.PAgendaAtendimento().consultarNomePaciente(parametro);
    }
    
     public void excluir(int parametro) throws Exception{
         
        new persistencia.PAgendaAtendimento().excluir(parametro);
    }
    
    
    
    public List<EAgendaAtendimento> listar(EAgendaAtendimento parametro) throws Exception{
        return new persistencia.PAgendaAtendimento().listar(parametro);
    }
    
}
