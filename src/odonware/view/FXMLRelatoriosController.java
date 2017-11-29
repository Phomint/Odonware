/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Ana Carolina Santos
 */
public class FXMLRelatoriosController implements Initializable {

    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private JFXButton btnImprimir;
    @FXML
    private JFXComboBox<String> cbEscolha;
    @FXML
    private JFXButton btnCancelar;
    
    private ObservableList<String> observableListRelatorio = FXCollections.observableArrayList("Agenda","Pagamento");
    @FXML
    private StackPane stackPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      cbEscolha.setItems(observableListRelatorio);
    }    

    @FXML
    private void ImprimirView(ActionEvent event) {
    }

    @FXML
    private void pressed(KeyEvent event) {
    }

    @FXML
    private void CancelarRelatorio(ActionEvent event) {
    }


    public String getCbEscolha() {
        return cbEscolha.getSelectionModel().getSelectedItem();
    }

    
    
}
