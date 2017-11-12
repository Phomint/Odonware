package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import odonware.controller.PacienteController;
import odonware.model.CPF;
import odonware.model.Data;
import odonware.model.RG;
import odonware.model.Telefone;

/**
 * FXMLCadastrarPacienteController
 * @author Patrick Amaral
 * @since FXMLController criado em 11/06/2017
 */
public class FXMLCadastrarPacienteController implements Initializable {

    @FXML
    private JFXDialogLayout conteudo;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtRg;
    @FXML
    private JFXTextField txtCpf;
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
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnResponsavel;
    @FXML
    private JFXTextField txtDoenca;
    @FXML
    private JFXTextField txtObservacao;
    @FXML
    private JFXTextField txtNascimento;
    @FXML
    private JFXComboBox<String> cbSanguineo;
    
    private ObservableList<String> observableListSanguineo = FXCollections.observableArrayList("A+","A-","B+","B-","AB+","AB-","O+","O-");

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbSanguineo.setItems(observableListSanguineo);
        txtCpf.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                
                if(newValue){
                    txtCpf.setStyle("-fx-text-fill: ch#545454");
                }else{        
          CPF valida = new CPF(getTxtCpf());
        if(valida.isCPF()){
            setTxtCpf(valida.getCPF(true));
        }else{
            txtCpf.setStyle("-fx-text-fill: #f24343");
        }//fim do else2
                }//fim do else1
               
            }//fim do metodo changed
            
        });//fim do ChangeListener
        txtRg.focusedProperty().addListener(new ChangeListener<Boolean>(){
             @Override
              public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                  if(newValue){
                    txtRg.setStyle("-fx-text-fill: #545454");
                }else{        
                      RG validaRG = new RG(getTxtRg());
                  if(validaRG.isRG()){
                      setTxtRg(validaRG.getRG(true));
                  }else{
                      txtRg.setStyle("-fx-text-fill: #f24343");
                  }//fim do else2
                }//fim do else 1
              }// fim do changed
        });// fim do ChangeListener
        
        txtTelefone.focusedProperty().addListener(new ChangeListener<Boolean>(){
             @Override
              public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                  if(newValue){
                    txtTelefone.setStyle("-fx-text-fill: #545454");
                }else{        
                      Telefone validaTelefone = new Telefone(getTxtTelefone());
                  if(validaTelefone.isTelefone()){
                      setTxtTelefone(validaTelefone.getTelefone(true));
                  }else{
                      txtTelefone.setStyle("-fx-text-fill: #f24343");
                  }//fim do else2
                }//fim do else 1
              } // fim do metodo changed
        }); // fim do ChangeListener
        
         txtNascimento.focusedProperty().addListener(new ChangeListener<Boolean>(){
             @Override
              public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                  if(newValue){
                    txtNascimento.setStyle("-fx-text-fill: #545454");
                }else{        
                      Data validaData = new Data(getTxtNascimento());
                  if(validaData.isData()){
                      setTxtNascimento(validaData.getData(true));
                  }else{
                      txtNascimento.setStyle("-fx-text-fill: #f24343");
                  }//fim do else2
                }//fim do else 1
              } // fim do metodo changed
        }); // fim do ChangeListener
    }//fim do initialize

    @FXML
    private void salvarView(ActionEvent event) {
        PacienteController.salvarPaciente(getTxtNome(), getTxtNascimento(),
                getTxtCpf(), getTxtRg(), getTxtTelefone(), getTxtEndereco(), 
                getTxtNumero(), getTxtBairro(), getTxtCidade(), getCbSanguineo(),
                getTxtDoenca(), getTxtObservacao());
    }//fim do salvarView

    @FXML
    private void cancelarCadastro(ActionEvent event) {
    }

    @FXML
    private void adicionarCamposResponsavel(ActionEvent event) {
    }
   
    public String getTxtNome() {
        return txtNome.getText();
    }

    public void setTxtNome(String txtNome) {
        this.txtNome.setText(txtNome);
    }

    public String getTxtRg() {
        return txtRg.getText();
    }

    public void setTxtRg(String txtRg) {
        this.txtRg.setText(txtRg);
    }

    public String getTxtCpf() {
        return txtCpf.getText();
    }

    public void setTxtCpf(String txtCpf) {
        this.txtCpf.setText(txtCpf);
    }

    public String getTxtEndereco() {
        return txtEndereco.getText();
    }

    public void setTxtEndereco(String txtEndereco) {
        this.txtEndereco.setText(txtEndereco);
    }

    public int getTxtNumero() {
        return Integer.valueOf(txtNumero.getText());
    }

    public void setTxtNumero(String txtNumero) {
        this.txtNumero.setText(txtNumero);
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

    public String getTxtDoenca() {
        return txtDoenca.getText();
    }

    public void setTxtDoenca(String txtDoenca) {
        this.txtDoenca.setText(txtDoenca);
    }

    public String getTxtObservacao() {
        return txtObservacao.getText();
    }

    public void setTxtObservacao(String txtObservacao) {
        this.txtObservacao.setText(txtObservacao);
    }
    //REVER
    public String getTxtNascimento() {
        return txtNascimento.getText();
    }

    public void setTxtNascimento(String txtNascimento) {
        this.txtNascimento.setText(txtNascimento);
    }

    public String getCbSanguineo() {
        return cbSanguineo.getSelectionModel().getSelectedItem();
    }

}//fim do FXMLCadastrarPacienteController
