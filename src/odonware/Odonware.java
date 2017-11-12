package odonware;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe main que gera o start da aplicação
 * @author Patrick Amaral
 * @since Classe criada em 31/05/2017
 */
public class Odonware extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("view/fxml/FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);
       
        stage.setScene(scene);
      
        stage.show();
        
       
    }//fim do start

    public static void main(String[] args) {
        launch(args);
    }//fim do main
     
}//fim da classe Odonware
