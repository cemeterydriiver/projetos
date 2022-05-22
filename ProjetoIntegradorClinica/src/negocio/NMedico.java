/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EMedico;
import java.sql.SQLException;
import persistencia.PMedico;

/**
 *
 * @author Roberval
 */
public class NMedico {
    
    public void salvar(EMedico parametro) throws Exception {

        //validacao
//        int idade = util.Data.calcularIdade(parametro.getDataNascimento());
//        if(idade <= 12){
//            //throw new Exception("Idade não permitida.");
//        }
        
        if (parametro.getId()== 0) {
            new persistencia.PMedico().incluir(parametro);
        } else {
            new persistencia.PMedico().alterar(parametro);
        }
    }
    
    public void excluir(int parametro) throws Exception{
        new persistencia.PMedico().excluir(parametro);
    }

    public EMedico consultar(int parametro) throws SQLException{
        return new persistencia.PMedico().consultar(parametro);
    }
}
