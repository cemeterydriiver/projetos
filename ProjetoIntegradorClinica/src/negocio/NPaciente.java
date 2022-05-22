/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EPaciente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Roberval
 */
public class NPaciente {

    
    public void salvar(EPaciente parametro) throws Exception {

//        if (parametro.getId() == 0) {
            new persistencia.PPaciente().incluir(parametro);
//        } else {
//            new persistencia.PPaciente().alterar(parametro);
//        }
    }

    public void excluir(int parametro) throws Exception {
        new persistencia.PPaciente().excluir(parametro);
    }
    
    public void excluir(String parametro) throws Exception{
        new persistencia.PPaciente().excluir(parametro);
    }

    public EPaciente consultar(int parametro) throws SQLException {
        return new persistencia.PPaciente().consultar(parametro);
    }
    
    public EPaciente consultar(String parametro) throws SQLException {
        return new persistencia.PPaciente().consultar(parametro);
    }
    
    
    
        
    public List<EPaciente> listaPacienteAgendaConsulta(EPaciente parametro) throws Exception{
        return new persistencia.PPaciente().listar(parametro);
    }

}
