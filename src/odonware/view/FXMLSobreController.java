/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonware.view;

import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Patrick Amaral
 */
public class FXMLSobreController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private JFXDialogLayout conteudo;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private ImageView imgPatrick;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
