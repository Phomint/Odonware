/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import odonware.controller.ConsultorioController;

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
    private JFXTextField txtNomeFantasia;
    @FXML
    private JFXTextField txtRazaoSocial;
    @FXML
    private JFXTextField txtCnpj;
    @FXML
    private JFXTextField txtInscricaoEstadual;
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
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvarView(ActionEvent event) {
        ConsultorioController.salvarConsultorio(getTxtNomeFantasia(),
                getTxtRazaoSocial(), getTxtCnpj(), getTxtInscricaoEstadual(),
                getTxtEndereco(), getTxtNumero(), getTxtBairro(), getTxtCidade(),
                getTxtTelefone(), getTxtEmail());
    }//fim do salvarView

    @FXML
    private void cancelarCadastro(ActionEvent event) {
    }

    public String getTxtNomeFantasia() {
        return txtNomeFantasia.getText();
    }

    public void setTxtNomeFantasia(String txtNomeFantasia) {
        this.txtNomeFantasia.setText(txtNomeFantasia);
    }

    public long getTxtCnpj() {
        return Long.parseLong(txtCnpj.getText());
    }

    public void setTxtCnpj(String txtCnpj) {
        this.txtCnpj.setText(txtCnpj);
    }

    public int getTxtInscricaoEstadual() {
        return Integer.parseInt(txtInscricaoEstadual.getText());
    }

    public void setTxtInscricaoEstadual(String txtInscricaoEstadual) {
        this.txtInscricaoEstadual.setText(txtInscricaoEstadual);
    }

    public String getTxtEndereco() {
        return txtEndereco.getText();
    }

    public void setTxtEndereco(String txtEndereco) {
        this.txtEndereco.setText(txtEndereco);
    }

    public String getTxtBairro() {
        return txtBairro.getText();
    }

    public void setTxtBairro(String txtBairro) {
        this.txtBairro.setText(txtBairro);
    }

    public String getTxtCidade() {
        return txtCidade.getText();
    }

    public void setTxtCidade(String txtCidade) {
        this.txtCidade.setText(txtCidade);
    }

    public String getTxtTelefone() {
        return txtTelefone.getText();
    }

    public void setTxtTelefone(String txtTelefone) {
        this.txtTelefone.setText(txtTelefone);
    }

    public String getTxtEmail() {
        return txtEmail.getText();
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail.setText(txtEmail);
    }

    public String getTxtRazaoSocial() {
        return txtRazaoSocial.getText();
    }

    public void setTxtRazaoSocial(String txtRazaoSocial) {
        this.txtRazaoSocial.setText(txtRazaoSocial);
    }

    public int getTxtNumero() {
        return Integer.parseInt(txtNumero.getText());
    }

    public void setTxtNumero(String txtNumero) {
        this.txtNumero.setText(txtNumero);
    }
    
    

}
