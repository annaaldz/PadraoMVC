package br.com.fatec.telas.produtos;

import br.com.fatec.telas.*;
import padraomvc.model.bean.Veiculo;
import padraomvc.controller.ControllerVeiculo;
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
public class ConsultarProdutoInterface implements Initializable {

    @FXML
    private Label lbNome;

    @FXML
    private TextField txtNome;

    @FXML
    private TableView<Veiculo> listaProduto;

    @FXML
    private TableColumn<Veiculo,String> tid;

    @FXML
    private TableColumn<Veiculo,String> tNome;
    
    @FXML
    private TableColumn<Veiculo,String> tCor;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;

    ControllerVeiculo prodCont = null;
    
    ObservableList<Veiculo> oList = null;

    List<Veiculo> lista = null;
    
    public static Veiculo prodSaidaTela = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        prodCont = new ControllerVeiculo();

        btConsultar.setOnAction((ActionEvent event) -> {
            Veiculo prod = new Veiculo(txtNome.getText());
            try {
                montaLista(prod);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition pos = listaProduto.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                setVeiculo(listaProduto.getItems().get(row));
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/produtos/AlterarProdutoInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaProduto.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Veiculo usu = listaProduto.getItems().get(row);
            try {
                prodCont.excluir(usu);
                listaProduto.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ConsultarProdutoInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });   
    }
    
    public void montaLista(Veiculo prod) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = prodCont.listar(prod);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            lista.add((Veiculo) objLista);
        }

        oList = FXCollections.observableArrayList(lista);
        tid.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("id"));
        tNome.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("modelo"));
        tCor.setCellValueFactory(new PropertyValueFactory<Veiculo,String>("cor"));
        listaProduto.setItems(oList);
    }

    public void setVeiculo(Veiculo prodP) {
        this.prodSaidaTela = prodP;
    }
    
    public Veiculo getVeiculo() {
        return this.prodSaidaTela;
    }
}
