package br.com.fatec.telas;

import padraomvc.model.bean.Usuario;
import padraomvc.controller.ControllerUsuario;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Anna Carolina
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class LoginInterface implements Initializable {

    @FXML
    private Label lbLogin;

    @FXML
    private Label lbSenha;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btEntrar;
    
    ControllerUsuario usuCont = null;

    private void initComponentes () {
        btEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                usuCont = new ControllerUsuario();
                Usuario usu = new Usuario(txtLogin.getText(),txtSenha.getText(),"","");
                try {
                    Object usuSaida = usuCont.validar(usu);
                    try
                        {
                            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                            Parent novatela  = loader.load();
                            Stage stg = ProjetoFX.getStage();
                            stg.setScene(new Scene(novatela));
                            stg.show();
                        } catch(Exception e) {
                        } catch (Throwable ex) {                    
                        Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, usu.getLogin());
            }
        }); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }    
}
