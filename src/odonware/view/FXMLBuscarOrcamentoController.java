package odonware.view;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import odonware.model.Orcamento;
import odonware.model.dao.OrcamentoDAO;

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
    private TableView<Orcamento> tblOrcamento;
    @FXML
    private Button fabCadastrarOrcamento;
    
     private final OrcamentoDAO oDao = new OrcamentoDAO();
      
    private final List<Orcamento> listOrcamento = oDao.readOrcamentosOrdem();
    
    private final ObservableList<Orcamento> observableOrcamento = FXCollections.observableArrayList();
    
    private List<Orcamento> listNomeP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        insereTable();
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
    }//fim do metodo abrirCadastro
    
     private void insereTable(){
       tblOrcamento.getItems().clear();
        if (!observableOrcamento.isEmpty()) {
            observableOrcamento.clear();
        }//fim do if
        for(Orcamento orcamento: listOrcamento){
            observableOrcamento.add(orcamento);
        }//fim do for
        TableColumn<Orcamento, Integer>colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject());
        TableColumn<Orcamento, String>colPaciente = new TableColumn("Paciente");
        colPaciente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPaciente().getNome()));
       TableColumn<Orcamento, String>colServico = new TableColumn("Servico");
       colServico.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getServicoDentista().getServico().getNome()));
       TableColumn<Orcamento, String>colDentista = new TableColumn("Dentista");
       colDentista.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getServicoDentista().getDentista().getNome()));
      
       tblOrcamento.getColumns().addAll(colCodigo, colPaciente, colServico, colDentista);
       tblOrcamento.setItems(observableOrcamento);
    }//fim do insereDados

    @FXML
    
    private void pressed(KeyEvent event) {
        /*listNomeP = oDao.buscarPorNome(txtBuscar.getText());
       tblOrcamento.getColumns().clear();
       tblOrcamento.getItems().clear();
        if (!observableOrcamento.isEmpty()) {
            observableOrcamento.clear();
        }//fim do if
        for(Orcamento orcamento: listNomeP){
            observableOrcamento.add(orcamento);
        }//fim do for
        TableColumn<Orcamento, Integer>colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject());
        TableColumn<Orcamento, String>colPaciente = new TableColumn("Paciente");
        colPaciente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPaciente().getNome()));
       TableColumn<Orcamento, String>colServico = new TableColumn("Servico");
       colServico.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getServicoDentista().getServico().getNome()));
       TableColumn<Orcamento, String>colDentista = new TableColumn("Dentista");
       colDentista.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getServicoDentista().getDentista().getNome()));
      
       tblOrcamento.getColumns().addAll(colCodigo, colPaciente, colServico, colDentista);
       tblOrcamento.setItems(observableOrcamento);
      */  
    }

}//fim da classe
