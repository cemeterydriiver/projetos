/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EMedico;
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
public class PMedico {
    
     public void incluir(EMedico parametro) throws Exception {
        try {

            //Cria a string com o sql para ser executado
            String sql = "INSERT INTO medico (id, nome,"
                    + "senha, cargo, "
                    + "especialidade, endereco, "
                    + "telefone, rgcpf) VALUES (nextval('seq_id_medico'), ?, ?, ?, ?, ?, ?, ?)";

            //Cria o objeto de conexão com o banco
            Connection cnn = util.Conexao.getConexao();

            //Cria o objeto para executar os comandos "contra" o banco
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Seta os valores recebidos como parametro para a string SQL
            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getSenha());
            prd.setString(3, parametro.getCargo());
            prd.setString(4, parametro.getEspecialidade());
            prd.setString(5, parametro.getEndereco());
            prd.setString(6, parametro.getTelefone());
            prd.setString(7, parametro.getRgCpf());
            

            //Executa o SQL no banco de dados
            prd.execute();

            //SQL que recupera o valor do ID gerado
            String sql2 = "SELECT currval('seq_id_medico') as ID";

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

    public void alterar(EMedico parametro) throws Exception {
        try {

            //Cria o objeto para a conexao
            Connection cnn = util.Conexao.getConexao();

            String sql = "UPDATE medico "
                    + "SET nome = ?, "
                    + "senha = ?, "
                    + "cargo = ?, "
                    + "especialidade = ?, "
                    + "endereco = ?, "
                    + "telefone = ?,  "
                    + "rgcpf = ? "                    
                    + " WHERE id = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getSenha());
            prd.setString(3, parametro.getCargo());
            prd.setString(4, parametro.getEspecialidade());
            prd.setString(5, parametro.getEndereco());
            prd.setString(6, parametro.getTelefone());
            prd.setString(7, parametro.getRgCpf());

            prd.execute();
            cnn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void excluir(int parametro) throws Exception {
        try {

            //Cria o objeto para a conexao
            Connection cnn = util.Conexao.getConexao();

            String sql = "DELETE FROM medico WHERE id = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setInt(1, parametro);

            prd.execute();
            cnn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public EMedico consultar(int parametro) throws SQLException {
        
        Connection cnn = util.Conexao.getConexao();
        
        String sql = "SELECT id, nome, senha, "
                + "cargo, especialidade, "
                + "endereco, telefone, rgcpf "
                + "FROM medico WHERE id = ?";
        
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();
        EMedico retorno = new EMedico();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setNome(rs.getString("nome"));
            retorno.setSenha(rs.getString("senha"));
            retorno.setCargo(rs.getString("cargo"));
            retorno.setEspecialidade(rs.getString("especialidade"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setRgCpf(rs.getString("rgcpf"));
            
        }
        rs.close();
        cnn.close();

        return retorno;
    }
    

    public List<EMedico> listar(EMedico parametro) throws Exception {
        
        List<EMedico> lista = new ArrayList<>(); //<<<<<<<<<<<<<<<<<<<<<<

        try {

            Connection conexao = util.Conexao.getConexao();

            String sql = "SELECT id, nome, senha, "
                    + "cargo, especialidade, "
                    + "endereco, telefone"
                    + "rgcpf "
                    + "FROM medico WHERE 1=1 ";

            if (parametro.getId()!= 0) {
                sql += " and id = ?";
            }

            if (parametro.getNome() != null) {
                if (!parametro.getNome().isEmpty()) {
                    sql += " and upper(nome) like ?";
                }
            }


            PreparedStatement prd = conexao.prepareStatement(sql);
            
            if (parametro.getId()!= 0) {
                prd.setInt(1, parametro.getId());
            }

            if (parametro.getNome() != null) {
                if (!parametro.getNome().isEmpty()) {
                    prd.setString(1, "%" + parametro.getNome().toUpperCase() + "%");
                }
            }

            ResultSet rs = prd.executeQuery();

            while (rs.next()) {
                EMedico medico = new EMedico(); //<<<<<<<<<<<<<<<<<<<<<<
                medico.setId(rs.getInt("id"));
                medico.setNome(rs.getString("nome"));
                medico.setSenha(rs.getString("senha"));
                medico.setCargo(rs.getString("cargo"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setEndereco(rs.getString("telefone"));
                medico.setTelefone(rs.getString("telefone"));
                lista.add(medico);//<<<<<<<<<<<<<<<<<<<<<<
            }
            rs.close();
            conexao.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return lista;
    }
}
