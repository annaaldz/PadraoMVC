/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.util;

import java.sql.SQLException;
import java.util.List;

/**
 * FXML Controller class
 *
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public interface DaoBasico {
    public Object inserir(Object obj) throws SQLException;
    public Object alterar(Object obj) throws SQLException;
    public Object excluir(Object obj) throws SQLException;
    public Object buscar(Object obj) throws SQLException;
    public List<Object> listar(Object obj) throws SQLException;
}