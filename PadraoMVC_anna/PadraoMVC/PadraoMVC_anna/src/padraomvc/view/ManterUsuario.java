/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.PadraoMVC;
import padraomvc.controller.ControllerUsuario;
import padraomvc.model.bean.Usuario;
import padraomvc.util.ViewBasico;

/**
 * FXML Controller class
 *
 * @author Anna Carolina
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class ManterUsuario implements ViewBasico {

    @Override
    public  void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        String status = JOptionPane.showInputDialog("Status: ");
        String tipo = JOptionPane.showInputDialog("Tipo: ");
        Usuario usuEnt = new Usuario(login,senha,status,tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.inserir(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        
        PadraoMVC.menu();  
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
        String login = JOptionPane.showInputDialog("Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        String status = JOptionPane.showInputDialog("Status: ");
        String tipo = JOptionPane.showInputDialog("Tipo");
        Usuario usuEnt = new Usuario(id,login,senha,status,tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.alterar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        
        PadraoMVC.menu();  
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
        Usuario usuEnt = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.buscar(usuEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        
        PadraoMVC.menu();  
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
        Usuario usuEnt = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        contUsu.excluir(usuEnt);
        JOptionPane.showMessageDialog(null, "Usuário excluído");

        PadraoMVC.menu();  
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("Login: ");
        Usuario usuEnt = new Usuario(login);
        ControllerUsuario contUsu = new ControllerUsuario();
        List<Object> listaUsuario = contUsu.listar(usuEnt);
        for (Object usuObj : listaUsuario) {
            Usuario usuSaida = (Usuario) usuObj;
            JOptionPane.showMessageDialog(null,usuSaida.toString());

        }
        
        PadraoMVC.menu();  
    }

    public static boolean validar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog( "                    BEM VINDO! \n Login: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        Usuario usuEnt = new Usuario(login,senha);
        ControllerUsuario contUsu = new ControllerUsuario();
        return contUsu.validar(usuEnt);
    }   
}
