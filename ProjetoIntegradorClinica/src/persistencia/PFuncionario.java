/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EFuncionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberval
 */
public class PFuncionario {

    public PFuncionario() {

    }

    public void incluir(EFuncionario parametro) throws Exception {
        try {

            //Cria a string com o sql para ser executado
            String sql = "INSERT INTO funcionario (id, nome,"
                    + "senha, cargo, "
                    + "endereco, telefone, rgcpf, datanascimento) VALUES (nextval('seq_id_funcionario'), ?, ?, ?, ?, ?, ?, ?)";

            //Cria o objeto de conexão com o banco
            Connection cnn = util.Conexao.getConexao();

            //Cria o objeto para executar os comandos "contra" o banco
            PreparedStatement prd = cnn.prepareStatement(sql);

            //Seta os valores recebidos como parametro para a string SQL
            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getSenha());
            prd.setString(3, parametro.getCargo());
            prd.setString(4, parametro.getEndereco());
            prd.setString(5, parametro.getTelefone());
            prd.setString(6, parametro.getRgCpf());
            prd.setDate(7, parametro.getDataNascimento());

            //Executa o SQL no banco de dados
            prd.execute();

            //SQL que recupera o valor do ID gerado
            String sql2 = "SELECT currval('seq_id_funcionario') as ID";

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

    public void alterar(EFuncionario parametro) throws Exception {
        try {

            //Cria o objeto para a conexao
            Connection cnn = util.Conexao.getConexao();

            String sql = "UPDATE funcionario "
                    + "SET nome = ?, "
                    + "senha = ?, "
                    + "cargo = ?, "
                    + "endereco = ?, "
                    + "telefone = ?,  "
                    + "rgcpf = ? "
                    + "datanascimento = ? "
                    + " WHERE id = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getSenha());
            prd.setString(3, parametro.getCargo());
            prd.setString(4, parametro.getEndereco());
            prd.setString(5, parametro.getTelefone());
            prd.setString(6, parametro.getRgCpf());
            prd.setDate(7, parametro.getDataNascimento());

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

            String sql = "DELETE FROM funcionario WHERE id = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setInt(1, parametro);

            prd.execute();
            cnn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public EFuncionario consultar(int parametro) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, nome, senha, "
                + "cargo, endereco, telefone, rgcpf, datanascimento "
                + "FROM funcionario WHERE id = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();
        EFuncionario retorno = new EFuncionario();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setNome(rs.getString("nome"));
            retorno.setSenha(rs.getString("senha"));
            retorno.setCargo(rs.getString("cargo"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setRgCpf(rs.getString("rgcpf"));
            retorno.setDataNascimento(rs.getDate("datanascimento"));

        }
        rs.close();
        cnn.close();

        return retorno;
    }

    public List<EFuncionario> listar(EFuncionario parametro) throws Exception {

        List<EFuncionario> lista = new ArrayList<>(); //<<<<<<<<<<<<<<<<<<<<<<

        try {

            Connection conexao = util.Conexao.getConexao();

            String sql = "SELECT id, nome, senha, "
                    + "cargo, endereco, telefone"
                    + "rgcpf, datanascimento "
                    + "FROM funcionario WHERE 1=1 ";

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
                EFuncionario funcionario = new EFuncionario(); //<<<<<<<<<<<<<<<<<<<<<<
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setEndereco(rs.getString("telefone"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setDataNascimento(rs.getDate("datanascimento"));
                lista.add(funcionario);//<<<<<<<<<<<<<<<<<<<<<<
            }
            rs.close();
            conexao.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return lista;
    }

}
