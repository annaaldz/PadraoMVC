/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.PadraoMVC;
import padraomvc.controller.ControllerVeiculo;
import padraomvc.model.bean.Veiculo;
import padraomvc.util.ViewBasico;

/**
 *
 * @author Anna Carolina
 */
public class ManterVeiculo implements ViewBasico {
    
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
        String modelo  = JOptionPane.showInputDialog("MODELO");
        String cor = JOptionPane.showInputDialog("COR");
        Veiculo veiEnt = new Veiculo(modelo, cor);
        ControllerVeiculo contVei = new ControllerVeiculo();
        Veiculo veiSaida = (Veiculo) contVei.inserir(veiEnt);
        JOptionPane.showMessageDialog(null,veiSaida.toString());
        
        PadraoMVC.menu();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String modelo  = JOptionPane.showInputDialog("MODELO");
        String cor = JOptionPane.showInputDialog("COR");
        Veiculo veiEnt = new Veiculo(id, modelo,cor);
        ControllerVeiculo contVei = new ControllerVeiculo();
        Veiculo veiSaida = (Veiculo) contVei.alterar(veiEnt);
        JOptionPane.showMessageDialog(null,veiSaida.toString());
        
        PadraoMVC.menu();
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Veiculo veiEnt = new Veiculo(id);
        ControllerVeiculo contVei = new ControllerVeiculo();
        Veiculo veiSaida = (Veiculo) contVei.buscar(veiEnt);
        JOptionPane.showMessageDialog(null,veiSaida.toString());
        
        PadraoMVC.menu();
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Veiculo veiEnt = new Veiculo(id);
        ControllerVeiculo contVei = new ControllerVeiculo();
        Veiculo veiSaida = (Veiculo) contVei.excluir(veiEnt);
        JOptionPane.showMessageDialog(null,veiSaida.toString());
        
        PadraoMVC.menu();
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String modelo = JOptionPane.showInputDialog("MODELO");
        Veiculo veiEnt = new Veiculo(modelo);
        ControllerVeiculo contVei = new ControllerVeiculo();
        List<Object> listaVeiculo = contVei.listar(veiEnt);
        for (Object veiObj : listaVeiculo) {
            Veiculo veiSaida = (Veiculo) veiObj;
            JOptionPane.showMessageDialog(null,veiSaida.toString());
        }
        
        PadraoMVC.menu();
    }
}
