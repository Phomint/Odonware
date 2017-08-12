package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import odonware.controller.UsuarioController;
import odonware.controller.LoginController;

/**
 * FXMLController para efetuar um login
 * @author Patrick Amaral
 * @since FXMLController criado em 07/06/2017
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXButton btnLogar;
    @FXML
    private ImageView imgProgress;
    @FXML
    private Label lblErro;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void validarLogin(ActionEvent event) {
        imgProgress.setVisible(true);
        lblErro.setVisible(false);
        System.out.println("botão >> logar");
       
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(3));
        pauseTransition.setOnFinished(ev -> {
             if(LoginController.efetuarLogin(getTxtUsuario(), getTxtSenha())){
            abrirFXMLLogin();
               
           }else{
           imgProgress.setVisible(false);
           lblErro.setVisible(true);
        }//fim do else
        });
        pauseTransition.play();
    }//fim do validarLogin
      public void abrirFXMLLogin(){
          btnLogar.getScene().getWindow().hide();
          try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/FXMLPrincipal.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setMaximized(true);
           
            stage.show();
          } catch (IOException e) {
              System.out.println("Erro abrirFXMLLogin ->"+e);
        }
     }//fim do metodo abriFXMLLogin
     
    
    //SETTER E GETTER
    public String getTxtUsuario() {
        return txtUsuario.getText();
    }

    public void setTxtUsuario(String txtUsuario) {
        this.txtUsuario.setText(txtUsuario);
    }

    public String getTxtSenha() {
        return UsuarioController.criptografarSenha(txtSenha.getText());
    }

    public void setTxtSenha(String txtSenha) {
        this.txtSenha.setText(txtSenha);
    }
    
}//fim do FXMLController
