package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
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
import odonware.controller.OrcamentoController;
import odonware.model.Paciente;
import odonware.model.ServicoDentista;
import odonware.model.dao.PacienteDAO;
import odonware.model.dao.ServicoDentistaDAO;

/**
 * FXML Controller class
 *
 * @author Patrick Amaral
 */
public class FXMLCadastrarOrcamentoController implements Initializable {

    @FXML
    private JFXDialogLayout conteudo;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private JFXComboBox<Paciente> cbPaciente;
    @FXML
    private JFXComboBox<ServicoDentista> cbServico;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnCancelar;
    
    private PacienteDAO pDao = new PacienteDAO();
    
    private List<Paciente> pacientes = pDao.readPacienteOrdem();
    
    private ObservableList<Paciente> observableListPacientes = FXCollections.observableArrayList();
    
    private ServicoDentistaDAO sdDao = new ServicoDentistaDAO();
    
    private List<ServicoDentista> servicosdentistas = sdDao.readServicoDentistaOrdem();
    
    private ObservableList<ServicoDentista> observableListServicosDentistas = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       for(Paciente paciente: pacientes){
                     observableListPacientes.add(paciente);
                   }//fim do for
       cbPaciente.setItems(observableListPacientes);
       
        for(ServicoDentista servicodentista: servicosdentistas){
                     observableListServicosDentistas.add(servicodentista);
                   }//fim do for
       cbServico.setItems(observableListServicosDentistas);
       
      
      
      cbServico.focusedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                
                if(oldValue){
                    txtValor.setText(String.valueOf(getCbServicoDentista().getValor()));
                }else{        
                    txtValor.setText("");
                }//fim do else
            }//fim do metodo change
        });//fim do ChangeListener
    }//fim do initialize

    @FXML
    private void salvarView(ActionEvent event) {
         JFXSnackbar snack = new JFXSnackbar(stackPane);
        
        
      try {
     //Salvar no banco
         OrcamentoController.salvarOrcamento(getTxtValor(), getCbPaciente(), getCbServicoDentista());
          snack.show("                Salvo com Sucesso                ", 5000);
      
 
        }catch (Exception e) {
       snack.show("                Preencha os campos                ", 7000);
        }
  
    }//fim do metodo salvarView

    @FXML
    private void cancelarCadastro(ActionEvent event) {
    }

    public Paciente getCbPaciente() {
        return cbPaciente.getSelectionModel().getSelectedItem();
    }

    public ServicoDentista getCbServicoDentista() {
        return cbServico.getSelectionModel().getSelectedItem();
    }

    public Float getTxtValor() {
        return Float.valueOf(txtValor.getText());
    }

  
}// fim da classe
