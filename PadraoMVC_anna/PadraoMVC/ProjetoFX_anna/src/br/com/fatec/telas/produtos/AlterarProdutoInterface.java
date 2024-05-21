package br.com.fatec.telas.produtos;

import padraomvc.model.bean.Veiculo;
import padraomvc.controller.ControllerVeiculo;
import java.io.IOException;
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
public class AlterarProdutoInterface implements Initializable {

    @FXML
    private Button btSalvar;

    @FXML
    private Label lbNome;

    @FXML
    private TextField txtNome;
    
    @FXML
    private Label lbCor;

    @FXML
    private TextField txtCor;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Label lbIdT;

    @FXML
    private Label lbId;

    ControllerVeiculo prodCont = null;
    
    Veiculo prod = null;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initComponentes(); 
    }    

    private void initComponentes (){

        prodCont = new ControllerVeiculo();
        ConsultarProdutoInterface telaAnterior = new ConsultarProdutoInterface();
        setVeiculo(telaAnterior.getVeiculo());

        btVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(AlterarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btSalvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                prod = new Veiculo(Integer.parseInt(lbIdT.getText()),
                                  txtNome.getText(),
                                  txtCor.getText());

                try {
                    prodCont.alterar(prod);
                } catch (SQLException ex) {
                    Logger.getLogger(AlterarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AlterarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(AlterarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void setVeiculo(Veiculo prod) {
        JOptionPane.showMessageDialog(null, prod.getModelo());
        this.lbIdT.setText(""+prod.getId());
        this.txtNome.setText(prod.getModelo());
        this.txtCor.setText(prod.getCor());
    }
}
    
