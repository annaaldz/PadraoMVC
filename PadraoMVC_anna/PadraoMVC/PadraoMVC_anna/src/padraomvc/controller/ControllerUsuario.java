/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.List;
import padraomvc.model.bean.Usuario;
import padraomvc.model.dao.DaoUsuario;
import padraomvc.util.ControllerBasico;

/**
 * FXML Controller class
 *
 * 
 */
public class ControllerUsuario implements ControllerBasico {
    
    DaoUsuario daoUsu;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        Usuario usuSaida = (Usuario) daoUsu.inserir(obj);
        return usuSaida;
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.buscar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.listar(obj);
     }
    

    public boolean validar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.validar(usuEnt);
        if(usuSaida != null) {
            retorno = true;
        }
        return retorno;
    }
    
        public Usuario validarWeb(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.validar(usuEnt);
        return usuSaida;
    }
        
    public List<Object> listarTudo(Object obj) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.listarTudo();
     }
    
    public Object buscarNome(String string) throws SQLException, ClassNotFoundException {
       daoUsu = new DaoUsuario();
        return daoUsu.buscarNome(string);
    }
    
    public Object buscarId(int id) throws SQLException, ClassNotFoundException {
       daoUsu = new DaoUsuario();
        return daoUsu.buscarId(id);
    }
}
