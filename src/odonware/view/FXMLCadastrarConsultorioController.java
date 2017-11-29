/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Patrick Amaral
 */
public class FXMLCadastrarConsultorioController implements Initializable {

    @FXML
    private JFXDialogLayout conteudo;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtNumero;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtCidade;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private HBox hboxDentista;
    @FXML
    private JFXTextField txtCro;
    @FXML
    private JFXTextField txtEspecialidade;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXTextField txtRazaoSocial;
    @FXML
    private JFXTextField txtCnpj;
    @FXML
    private JFXTextField txtInscricao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvarView(ActionEvent event) {
     txtNome.setEditable(true);
     txtRazaoSocial.setEditable(true);
     txtBairro.setEditable(true);
     txtCidade.setEditable(true);
     txtCnpj.setEditable(true);
     txtCro.setEditable(true);
     txtEmail.setEditable(true);
     txtEspecialidade.setEditable(true);
     txtTelefone.setEditable(true);
     txtInscricao.setEditable(true);
     btnSalvar.setText("SALVAR");
    }

    @FXML
    private void cancelarCadastro(ActionEvent event) {
    }

    
}
