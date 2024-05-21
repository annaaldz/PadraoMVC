/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package padraomvc;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import padraomvc.view.ManterVeiculo;
import padraomvc.view.ManterUsuario;
import padraomvc.view.ManterUsuarioVeiculo;

/**
 * FXML Controller class
 *
 * @author Anna Carolina
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class PadraoMVC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Veiculo \n 3 - Usuário Veiculo";

        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
                
            case 1:
                ManterUsuario mu = new ManterUsuario();
                mu.menu();
                break;
                
            case 2:
                ManterVeiculo mp = new ManterVeiculo();
                mp.menu();
                break;
                
            case 3:
                ManterUsuarioVeiculo mup = new ManterUsuarioVeiculo();
                mup.menu();
                break;
                
            default:
                System.out.println("Opção inválido");
        }
    }
}
