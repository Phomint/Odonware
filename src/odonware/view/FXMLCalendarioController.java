package odonware.view;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXMLCalendarioController
 * @author Patrick Amaral
 * @since FXMLController criado em 10/08/2017
 */
public class FXMLCalendarioController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button fabNovoAgendamento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } //fim do metodo initialize

    @FXML
    private void abrirAgendamento(ActionEvent event) {
            System.out.println("FAB -> agendamento");
            try {
           JFXDialogLayout cadastro = FXMLLoader.load(getClass().getResource("fxml/FXMLAgendar.fxml"));
           JFXDialog dialog = new JFXDialog(stackPane, cadastro, JFXDialog.DialogTransition.CENTER);
         
           dialog.show();
                  
              } catch (Exception e) {
                  System.out.println("Erro"+e);
            }//fim do catch
    }//fim do metodo abrirAgendamento
    
}//fim do FXMLCalendarioController
