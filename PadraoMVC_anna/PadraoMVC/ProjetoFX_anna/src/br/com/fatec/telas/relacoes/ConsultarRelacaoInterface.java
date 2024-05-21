package br.com.fatec.telas.relacoes;

import br.com.fatec.telas.*;
import padraomvc.model.bean.UsuarioVeiculo;
import padraomvc.controller.ControllerUsuarioVeiculo;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerVeiculo;
import padraomvc.model.bean.Veiculo;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Anna Carolina
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class ConsultarRelacaoInterface implements Initializable {

    @FXML
    private Label lbObs;

    @FXML
    private TextField txtObs;

    @FXML
    private TableView<UsuarioVeiculo> listaUsuarioProduto;

    @FXML
    private TableColumn<UsuarioVeiculo,String> tId;

    @FXML
    private TableColumn<UsuarioVeiculo,String> tIdU;
    
    @FXML
    private TableColumn<UsuarioVeiculo,String> tLogin;
    
    @FXML
    private TableColumn<UsuarioVeiculo,String> tVeiculo;
    
    @FXML
    private TableColumn<UsuarioVeiculo,String> tIdV;
    
    @FXML
    private TableColumn<UsuarioVeiculo,String> tObs;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;
    
    @FXML
    private ComboBox<String> comboBoxUsuarios;

    @FXML
    private ComboBox<String> comboBoxProdutos;

    ControllerUsuarioVeiculo usuProdCont = null;
    
    ObservableList<UsuarioVeiculo> oList = null;

    List<UsuarioVeiculo> lista = null;
    
    public static UsuarioVeiculo usuProdSaidaTela = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
        try {
            popularComboBoxProdutos();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
    
    private void initComponentes (){

        usuProdCont = new ControllerUsuarioVeiculo();

        btConsultar.setOnAction((ActionEvent event) -> {
            UsuarioVeiculo usuProd = new UsuarioVeiculo(txtObs.getText());
            try {
                montaLista(usuProd);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition pos = listaUsuarioProduto.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                setUsuarioVeiculo(listaUsuarioProduto.getItems().get(row));
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/relacoes/AlterarRelacaoInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaUsuarioProduto.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            UsuarioVeiculo usuProd = listaUsuarioProduto.getItems().get(row);
            try {
                usuProdCont.excluir(usuProd);
                listaUsuarioProduto.getItems().remove(row);
                JOptionPane.showMessageDialog(null, "Relacão deletada");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro ao Excluir");

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
                    Logger.getLogger(ConsultarRelacaoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });   
    }
    
    public void montaLista(UsuarioVeiculo usuProd) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = usuProdCont.listar(usuProd);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            ControllerUsuarioVeiculo usuProdCont = new ControllerUsuarioVeiculo();
            UsuarioVeiculo usuProdMod = (UsuarioVeiculo) objLista;
            usuProdMod = (UsuarioVeiculo) usuProdCont.buscar(objLista);
            
            System.out.println(usuProdMod);
            lista.add(usuProdMod);
        }
        
        oList = FXCollections.observableArrayList(lista);
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tIdU.setCellValueFactory(new PropertyValueFactory<>("idU"));
        tLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        tIdV.setCellValueFactory(new PropertyValueFactory<>("idV"));
        tVeiculo.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
        tObs.setCellValueFactory(new PropertyValueFactory<>("obs"));
        listaUsuarioProduto.setItems(oList);
    }
    
    private void popularComboBoxProdutos() throws SQLException, ClassNotFoundException {
    ControllerVeiculo prodCont = new ControllerVeiculo();
    List<Object> listaProdutos = prodCont.listar(new Veiculo());
    for (Object obj : listaProdutos) {
        Veiculo produto = (Veiculo) obj;
        comboBoxProdutos.getItems().add(produto.getModelo());
        }
    }

    public void setUsuarioVeiculo(UsuarioVeiculo usuProd) {
        this.usuProdSaidaTela = usuProd;
    }
    
    public UsuarioVeiculo getUsuarioVeiculo() {
        return this.usuProdSaidaTela;
    }
}
