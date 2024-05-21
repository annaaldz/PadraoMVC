/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.dao;

import padraomvc.util.DaoBasico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Usuario;
import padraomvc.util.ConexaoDb;

/**
 * FXML Controller class
 *
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class DaoUsuario implements DaoBasico {
    
    private final Connection c;
    
    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

        public Usuario validar(Usuario usuEnt) throws SQLException {
        // cria o select para ser executado no banco de dados 
        String sql = "select * from usuarios WHERE login = ? AND senha = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,usuEnt.getLogin());
        stmt.setString(2,usuEnt.getSenha());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        Usuario usuSaida = null;
        while (rs.next()) {      
            // criando o objeto Usuario
            usuSaida = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        System.out.println(usuSaida);
        return usuSaida; 
    }

    @Override
    public Object inserir(Object obj) throws SQLException {
        Usuario usuEnt = (Usuario) obj;
        String sql = "insert into usuarios" + " (login, senha, status, tipo)" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,usuEnt.getLogin());
        stmt.setString(2,usuEnt.getSenha());
        stmt.setString(3,usuEnt.getStatus());
        stmt.setString(4,usuEnt.getTipo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usuEnt.setId(id);
        }
        stmt.close();
        return usuEnt;
    }
    
    @Override
    public Object alterar(Object obj) throws SQLException {
        Usuario usuEnt = (Usuario) obj;
        String sql = "UPDATE usuarios SET login = ?, senha = ?, status = ?, tipo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,usuEnt.getLogin());
        stmt.setString(2,usuEnt.getSenha());
        stmt.setString(3,usuEnt.getStatus());
        stmt.setString(4,usuEnt.getTipo());
        stmt.setInt(5,usuEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        return usuEnt;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        Usuario usuEnt = (Usuario) obj;
        String sql = "delete from usuarios WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usuEnt;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        Usuario usuEnt = (Usuario) obj;
        String sql = "select * from usuarios WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1,usuEnt.getId());
            
            // executa
            ResultSet rs = stmt.executeQuery();
            Usuario usuSaida = null;
            
            while (rs.next()) {      
            // criando o objeto Usuario
                usuSaida = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            
            }
            stmt.close();
        return usuSaida;
    }
    
    
    @Override
    public List<Object> listar(Object obj) throws SQLException  {
        Usuario usuEnt = (Usuario) obj;
        // usus: array armazena a lista de registros
        List<Object> usus = new ArrayList<>();
        
        String sql = "select * from usuarios where login like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usuEnt.getLogin() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Usuario usu = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
    }
    
    public List<Object> listarTudo() throws SQLException {
        List<Object> usu = new ArrayList<>();
        
        String sql = "select login from usuarios";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Usuario usuario = new Usuario(
                rs.getString(1));

            usu.add(usuario);
        }
        
        rs.close();
        stmt.close();
        return usu;
    }
    
    public Object buscarNome(String nome) throws SQLException {
        String sql = "select * from usuarios WHERE login = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setString(1,nome);
            // executa
            ResultSet rs = stmt.executeQuery();
            Usuario usuSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usuSaida = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            }
            stmt.close();
        return usuSaida;
    }
    
    public Object buscarId(int id) throws SQLException {
        String sql = "select * from usuarios WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1,id);
            
            // executa
            ResultSet rs = stmt.executeQuery();
            Usuario usuSaida = null;
            
            while (rs.next()) {      
            // criando o objeto Usuario
                usuSaida = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            
            }
            stmt.close();
        return usuSaida;
    }
}
