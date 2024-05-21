package projetofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bruno Pequeno
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class ProjetoFX extends Application {
    
    private static Stage stage;
    
    public static void main(String[] args) {
        Application.launch(ProjetoFX.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/fatec/xmls/LoginInterface.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }  
}
