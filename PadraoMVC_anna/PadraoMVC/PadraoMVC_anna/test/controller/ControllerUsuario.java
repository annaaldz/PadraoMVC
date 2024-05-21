/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import padraomvc.model.bean.Usuario;
import padraomvc.model.dao.DaoUsuario;

/**
 *
 * @author brupe
 */
public class ControllerUsuario {

    @Test
    public void criandoUsuarioCorretamente() throws SQLException, ClassNotFoundException{
       DaoUsuario dao = new DaoUsuario();
       Usuario user = new Usuario(0, "Sergio", "456", "ATIVO", "ADM");
       Usuario userCorrect = (Usuario) dao.inserir(user);
       
       assertEquals(userCorrect, user);
    }
}
