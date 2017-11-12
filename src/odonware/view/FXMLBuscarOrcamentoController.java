package odonware.view;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Patrick Amaral
 */
public class FXMLBuscarOrcamentoController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXTextField txtBuscar;
    @FXML
    private TableView<?> tblOrcamento;
    @FXML
    private Button fabCadastrarOrcamento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrirCadastro(ActionEvent event) {
        System.out.println("FAB -> orcamentos");
            try {
                JFXDialogLayout cadastro = FXMLLoader.load(getClass().getResource("fxml/FXMLCadastrarOrcamento.fxml"));
                JFXDialog dialog = new JFXDialog(stackPane, cadastro, JFXDialog.DialogTransition.CENTER);
         
                 
           dialog.show();
                  
              } catch (Exception e) {
                  System.out.println("Erro"+e);
            }//fim do catch
    }
    
}
