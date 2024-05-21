/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.PadraoMVC;
import padraomvc.controller.ControllerUsuarioVeiculo;
import padraomvc.model.bean.UsuarioVeiculo;
import padraomvc.util.ViewBasico;

/**
 *
 * @author Anna Carolina
 */
public class ManterUsuarioVeiculo implements ViewBasico {
    
    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1 : inserir();
            case 2 : alterar();
            case 3 : buscar();
            case 4 : excluir();
            case 5 : listar();
            default : System.out.println("Opcao inválida");
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idV = Integer.parseInt(JOptionPane.showInputDialog("IDV"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioVeiculo usuEnt = new UsuarioVeiculo(idU, idV, obs);
        ControllerUsuarioVeiculo contUsu = new ControllerUsuarioVeiculo();
        UsuarioVeiculo usuSaida = (UsuarioVeiculo) contUsu.inserir(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        
        PadraoMVC.menu();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idV = Integer.parseInt(JOptionPane.showInputDialog("IDV"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioVeiculo usuEnt = new UsuarioVeiculo(id,idU, idV, obs);
        ControllerUsuarioVeiculo contUsu = new ControllerUsuarioVeiculo();
        UsuarioVeiculo usuSaida = (UsuarioVeiculo) contUsu.alterar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        
        PadraoMVC.menu();
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioVeiculo usuEnt = new UsuarioVeiculo(id);
        ControllerUsuarioVeiculo contUsu = new ControllerUsuarioVeiculo();
        UsuarioVeiculo usuSaida = (UsuarioVeiculo) contUsu.buscar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        System.out.println(usuSaida.getLogin());
        System.out.println(usuSaida.getVeiculo());
    
        PadraoMVC.menu();
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioVeiculo usuEnt = new UsuarioVeiculo(id);
        ControllerUsuarioVeiculo contUsu = new ControllerUsuarioVeiculo();
        UsuarioVeiculo usuSaida = (UsuarioVeiculo) contUsu.excluir(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        
        PadraoMVC.menu();
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioVeiculo usuEnt = new UsuarioVeiculo(obs);
        ControllerUsuarioVeiculo contUsu = new ControllerUsuarioVeiculo();
        List<Object> listaUsuario = contUsu.listar(usuEnt);
        for (Object usuObj : listaUsuario) {
            UsuarioVeiculo usuSaida = (UsuarioVeiculo) usuObj;
            JOptionPane.showMessageDialog(null,usuSaida.toString());   
        }
        
        PadraoMVC.menu();
    }
}


