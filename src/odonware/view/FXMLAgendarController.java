package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import odonware.controller.AgendamentoController;
import odonware.model.Dentista;
import odonware.model.Paciente;
import odonware.model.dao.DentistaDAO;
import odonware.model.dao.PacienteDAO;

/**
 * FXML Controller class
 * @author Patrick Amaral
 * @since FXMLController criado em 14/06/2017
 */
public class FXMLAgendarController implements Initializable {

    @FXML
    private JFXDialogLayout conteudo;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private JFXComboBox<String> cbPaciente;
    @FXML
    private JFXTimePicker tpHora;
    @FXML
    private JFXDatePicker dpData;
    @FXML
    private JFXComboBox<String> cbDentista;
    @FXML
    private JFXComboBox<String> cbAtendimento;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnCancelar;
    
    //Pegando DAO
    private PacienteDAO pDao = new PacienteDAO();
    private DentistaDAO dDao = new DentistaDAO();
    //Criando List para passar para observableList
    private List<Paciente> pacientes = pDao.readPacienteOrdem();
    private List<Dentista> dentistas = dDao.readDentistaOrdem();
    //Criando o ObservableList
    private ObservableList<String> observableListPacientes = FXCollections.observableArrayList();
    private ObservableList<String> observableListDentistas = FXCollections.observableArrayList();
    private ObservableList<String> observableListAtendimento = FXCollections.observableArrayList("Consulta","Orçamento");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    inserirDentistaComboBox();
    inserirPacienteComboBox();
    cbAtendimento.setItems(observableListAtendimento);
    }//fim do initialize

    @FXML
    private void salvarView(ActionEvent event) {
         JFXSnackbar snack = new JFXSnackbar(stackPane);
        
        
      try {
     //Salvar no banco
        AgendamentoController.salvarAgendamento(getCbPaciente(), getDpData(), getTpHora(), getCbDentista(), getCbAtendimento());
         snack.show("                Salvo com Sucesso                ", 5000);
      
 
        }catch (Exception e) {
       snack.show("                Preencha os campos                ", 7000);
        }
    }//fim do salvarView

    @FXML
    private void cancelarCadastro(ActionEvent event) {
       
    }//fim do cancelarCadastro
    
    private void inserirPacienteComboBox(){
          for(Paciente paciente: pacientes){
            observableListPacientes.add(paciente.getNome());
         }//fim do for
        cbPaciente.setItems(observableListPacientes);
    
    }//fim do metodo
    private void inserirDentistaComboBox(){
         for(Dentista dentista: dentistas){
            observableListDentistas.add(dentista.getNome());
         }//fim do for
        cbDentista.setItems(observableListDentistas);
    }//fim do metodo         

    
    //SETTER E GETTER
    public String getDpData() {
        return dpData.getValue().toString();
       
    }
    public void setDpData(String dpData) {
        this.dpData.setValue(LocalDate.MAX);
    }

    public String getCbPaciente() {
        return cbPaciente.getSelectionModel().getSelectedItem();
    }

    public String getTpHora() {
        return tpHora.getValue().toString();
    }

    public void setTpHora(JFXTimePicker tpHora) {
        this.tpHora = tpHora;
    }

    public String getCbDentista() {
        return cbDentista.getSelectionModel().getSelectedItem();
    }

    public String getCbAtendimento() {
        return cbAtendimento.getSelectionModel().getSelectedItem();
    }

    public void setCbAtendimento(JFXComboBox<String> cbAtendimento) {
        this.cbAtendimento = cbAtendimento;
    }
   
}//fim do FXMLController
