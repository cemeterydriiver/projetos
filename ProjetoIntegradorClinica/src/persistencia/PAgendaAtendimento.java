/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EAgendaAtendimento;
import entidade.EFuncionario;
import entidade.EPaciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberval
 */
public class PAgendaAtendimento {
    
    public void incluir(EAgendaAtendimento parametro) throws Exception {
        try {

            //Cria a string com o sql para ser executado
            String sql = "INSERT INTO agendaatendimento (idagenda, id_paciente, id_medico, datahora) "
                    + "VALUES (nextval('seq_id_agendaatendimento'), ?, ?, ?)";

            //Cria o objeto de conexão com o banco
            Connection cnn = util.Conexao.getConexao();

            //Cria o objeto para executar os comandos "contra" o banco
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Seta os valores recebidos como parametro para a string SQL
            prd.setInt(1, parametro.getPaciente().getId());
            prd.setInt(2, parametro.getMedico().getId());
            prd.setString(3, parametro.getDataHoraAgendamento());
            
            //Executa o SQL no banco de dados
            prd.execute();

            //SQL que recupera o valor do ID gerado
            String sql2 = "SELECT currval('seq_id_agendaatendimento') as ID";

            //Cria o objeto para a recuperação dos dados do banco
            Statement smt = cnn.createStatement();
            //Executa a consulta e atribui o resultado ao Resultset
            ResultSet rs = smt.executeQuery(sql2);

            //Verifica se o resultset contem algum valor
            if (rs.next()) {
                parametro.setId(rs.getInt("ID"));
            }

            //Fecha o recordset e a conexao
            rs.close();
            cnn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void excluir(int parametro) throws Exception {
        try {

            //Cria o objeto para a conexao
            Connection cnn = util.Conexao.getConexao();

            String sql = "DELETE FROM agendaatendimento WHERE id_paciente = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setInt(1, parametro);

            prd.execute();
            cnn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public EPaciente consultarCpfPaciente(String parametro) throws SQLException {

        Connection cnn = util.Conexao.getConexao();
        Connection cnn2 = util.Conexao.getConexao();

        String sql = "SELECT id, sexo, "
                + "datanascimento, cpf, rg, mae, pai, endereco, telefone, nome "
                + "FROM paciente WHERE cpf = ?";
        
        
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, parametro);

        ResultSet rs = prd.executeQuery();
        
        EPaciente retorno = new EPaciente();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setSexo(rs.getString("sexo"));
            retorno.setDatanascimento(rs.getDate("datanascimento"));
            retorno.setMae(rs.getString("mae"));
            retorno.setPai(rs.getString("pai"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setRg(rs.getString("rg"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setNome(rs.getString("nome"));

        }
        
        

        rs.close();
        cnn.close();

        return retorno;
    }
    
    public EPaciente consultarNomePaciente(String parametro) throws SQLException {

        Connection cnn = util.Conexao.getConexao();
        Connection cnn2 = util.Conexao.getConexao();

        String sql = "SELECT id, sexo, "
                + "datanascimento, cpf, rg, mae, pai, endereco, telefone, nome "
                + "FROM paciente WHERE nome = ?";
        
        
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, parametro);

        ResultSet rs = prd.executeQuery();
        
        EPaciente retorno = new EPaciente();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setSexo(rs.getString("sexo"));
            retorno.setDatanascimento(rs.getDate("datanascimento"));
            retorno.setMae(rs.getString("mae"));
            retorno.setPai(rs.getString("pai"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setRg(rs.getString("rg"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setNome(rs.getString("nome"));

        }
        
        

        rs.close();
        cnn.close();

        return retorno;
    }
        
    

    public List<EAgendaAtendimento> listar(EAgendaAtendimento parametro) throws Exception {

        List<EAgendaAtendimento> lista = new ArrayList<>(); //<<<<<<<<<<<<<<<<<<<<<<

        try {

            Connection conexao = util.Conexao.getConexao();

            
            String sql = "SELECT idagenda, id_paciente, id_medico, "
                    + "datahora FROM agendaatendimento WHERE 1=1";


            if (parametro.getId()!= 0) {
                sql += " and idagenda = ?";
            }

            
            PreparedStatement prd = conexao.prepareStatement(sql);

            if (parametro.getId() != 0) {
                prd.setInt(1, parametro.getId());
            }

           ResultSet rs = prd.executeQuery();

            while (rs.next()) {
                EAgendaAtendimento agenda = new EAgendaAtendimento(); //<<<<<<<<<<<<<<<<<<<<<<
                agenda.setId(rs.getInt("idagenda"));
                agenda.setDataHoraAgendamento("datahora");
                agenda.setMedico(new PMedico().consultar(rs.getInt("id_medico")));
                agenda.setPaciente(new PPaciente().consultar(rs.getInt("id_paciente")));                
                lista.add(agenda);//<<<<<<<<<<<<<<<<<<<<<<
            }
            rs.close();
            conexao.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return lista;
    }
    
}
