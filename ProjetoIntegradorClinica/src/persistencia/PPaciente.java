/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
public class PPaciente {

    public void incluir(EPaciente parametro) throws Exception {
        try {

            //Cria a string com o sql para ser executado
            String sql = "INSERT INTO paciente (id, nome,"
                    + "sexo, datanascimento, "
                    + "cpf, rg, mae, pai, endereco, telefone) VALUES (nextval('seq_id_paciente'), ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //Cria o objeto de conexão com o banco
            Connection cnn = util.Conexao.getConexao();

            //Cria o objeto para executar os comandos "contra" o banco
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Seta os valores recebidos como parametro para a string SQL
            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getSexo());
            prd.setDate(3, parametro.getDatanascimento());
            prd.setString(4, parametro.getCpf());
            prd.setString(5, parametro.getRg());
            prd.setString(6, parametro.getMae());
            prd.setString(7, parametro.getPai());
            prd.setString(8, parametro.getEndereco());
            prd.setString(9, parametro.getTelefone());

            //Executa o SQL no banco de dados
            prd.execute();

            //SQL que recupera o valor do ID gerado
            String sql2 = "SELECT currval('seq_id_paciente') as ID";

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

    public void alterar(EPaciente parametro) throws Exception {
        try {

            //Cria o objeto para a conexao
            Connection cnn = util.Conexao.getConexao();

            String sql = "UPDATE paciente "
                    + "SET sexo = ?, "
                    + "datanascimento = ?, "
                    + "cpf = ?, "
                    + "rg = ?,  "
                    + "mae = ?, "
                    + "pai = ?,"
                    + "endereco = ?, "
                    + "telefone = ?, "
                    + "nome = ? "
                    + " WHERE id = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);

            prd.setString(1, parametro.getSexo());
            prd.setDate(2, parametro.getDatanascimento());
            prd.setString(3, parametro.getCpf());
            prd.setString(4, parametro.getRg());
            prd.setString(5, parametro.getMae());
            prd.setString(6, parametro.getPai());
            prd.setString(7, parametro.getEndereco());
            prd.setString(8, parametro.getTelefone());
            prd.setString(9, parametro.getNome());
            prd.setInt(10, parametro.getId());

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

            String sql = "DELETE FROM paciente WHERE id = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setInt(1, parametro);

            prd.execute();
            cnn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void excluir(String parametro) throws Exception {
        try {

            //Cria o objeto para a conexao
            Connection cnn = util.Conexao.getConexao();

            String sql = "DELETE FROM paciente WHERE nome = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setString(1, parametro);

            prd.execute();
            cnn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public EPaciente consultar(int parametro) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, sexo, "
                + "datanascimento, cpf, rg, mae, pai, endereco, telefone, nome "
                + "FROM paciente WHERE id = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

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
    
    public EPaciente consultar(String parametro) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, sexo, "
                + "datanascimento, cpf, rg, mae, pai, endereco, telefone, nome "
                + "FROM paciente WHERE id = ?";

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
    
    
    
    

    public List<EPaciente> listar(EPaciente parametro) throws Exception {

        List<EPaciente> lista = new ArrayList<>(); //<<<<<<<<<<<<<<<<<<<<<<

        try {

            Connection conexao = util.Conexao.getConexao();

            String sql = "SELECT id, nome, sexo, "
                    + "datanascimento, cpf, rg"
                    + "mae, pai, endereco, telefone "
                    + "FROM paciente WHERE 1=1 ";

            if (parametro.getId() != 0) {
                sql += " and id = ?";
            }

            if (parametro.getNome() != null) {
                if (!parametro.getNome().isEmpty()) {
                    sql += " and upper(nome) like ?";
                }
            }

            PreparedStatement prd = conexao.prepareStatement(sql);

            if (parametro.getId() != 0) {
                prd.setInt(1, parametro.getId());
            }

            if (parametro.getNome() != null) {
                if (!parametro.getNome().isEmpty()) {
                    prd.setString(1, "%" + parametro.getNome().toUpperCase() + "%");
                }
            }

            ResultSet rs = prd.executeQuery();

            while (rs.next()) {
                EPaciente paciente = new EPaciente(); //<<<<<<<<<<<<<<<<<<<<<<
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setDatanascimento(rs.getDate("datanascimento"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setRg(rs.getString("rg"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                lista.add(paciente);
            }

            rs.close();
            conexao.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return lista;
    }
}
