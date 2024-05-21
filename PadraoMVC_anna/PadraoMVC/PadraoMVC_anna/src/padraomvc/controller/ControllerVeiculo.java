/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.List;
import padraomvc.model.dao.DaoVeiculo;
import padraomvc.util.ControllerBasico;

/**
 *
 * @author Anna Carolina
 */
public class ControllerVeiculo implements ControllerBasico {
    DaoVeiculo dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoVeiculo();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoVeiculo();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoVeiculo();
        return dao.buscar(obj);
    }
    
    public Object buscarNome(String obj) throws SQLException, ClassNotFoundException {
        dao = new DaoVeiculo();
        return dao.buscarNome(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoVeiculo();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoVeiculo();
        return dao.listar(obj);
    }
    
    public List<Object> listarTudo(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoVeiculo();
        return dao.listarTudo(obj);
    }
}

