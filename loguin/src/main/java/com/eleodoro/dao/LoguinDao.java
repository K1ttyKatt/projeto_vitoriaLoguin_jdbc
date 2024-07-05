package com.eleodoro.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eleodoro.conexao.Conexao;

public class LoguinDao {

    /**
     * @param loguinPojo
     */
    public void cadastrarLoguin(LoguinPojo loguinPojo) {

        Conexao conexao = new Conexao();

        String sql = "insert into loguin (nome, senha) values (?, ?)";

        PreparedStatement ps = null;


        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, loguinPojo.getNome());
            ps.setString(2, loguinPojo.getSenha());

            ps.execute();
            ps.close();

            System.out.println("Dados gravados com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no método cadastrar loguin");
        }
    }

    public void consultarLoguin(LoguinPojo loguinPojo) {

        Conexao conexao = new Conexao();

        String sql = "select * from loguin where Id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps = setInt(1, loguinPojo.getId());


            rs = ps.executeQuery();

            while (rs.next()) {

                loguinPojo.setId(rs.getInt(1));
                loguinPojo.setNome(rs.getString(2));
                loguinPojo.setSenha(rs.getString(3));
            }

            rs.close();
            ps.close();

            System.out.println("Consulta com sucesso");
        
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no metodo consultar");
        }
    }

    private PreparedStatement setInt(int i, Object id) {
        // TOD0 Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setInt'");
    }

    public void incluirLoguin(LoguinPojo loguinPojo) {
        Conexao conexao = new Conexao();

        String sql = "update loguin set nome = ?, senha = ? where id = ?";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, loguinPojo.getNome());
            ps.setString(2, loguinPojo.getSenha());
            ps.setInt(3, (int) loguinPojo.getId());

            ps.execute();
            ps.close();

            System.out.println("Inclusão com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no metodo ao atualizar");
        }

    }


    public void excluirLoguin(LoguinPojo loguinPojo) {
        Conexao conexao = new Conexao();

        String sql = "delete from loguin where id = ?";

        PreparedStatement ps = null;

  
        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, (int) loguinPojo.getId());

            ps.execute();
            ps.close();

            System.out.println("Exclusão com sucesso");
        
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no método de exclusão");
        }
    }

    public void atualizarLoguin(LoguinPojo loguinPojo) {
        // TOD0 Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarLoguin'");
    }
}
    
