/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Usuario;
import padraomvc.model.bean.UsuarioVeiculo;
import padraomvc.model.bean.Veiculo;
import padraomvc.model.dao.DaoUsuarioVeiculo;
import padraomvc.util.ControllerBasico;

/**
 *
 * @author Anna Carolina
 */
public class ControllerUsuarioVeiculo implements ControllerBasico {
    
    DaoUsuarioVeiculo dao;
    ControllerUsuario contUsu;
    ControllerVeiculo contVei;
    
    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculo();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculo();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculo();
        contUsu = new ControllerUsuario();
        contVei = new ControllerVeiculo();
        
        UsuarioVeiculo objSaida = (UsuarioVeiculo) dao.buscar(obj);
        Usuario usu = new Usuario(objSaida.getIdU()); 
        Usuario usuEnt = (Usuario) contUsu.buscar(usu);
        
        Veiculo vei = new Veiculo(objSaida.getIdV());
        Veiculo veiEnt = (Veiculo) contVei.buscar(vei);
        
        objSaida.setLogin(usuEnt.getLogin());
        objSaida.setVeiculo(veiEnt.getModelo());
        return objSaida;
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculo();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioVeiculo();
        List<Object> listaAux = dao.listar(obj);
        List<Object> lista = new ArrayList<>();
        for (Object objlista : listaAux) {
            lista.add(buscar(objlista));
        }
        return lista;
     }
}
