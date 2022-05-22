/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EFuncionario;
import java.awt.List;
import java.sql.SQLException;

/**
 *
 * @author Roberval
 */
public class NFuncionario {

    public void salvar(EFuncionario parametro) throws Exception {

        //validacao
//        int idade = util.Data.calcularIdade(parametro.getDataNascimento());
//        if(idade <= 12){
//            //throw new Exception("Idade não permitida.");
//        }
//        if (parametro.getId() == 0) {
            new persistencia.PFuncionario().incluir(parametro);
//        } else {
//            new persistencia.PFuncionario().alterar(parametro);
//        }
    }

    public void excluir(int parametro) throws Exception {
        new persistencia.PFuncionario().excluir(parametro);
    }

    public EFuncionario consultar(int parametro) throws SQLException {
        return new persistencia.PFuncionario().consultar(parametro);
    }

//    public EFuncionario consultar(String parametro) throws SQLException{
//        return new persistencia.PFuncionario().consultar(parametro);
//    }
//    public List<EFuncionario> listar(EFuncionario parametro) throws Exception{
//        return new persistencia.PFuncionario().listar(parametro);
//    }
}
