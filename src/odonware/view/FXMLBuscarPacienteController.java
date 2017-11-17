package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import odonware.model.Paciente;
import odonware.model.dao.PacienteDAO;

/**
 * FXMLBuscarPacienteController
 * @author Patrick Amaral
 * @since FXMLController criado em 05/07/2017
 */
public class FXMLBuscarPacienteController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<Paciente> tblPaciente;
    @FXML
    private Button fabCadastrarUsuario;
    @FXML
    private JFXTextField txtBuscar; 
    @FXML
    private JFXButton btnEditar;
    @FXML
    private ImageView btnExcluir;
    
     private final PacienteDAO pDao = new PacienteDAO();
      
    private final List<Paciente> listPaciente = pDao.readPacienteOrdem();
    
    private List<Paciente> listNomes;
    
    private final ObservableList<Paciente> observablePaciente = FXCollections.observableArrayList();
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       insereTable();
    }    

    @FXML
    private void abrirCadastro(ActionEvent event) {

         System.out.println("FAB -> paciente");
            try {
           JFXDialogLayout cadastro = FXMLLoader.load(getClass().getResource("fxml/FXMLCadastrarPaciente.fxml"));
           JFXDialog dialog = new JFXDialog(stackPane, cadastro, JFXDialog.DialogTransition.CENTER);
         
           dialog.show();
                  
              } catch (Exception e) {
                  System.out.println("Erro"+e);
            }//fim do catch
    }//fim do metodo abrirCadastro
    private void insereTable(){
       tblPaciente.getItems().clear();
        if (!observablePaciente.isEmpty()) {
            observablePaciente.clear();
        }//fim do if
        for(Paciente paciente: listPaciente){
            observablePaciente.add(paciente);
        }//fim do for
        TableColumn<Paciente, Integer>colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject());
        TableColumn<Paciente, String>colPaciente = new TableColumn("Paciente");
        colPaciente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
       TableColumn<Paciente, String>colCPF = new TableColumn("CPF");
       colCPF.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCpf()));
       TableColumn<Paciente, String>colCidade = new TableColumn("Cidade");
       colCidade.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCidade()));
       TableColumn<Paciente, String>colTelefone = new TableColumn("Telefone");
       colTelefone.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelefone()));
      
       tblPaciente.getColumns().addAll(colCodigo, colPaciente, colCPF, colCidade, colTelefone);
       tblPaciente.setItems(observablePaciente);
    }//fim do insereDados

    @FXML
    private void editar(ActionEvent event) {
         abrirCadastro(event);
    }

    @FXML
    private void excluir(MouseEvent event) {
    }

    @FXML
    private void pressed(KeyEvent event) {
       listNomes = pDao.buscarPorNome(txtBuscar.getText());
       tblPaciente.getColumns().clear();
       tblPaciente.getItems().clear();
        if (!observablePaciente.isEmpty()) {
            observablePaciente.clear();
        }//fim do if
        for(Paciente paciente: listNomes){
            observablePaciente.add(paciente);
        }//fim do for
        TableColumn<Paciente, Integer>colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject());
        TableColumn<Paciente, String>colPaciente = new TableColumn("Paciente");
        colPaciente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
       TableColumn<Paciente, String>colCPF = new TableColumn("CPF");
       colCPF.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCpf()));
       TableColumn<Paciente, String>colCidade = new TableColumn("Cidade");
       colCidade.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCidade()));
       TableColumn<Paciente, String>colTelefone = new TableColumn("Telefone");
       colTelefone.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelefone()));
      
       tblPaciente.getColumns().addAll(colCodigo, colPaciente, colCPF, colCidade, colTelefone);
       tblPaciente.setItems(observablePaciente);
    }

    @FXML
    private void typed(KeyEvent event) {
    
    }

    
}//fim do FXMLController 
