/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.util;

import java.sql.SQLException;

/**
 * FXML Controller class

 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public interface ViewBasico {
    
    public void menu() throws SQLException, ClassNotFoundException;
    public void inserir() throws SQLException , ClassNotFoundException;
    public void alterar() throws SQLException , ClassNotFoundException;
    public void excluir() throws SQLException , ClassNotFoundException;
    public void buscar() throws SQLException , ClassNotFoundException;
    public void listar() throws SQLException , ClassNotFoundException;
    
}
