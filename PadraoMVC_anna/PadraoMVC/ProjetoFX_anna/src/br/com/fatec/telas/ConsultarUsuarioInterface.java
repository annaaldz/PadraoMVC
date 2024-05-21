/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import padraomvc.model.bean.Usuario;
import padraomvc.controller.ControllerUsuario;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class ConsultarUsuarioInterface implements Initializable {

    @FXML
    private Label lbLogin;

    @FXML
    private TextField txtLogin;

    @FXML
    private TableView<Usuario> listaUsuario;

    @FXML
    private TableColumn<Usuario,String> tid;

    @FXML
    private TableColumn<Usuario,String> tlogin;

    @FXML
    private TableColumn<Usuario,String> tsenha;

    @FXML
    private TableColumn<Usuario,String> tstatus;

    @FXML
    private TableColumn<Usuario,String> ttipo;
    
    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;

    ControllerUsuario usuCont = null;
    
    ObservableList<Usuario> oList = null;

    List<Usuario> lista = null;
    
    public static Usuario usuSaidaTela = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        usuCont = new ControllerUsuario();

        btConsultar.setOnAction((ActionEvent event) -> {
            Usuario usu = new Usuario(txtLogin.getText());
            try {
                montaLista(usu);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition pos = listaUsuario.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                setUsuario(listaUsuario.getItems().get(row));
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/AlterarUsuarioInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarUsuarioInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaUsuario.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Usuario usu = listaUsuario.getItems().get(row);
            try {
                usuCont.excluir(usu);
                listaUsuario.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarUsuarioInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = No Excluir");
            }
        });

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
                    Logger.getLogger(ConsultarUsuarioInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });   
    }
    
    public void montaLista(Usuario usu) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = usuCont.listar(usu);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            lista.add((Usuario) objLista);
        }
        
        oList = FXCollections.observableArrayList(lista);
        tid.setCellValueFactory(new PropertyValueFactory<Usuario,String>("id"));
        tlogin.setCellValueFactory(new PropertyValueFactory<Usuario,String>("login"));
        tsenha.setCellValueFactory(new PropertyValueFactory<Usuario,String>("senha"));
        tstatus.setCellValueFactory(new PropertyValueFactory<Usuario,String>("status"));
        ttipo.setCellValueFactory(new PropertyValueFactory<Usuario,String>("tipo"));
        listaUsuario.setItems(oList);
    }

    public void setUsuario(Usuario usuP) {
        this.usuSaidaTela = usuP;
    }
    
    public Usuario getUsuario() {
        return this.usuSaidaTela;
    }
}
