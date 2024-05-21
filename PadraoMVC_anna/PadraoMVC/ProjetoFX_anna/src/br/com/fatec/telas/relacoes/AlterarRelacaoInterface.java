package br.com.fatec.telas.relacoes;

import padraomvc.model.bean.UsuarioVeiculo;
import padraomvc.controller.ControllerUsuarioVeiculo;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import padraomvc.controller.ControllerVeiculo;
import padraomvc.controller.ControllerUsuario;
import padraomvc.model.bean.Veiculo;
import padraomvc.model.bean.Usuario;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Anna Carolina
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class AlterarRelacaoInterface implements Initializable {

    @FXML
    private Button btSalvar;
    
    @FXML
    private Label lbObs;
    
    @FXML
    private Label lbIdU;
    
    @FXML
    private Label lbIdP;
    
    @FXML
    private Label lbLogin;
    
    @FXML
    private Label lbNomeP;

    @FXML
    private TextField txtObs;

    @FXML
    private Button btVoltar;
    
    @FXML
    private ComboBox<String> comboBoxProdutos;
     
    private String produtoSelecionado;
    
    @FXML
    private ComboBox<String> comboBoxUsuarios;
    
    private String login;

    ControllerUsuarioVeiculo usuProdCont = null;
    
    private Veiculo prodFinal;
    
    private Usuario loginFinal;
    
    @FXML
    private Label lbIdT;

    @FXML
    private Label lbId;
    
    UsuarioVeiculo usuProd = null;
    
    UsuarioVeiculo usuProdAux = null;
    
    UsuarioVeiculo usuProdFinal = null;
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
        try { 
            popularComboBoxUsuarios();
            popularComboBoxProdutos();
            setDefaultSelections();
        } catch (SQLException ex) {
            Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void initComponentes (){
        usuProdCont = new ControllerUsuarioVeiculo();
        ConsultarRelacaoInterface telaAnterior = new ConsultarRelacaoInterface();
        usuProdAux = telaAnterior.getUsuarioVeiculo();
      
        try {
            usuProdFinal = (UsuarioVeiculo) usuProdCont.buscar(usuProdAux);     
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        comboBoxProdutos.setOnAction(event -> {
            produtoSelecionado = comboBoxProdutos.getSelectionModel().getSelectedItem();
            
            ControllerVeiculo prodCont = new ControllerVeiculo();
            try {
               prodFinal = (Veiculo) prodCont.buscarNome(produtoSelecionado);  
            } catch (SQLException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        comboBoxUsuarios.setOnAction(event -> {
            login = comboBoxUsuarios.getSelectionModel().getSelectedItem();
            
            ControllerUsuario usuCont = new ControllerUsuario();
            try {
               loginFinal = (Usuario) usuCont.buscarNome(login);
            } catch (SQLException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btSalvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (login == null || login.isEmpty()){
                    ControllerUsuario usuCont = new ControllerUsuario();
                    login = usuProdAux.getLogin();
                    try {
                        loginFinal = (Usuario) usuCont.buscarNome(login);
                    } catch (SQLException ex) {
                        Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if (produtoSelecionado == null || produtoSelecionado.isEmpty()){
                    ControllerVeiculo veiCont = new ControllerVeiculo();
                    produtoSelecionado = usuProdAux.getVeiculo(); 
                    try {
                        prodFinal = (Veiculo) veiCont.buscarNome(produtoSelecionado);
                    } catch (SQLException ex) {
                        Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                usuProd = new UsuarioVeiculo(
                        usuProdFinal.getId(),
                        loginFinal.getId(),
                        prodFinal.getId(),
                        txtObs.getText(),
                        loginFinal.getLogin(),
                        prodFinal.getModelo());
                try {
                    usuProdCont.alterar(usuProd);
                } catch (SQLException ex) {
                    Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(AlterarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setDefaultSelections() {
        comboBoxProdutos.getSelectionModel().select(usuProdAux.getVeiculo());
        comboBoxUsuarios.getSelectionModel().select(usuProdAux.getLogin());
        txtObs.setText(usuProdAux.getObs());
    }
    
    private void popularComboBoxProdutos() throws SQLException, ClassNotFoundException {
    ControllerVeiculo prodCont = new ControllerVeiculo();
    List<Object> listaProdutos = prodCont.listarTudo(new Veiculo());
    for (Object obj : listaProdutos) {
        Veiculo produto = (Veiculo) obj;
        comboBoxProdutos.getItems().add(produto.getModelo());
        }
    }
    
    private void popularComboBoxUsuarios() throws SQLException, ClassNotFoundException {
    ControllerUsuario usuCont = new ControllerUsuario();
    List<Object> listaUsuarios = usuCont.listarTudo(new Usuario());
    for (Object obj : listaUsuarios) {
        Usuario usuario = (Usuario) obj;
        comboBoxUsuarios.getItems().add(usuario.getLogin());
        }
    }
}
    
