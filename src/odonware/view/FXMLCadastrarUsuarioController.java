package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import odonware.controller.UsuarioController;
import odonware.model.CPF;
import odonware.model.RG;
import odonware.model.Telefone;

/**
 * FXML Controller class
 * @author Patrick Amaral
 * @since FXMLController criado em 05/06/2017
 */
public class FXMLCadastrarUsuarioController implements Initializable {

    @FXML
    private JFXDialogLayout conteudo;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtRg;
    @FXML
    private JFXTextField txtCpf;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtLogin;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnDentista;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtNumero;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private StackPane stackPane;
    @FXML
    private HBox hboxDentista;
    @FXML
    private JFXTextField txtCro;
    @FXML
    private JFXTextField txtEspecialidade;
    @FXML
    private JFXTextField txtCidade;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         txtCpf.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                
                if(newValue){
                    txtCpf.setStyle("-fx-text-fill: #545454");
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
              } // fim do metodo changed
        }); // fim do ChangeListener
         
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
         
    }  // fim do initialize  

    
    
    @FXML
    private void salvarView(ActionEvent event) {
        
        if(txtCro.getText().isEmpty() && txtEspecialidade.getText().isEmpty()){
         UsuarioController.salvarFuncionario(getTxtNome(), getTxtRg(),
                 getTxtCpf(),getTxtEndereco(), getTxtNumero(), getTxtBairro(),
                 getTxtCidade(), getTxtTelefone(), getTxtEmail(), getTxtLogin(),
                 getTxtSenha());
        }else{
        UsuarioController.salvarDentista(getTxtCro(), getTxtEspecialidade(), 
          getTxtNome(), getTxtRg(), getTxtCpf(), getTxtEndereco(), getTxtNumero(),
          getTxtBairro(), getTxtCidade(), getTxtTelefone(), getTxtEmail(),getTxtLogin(),
          getTxtSenha());
        }//fim do else
        
    }//fim do metodo salvarView
  
    @FXML
    private void adicionarCamposDentista(ActionEvent event) {
        if(hboxDentista.isVisible()){
         setTxtCro("");
         setTxtEspecialidade("");
         
         hboxDentista.setVisible(false);
         btnDentista.setText("DENTISTA");
         
        }else{
         hboxDentista.setVisible(true);
         btnDentista.setText("FUNCIONÁRIO");
         
        }
    }//fim do metodo adicionarCamposDentista
      @FXML
      private void cancelarCadastro (ActionEvent event) {
        
      }//fim do metodo cancelarCadastro
      
    //SETTER E GETTER
    public String getTxtRg() {
        return txtRg.getText().trim();
    }

    public void setTxtRg(String txtRg) {
        this.txtRg.setText(txtRg);
    }

    public String getTxtCpf() {
        return txtCpf.getText().trim();
    }

    public void setTxtCpf(String txtCpf) {
        this.txtCpf.setText(txtCpf);
    }

    public String getTxtEmail() {
        return txtEmail.getText().trim();
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail.setText(txtEmail);
    }

    public String getTxtLogin() {
        return txtLogin.getText().trim();
    }

    public void setTxtLogin(String txtLogin) {
        this.txtLogin.setText(txtLogin); 
    }

    public String getTxtSenha() {
        return UsuarioController.criptografarSenha(txtSenha.getText().trim());
    }

    public void setTxtSenha(String txtSenha) {
        this.txtSenha.setText(txtSenha);
    }

    public String getTxtEndereco() {
        return txtEndereco.getText().trim();
    }

    public void setTxtEndereco(String txtEndereco) {
        this.txtEndereco.setText(txtEndereco);
    }

    public Integer getTxtNumero() {
        return Integer.parseInt(txtNumero.getText().trim());
    }

    public void setTxtNumero(String txtNumero) {
        this.txtNumero.setText(txtNumero);
    }

    public String getTxtBairro() {
        return txtBairro.getText().trim();
    }

    public void setTxtBairro(String txtBairro) {
        this.txtBairro.setText(txtBairro);
    }

    public String getTxtTelefone() {
        return txtTelefone.getText().trim();
    }

    public void setTxtTelefone(String txtTelefone) {
        this.txtTelefone.setText(txtTelefone);
    }

    public String getTxtNome() {
        return txtNome.getText().trim();
    }

    public void setTxtNome(String txtNome) {
        this.txtNome.setText(txtNome);
    }

    public int getTxtCro() {
        return Integer.parseInt(txtCro.getText().trim());
    }

    public void setTxtCro(String txtCro) {
        this.txtCro.setText(txtCro);
    }

    public String getTxtEspecialidade() {
        return txtEspecialidade.getText().trim();
    }

    public void setTxtEspecialidade(String txtEspecialidade) {
        this.txtEspecialidade.setText(txtEspecialidade);
    }

    public String getTxtCidade() {
        return txtCidade.getText().trim();
    }

    public void setTxtCidade(String txtCidade) {
        this.txtCidade.setText(txtCidade);
    }

}//fim do FXMLController