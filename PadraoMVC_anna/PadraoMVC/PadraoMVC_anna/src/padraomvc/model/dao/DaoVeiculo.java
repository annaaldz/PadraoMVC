/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Veiculo;
import padraomvc.util.ConexaoDb;
import padraomvc.util.DaoBasico;

/**
 *
 * @author Anna Carolina
 */
public class DaoVeiculo implements DaoBasico {
   private final Connection c;
    
    public DaoVeiculo() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }
    @Override
    public Object inserir(Object obj) throws SQLException {
        Veiculo veiEnt = (Veiculo) obj;
        String sql = "insert into veiculos " + " (modelo, cor)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,veiEnt.getModelo());
        stmt.setString(2,veiEnt.getCor());
       

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            veiEnt.setId(id);
        }
        stmt.close();
        return veiEnt;
    }
    
    @Override
    public Object alterar(Object obj) throws SQLException {
        Veiculo veiEnt = (Veiculo) obj;
        String sql = "UPDATE veiculos SET modelo = ?, cor = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,veiEnt.getModelo());
        stmt.setString(2,veiEnt.getCor());
        stmt.setInt(3,veiEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        return veiEnt;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        Veiculo veiEnt = (Veiculo) obj;
        String sql = "delete from veiculos WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,veiEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return veiEnt;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        Veiculo veiEnt = (Veiculo) obj;
        String sql = "select * from veiculos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,veiEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Veiculo veiSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                veiSaida = new Veiculo(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
           // adiciona lista de veiculos
                        }
            
            stmt.close();
        return veiSaida;
    }
    
    public Object buscarNome(String obj) throws SQLException {
        String sql = "select * from veiculos WHERE modelo = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setString(1, obj);
            // executa
            ResultSet rs = stmt.executeQuery();
            Veiculo veiSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                veiSaida = new Veiculo(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
           // adiciona lista de veiculos
                        }
            
            stmt.close();
        return veiSaida;
    }
    
    
    @Override
    public List<Object> listar(Object obj) throws SQLException  {
        Veiculo veiEnt = (Veiculo) obj;
        // usus: array armazena a lista de registros
        List<Object> veic = new ArrayList<>();
        
        String sql = "SELECT * FROM veiculos WHERE modelo LIKE ? COLLATE utf8mb4_unicode_ci";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + veiEnt.getModelo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Veiculo vei = new Veiculo(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
    
            );
            // adiciona o usu à lista de usus
            veic.add(vei);
        }
        
        rs.close();
        stmt.close();
        return veic;
    }
    
        public List<Object> listarTudo(Object obj) throws SQLException  {
        Veiculo veiEnt = (Veiculo) obj;
        // usus: array armazena a lista de registros
        List<Object> veic = new ArrayList<>();
        
        String sql = "SELECT * FROM veiculos";
        PreparedStatement stmt = this.c.prepareStatement(sql);    
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Veiculo vei = new Veiculo(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
    
            );
            // adiciona o usu à lista de usus
            veic.add(vei);
        }
        
        rs.close();
        stmt.close();
        return veic;
    }
}
